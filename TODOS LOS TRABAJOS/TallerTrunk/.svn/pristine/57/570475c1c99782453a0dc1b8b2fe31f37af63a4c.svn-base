package com.ipartek.formacion.taller.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.taller.modelo.config.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Modelo;
import com.mysql.jdbc.Statement;

@Repository
public class ModeloDAO implements IDAO<Modelo> {

	private static final String SQL_GET_ALL = "SELECT id, nombre FROM taller.modelo ORDER BY id DESC;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre FROM taller.modelo WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM taller.modelo WHERE id = ?;";
	private static final String SQL_INSERT = "INSERT INTO taller.modelo (nombre) VALUES (?);";
	private static final String SQL_UPDATE = "UPDATE taller.modelo SET nombre=? WHERE id = ?;";

	
	
	// PARA METODO LISTAR (GETALL)
	@Override
	public ArrayList<Modelo> getAll() {								// NO recibe parametro
		ArrayList<Modelo> lista = new ArrayList<Modelo>();
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
	@Override
	public Modelo getById(int id) {   									// SI recibe parametro  ( UNA ID para identificar el Modelo que queremos listar)

		Modelo m = null;
		String sql = SQL_GET_BY_ID;

		try (Connection conn = ConnectionManager.getConnection(); 			// Establezco conexion
				PreparedStatement pst = conn.prepareStatement(sql);) { 		// creo objeto statement con la consulta

			// parametros de entrada en la consulta
			pst.setLong(1, id); 											// incluyo la id que recibe en la consulta

			try (ResultSet rs = pst.executeQuery()) {						// ejecuto contulta mediante EXECUTECUERY PORQUE es una SELECT

				while (rs.next()) {
					m = mapeo(rs);
				
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;														 	// devuelve un objeto con los datos del Modelo que ha encontrado en bbdd
	}
	
	
	
	// PARA  METODO ELIMINAR (DELETE)
	@Override
	public boolean delete( int id ) throws SQLException  { 					 // SI RECIBE PARAMETRO, ID  que indica que Modelo borrar
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
	@Override
	public boolean insert(Modelo modelo) throws SQLException { 	// SI recibe parametro  ( UNA ID para identificar el Modelo que queremos CREAR)
		boolean isCreate = false;

		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
			
		
			pst.setString(1, modelo.getNombre());		
				if ( pst.executeUpdate() == 1 ) { 							// UPDATE porque es INSERT
					
					// recuperar id
					try (ResultSet rs = pst.getGeneratedKeys()) {
						rs.next();
						modelo.setId(rs.getInt(1));
						isCreate = true;
						}								
				}		
		}
		return isCreate;
	}
	

	
	// PARA METODO MODIFICAR (INSERT)
	@Override
	public boolean update(Modelo modelo) throws SQLException  { 	// SI recibe parametro  ( UNA ID para identificar el Modelo que queremos MODIFICAR)
		boolean resul  = false;
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(SQL_UPDATE);
			){
		
			pst.setString(1, modelo.getNombre());
			pst.setInt(2, modelo.getId());
			
			if(  pst.executeUpdate() == 1 ){								// UPDATE porque es UPDATE
				resul = true;
			}					
		}	
		return resul; 														//  devuelve un boleano. Si se ha modificado devuelve true.
	}
	
	
	// METODO PARA MAPEO PARAMETROS, PARECIDO A ROWMAPPER 
	private Modelo mapeo(ResultSet rs) throws SQLException {
		Modelo c = new Modelo();
		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));
		return c;
	}

}
