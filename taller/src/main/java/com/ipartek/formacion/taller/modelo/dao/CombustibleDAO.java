package com.ipartek.formacion.taller.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.taller.modelo.config.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;

@Repository
public class CombustibleDAO {

	private static final String SQL_GET_ALL = "SELECT id, nombre FROM combustible ORDER BY id DESC;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre FROM combustible WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM taller.combustible WHERE id = ?;";
	private static final String SQL_CREATE = "INSERT INTO taller.combustible (nombre) VALUES (?);";

	// METODO LISTAR (GETALL)
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

	
	// METODO DETALLE (GETBYID)
	public Combustible getById(int id) {

		Combustible c = null;
		String sql = SQL_GET_BY_ID;

		try (Connection conn = ConnectionManager.getConnection(); // Establezco conexion
				PreparedStatement pst = conn.prepareStatement(sql);) { // creo objeto statement con la consulta

			// parametros de entrada en la consulta
			pst.setLong(1, id); // incluyo la id que recibe en la consulta

			try (ResultSet rs = pst.executeQuery()) { // ejecuto contulta mediante EXECUTECUERY PORQUE es una SELECT

				while (rs.next()) {
					 c = mapeo(rs);
				
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c; // devuelve un objeto con los datos del bolo que ha encontrado en bbdd
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
	

	// metodo crear (insert)
	public boolean create(Combustible combustible) throws SQLException {
		boolean isCreate = false;

		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(SQL_CREATE);){
			
		
			pst.setString(1, combustible.getNombre());
		
			
				if ( pst.executeUpdate() == 1 ) {
					isCreate = true;
					}		
		}catch (Exception e) {
			e.printStackTrace();
		 	}
		
		
			return isCreate; // devuelve un objeto con los datos del bolo que ha encontrado en bbdd
		}
	
	
	

	// metodo para mapeo parametros  en metodo listar y detalle
	private Combustible mapeo(ResultSet rs) throws SQLException {
		Combustible c = new Combustible();
		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));
		return c;
	}

}
