package com.ipartek.formacion.taller.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.taller.modelo.config.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Rol;

@Repository
public class RolDAO {

	private static final String SQL_GET_ALL = "SELECT id, nombre FROM taller.rol ORDER BY id DESC;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre FROM taller.rol WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM taller.rol WHERE id = ?;";
	private static final String SQL_CREATE = "INSERT INTO taller.rol (nombre) VALUES (?);";
	private static final String SQL_UPDATE = "UPDATE taller.rol SET nombre=? WHERE id = ?;";

	// PARA METODO LISTAR (GETALL)
	public List<Rol> getAll() { // NO recibe parametro
		ArrayList<Rol> roles = new ArrayList<Rol>();
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				roles.add(mapeo(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roles; // envia listado ArrayList
	}

	

	//  PARA METODO DETALLE (GETBYID)
	public Rol getById(int id) {   									// SI recibe parametro  ( UNA ID para identificar el combustible que queremos listar)

		Rol r = null;
		String sql = SQL_GET_BY_ID;

		try (Connection conn = ConnectionManager.getConnection(); 			// Establezco conexion
				PreparedStatement pst = conn.prepareStatement(sql);) { 		// creo objeto statement con la consulta

			// parametros de entrada en la consulta
			pst.setLong(1, id); 											// incluyo la id que recibe en la consulta

			try (ResultSet rs = pst.executeQuery()) {						// ejecuto contulta mediante EXECUTECUERY PORQUE es una SELECT

				while (rs.next()) {
					r = mapeo(rs);
				
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;														 	// devuelve un objeto con los datos del Rol que ha encontrado en bbdd
	}
	
	
	

	// PARA  METODO ELIMINAR (DELETE)
	public boolean delete( int id ) throws SQLException  { 					 // SI RECIBE PARAMETRO, ID  que indica que combustible borrar
		boolean isDelete = false;
		
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(SQL_DELETE);
			){
		
			pst.setInt(1, id);			
			if ( pst.executeUpdate() == 1 ) {
				isDelete = true;
			}			
		}	
		return isDelete;  													//  devuelve un boleano. Si se ha eliminado devuelve true.
	}
	
	
	
	// PARA  METODO CREAR (INSERT)
		public boolean create(Rol rol) throws SQLException { 	// SI recibe parametro  ( UNA ID para identificar el combustible que queremos CREAR)
			boolean isCreate = false;

			try ( Connection conn = ConnectionManager.getConnection();
				  PreparedStatement pst = conn.prepareStatement(SQL_CREATE);){
				
			
				pst.setString(1, rol.getNombre());
			
				
					if ( pst.executeUpdate() == 1 ) { 							// UPDATE porque es INSERT
						isCreate = true;
						}		
			}catch (Exception e) {
				e.printStackTrace();
			 	}
			
			
				return isCreate; 												//  devuelve un boleano. Si se ha creado devuelve true.
			}
		
		
		// PARA METODO MODIFICAR (INSERT)
		public boolean update(Rol rol) throws SQLException  { 	// SI recibe parametro  ( UNA ID para identificar el Rol que queremos MODIFICAR)
			boolean resul  = false;
			try ( Connection conn = ConnectionManager.getConnection();
				  PreparedStatement pst = conn.prepareStatement(SQL_UPDATE);
				){
			
				pst.setString(1, rol.getNombre());
				pst.setInt(2, rol.getId());
				
				if(  pst.executeUpdate() == 1 ){								// UPDATE porque es UPDATE
					resul = true;
				}					
			}	
			return resul; 														//  devuelve un boleano. Si se ha modificado devuelve true.
		}
		
	
	
	// METODO PARA MAPEO PARAMETROS, PARECIDO A ROWMAPPER
	private Rol mapeo(ResultSet rs) throws SQLException {
		Rol r = new Rol();
		r.setId(rs.getInt("id"));
		r.setNombre(rs.getString("nombre"));
		return r;
	}
} // fin