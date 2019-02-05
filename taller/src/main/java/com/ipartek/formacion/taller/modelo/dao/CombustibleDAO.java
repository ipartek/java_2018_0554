package com.ipartek.formacion.taller.modelo.dao;

import java.sql.Connection;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.taller.modelo.config.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class CombustibleDAO {

	private static final String SQL_GET_ALL = "SELECT id, nombre FROM combustible ORDER BY id DESC;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre FROM combustible WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM combustible WHERE id = ?;";
	private static final String SQL_INSERT = "INSERT INTO combustible (nombre) VALUES (?);";
	private static final String SQL_UPDATE = "UPDATE combustible SET nombre=? WHERE id = ?;";

	public ArrayList<Combustible> getAll() {
		ArrayList<Combustible> lista = new ArrayList<Combustible>();
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				lista.add(mapeo(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
public Combustible getById (int id) {
		
		Combustible c = null;
		
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_BY_ID);) {
			pst.setLong(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					c = mapeo(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
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
	
	
	public boolean insert(Combustible combustible) throws SQLException {

		boolean creado = false;
		try (Connection con = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, combustible.getNombre());

			if (pst.executeUpdate() == 1) {
				ResultSet idGenerado = pst.getGeneratedKeys();
				idGenerado.next();
				combustible.setId((int) idGenerado.getLong(1));
				creado = true;
			}

		}
		return creado;
	}

	public boolean update(Combustible combustible) throws SQLException  {
		boolean resul  = false;
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(SQL_UPDATE);
			){
		
			pst.setString(1, combustible.getNombre());
			pst.setInt(2, combustible.getId());
			
			if( 1 == pst.executeUpdate() ){
				resul = true;
			}
						
		}	
		return resul;
	}
	
	private Combustible mapeo(ResultSet rs) throws SQLException {
		Combustible c = new Combustible();
		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));
		return c;
	}

}
