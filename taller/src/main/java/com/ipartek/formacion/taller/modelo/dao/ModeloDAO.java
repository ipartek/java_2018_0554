package com.ipartek.formacion.taller.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.taller.modelo.config.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Modelo;


@Repository
public class ModeloDAO {
	
	private static final String SQL_GET_ALL = "SELECT id, nombre FROM modelo ORDER BY id DESC;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre FROM modelo WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM modelo WHERE id = ?;";
	private static final String SQL_INSERT = "INSERT INTO modelo (nombre) VALUES (?);";
	private static final String SQL_UPDATE = "UPDATE modelo SET nombre=? WHERE id = ?;";
	
	public ArrayList<Modelo> getAll() {
		ArrayList<Modelo> lista = new ArrayList<Modelo>();
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

	public Modelo getById(int id) {

		Modelo m = null;

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_BY_ID);) {
			pst.setLong(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					m = mapeo(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return m;
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
	
	public boolean insert(Modelo modelo) throws SQLException {

		boolean creado = false;
		try (Connection con = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, modelo.getNombre());

			if (pst.executeUpdate() == 1) {
				ResultSet idGenerado = pst.getGeneratedKeys();
				idGenerado.next();
				modelo.setId((int) idGenerado.getLong(1));
				creado = true;
			}

		}
		return creado;
	}
	
	public boolean update(Modelo modelo) throws SQLException  {
		boolean resul  = false;
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(SQL_UPDATE);
			){
		
			pst.setString(1, modelo.getNombre());
			pst.setInt(2, modelo.getId());
			
			if( 1 == pst.executeUpdate() ){
				resul = true;
			}
						
		}	
		return resul;
	}

	private Modelo mapeo(ResultSet rs) throws SQLException {

		Modelo m = new Modelo();
		m.setId(rs.getInt("id"));
		m.setNombre(rs.getString("nombre"));

		return m;
	}


}
