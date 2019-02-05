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
	private static final String SQL_UPDATE = "UPDATE combustible SET nombre=? WHERE id = ?;";

	
	
	// PARA METODO LISTAR (GETALL)
	public ArrayList<Combustible> getAll() {								// NO recibe parametro
		ArrayList<Combustible> lista = new ArrayList<Combustible>();
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_ALL);
				
				
				ResultSet rs = pst.executeQuery()) {   						// QUERY porque es SELECT
			
			while (rs.next()) {
				lista.add(mapeo(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista; 														// envia listado ArrayList
	}

	
	
	//  PARA METODO DETALLE (GETBYID)
	public Combustible getById(int id) {   									// SI recibe parametro  ( UNA ID para identificar el combustible que queremos listar)

		Combustible c = null;
		String sql = SQL_GET_BY_ID;

		try (Connection conn = ConnectionManager.getConnection(); 			// Establezco conexion
				PreparedStatement pst = conn.prepareStatement(sql);) { 		// creo objeto statement con la consulta

			// parametros de entrada en la consulta
			pst.setLong(1, id); 											// incluyo la id que recibe en la consulta

			try (ResultSet rs = pst.executeQuery()) {						// ejecuto contulta mediante EXECUTECUERY PORQUE es una SELECT

				while (rs.next()) {
					 c = mapeo(rs);
				
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;														 	// devuelve un objeto con los datos del combustible que ha encontrado en bbdd
	}
	
	
	
	// PARA  METODO ELIMINAR (DELETE)
	public boolean delete( int id ) throws SQLException  { 					 // SI RECIBE PARAMETRO, ID  que indica que combustible borrar
		boolean isDelete = false;
		
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(SQL_DELETE);
			){
		
			pst.setInt(1, id);			
			if ( pst.executeUpdate() == 1 ) {   							// UPDATE porque es DELETE
				isDelete = true;
			}			
		}	
		return isDelete;  													//  devuelve un boleano. Si se ha eliminado devuelve true.
	}
	

	
	// PARA  METODO CREAR (INSERT)
	public boolean create(Combustible combustible) throws SQLException { 	// SI recibe parametro  ( UNA ID para identificar el combustible que queremos CREAR)
		boolean isCreate = false;

		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(SQL_CREATE);){
			
		
			pst.setString(1, combustible.getNombre());
		
			
				if ( pst.executeUpdate() == 1 ) { 							// UPDATE porque es INSERT
					isCreate = true;
					}		
		}catch (Exception e) {
			e.printStackTrace();
		 	}
		
		
			return isCreate; 												//  devuelve un boleano. Si se ha creado devuelve true.
		}
	
	
	
	// PARA METODO MODIFICAR (INSERT)
	public boolean update(Combustible combustible) throws SQLException  { 	// SI recibe parametro  ( UNA ID para identificar el combustible que queremos MODIFICAR)
		boolean resul  = false;
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(SQL_UPDATE);
			){
		
			pst.setString(1, combustible.getNombre());
			pst.setInt(2, combustible.getId());
			
			if(  pst.executeUpdate() == 1 ){								// UPDATE porque es UPDATE
				resul = true;
			}					
		}	
		return resul; 														//  devuelve un boleano. Si se ha modificado devuelve true.
	}
	

	
	// METODO PARA MAPEO PARAMETROS, PARECIDO A ROWMAPPER 
	private Combustible mapeo(ResultSet rs) throws SQLException {
		Combustible c = new Combustible();
		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));
		return c;
	}

}
