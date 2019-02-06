package com.ipartek.formacion.taller.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.taller.modelo.config.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Rol;

@Repository
public class RolDAO implements IDAO<Rol> {

	private static final String SQL_GET_ALL = "SELECT id, nombre FROM rol ORDER BY id DESC;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre FROM rol WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM rol WHERE id = ?;";
	private static final String SQL_INSERT = "INSERT INTO rol (nombre) VALUES (?);";
	private static final String SQL_UPDATE = "UPDATE rol SET nombre=? WHERE id = ?;";

	@Override
	public ArrayList<Rol> getAll() {
		ArrayList<Rol> lista = new ArrayList<Rol>();
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				lista.add(rowMapper(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Rol getById(int id) {

		Rol r = null;

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_BY_ID);) {
			pst.setLong(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					r = rowMapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return r;
	}
	
	@Override
	public boolean delete( int id ) throws SQLException  {
		boolean isDelete = false;
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(SQL_DELETE);
			){
		
			pst.setInt(1, id);			
			if ( pst.executeUpdate() == 1 ) {
				isDelete = true;
			}			
		}	
		return isDelete;
	}
	
	@Override
	public boolean insert(Rol rol) throws SQLException {

		boolean creado = false;
		try (Connection con = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, rol.getNombre());

			if (pst.executeUpdate() == 1) {
				ResultSet idGenerado = pst.getGeneratedKeys();
				idGenerado.next();
				rol.setId((int) idGenerado.getLong(1));
				creado = true;
			}

		}
		return creado;
	}
	
	@Override
	public boolean update(Rol rol) throws SQLException  {
		boolean resul  = false;
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(SQL_UPDATE);
			){
		
			pst.setString(1, rol.getNombre());
			pst.setInt(2, rol.getId());
			
			if( 1 == pst.executeUpdate() ){
				resul = true;
			}
						
		}	
		return resul;
	}

	private Rol rowMapper(ResultSet rs) throws SQLException {

		Rol r = new Rol();
		r.setId(rs.getInt("id"));
		r.setNombre(rs.getString("nombre"));

		return r;
	}

}
