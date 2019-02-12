package com.ipartek.formacion.taller.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.taller.modelo.config.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;

@Repository
public class VehiculoDAO {

	private static final String SQL_GET_ALL = "SELECT id, numero_bastidor,matricula FROM vehiculo ORDER BY id DESC;";
	private static final String SQL_GET_BY_ID = "SELECT id, numero_bastidor,matricula FROM vehiculo WHERE id=?;";
	private static final String SQL_DELETE = "DELETE FROM vehiculo WHERE id=?;";
	private static final String SQL_INSERT = "INSERT INTO taller.vehiculo (numero_bastidor, matricula, id_propietario, id_combustible, id_modelo) VALUES (?, ?, ?, ?, ?);";
	private static final String SQL_UPDATE = "UPDATE combustible SET  numero_bastidor=?, matricula=? WHERE id=?;";

	
	
// PARA METODO LISTAR (GETALL)
	public ArrayList<Vehiculo> getAll() {								// NO recibe parametro
		ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>();
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
	public Vehiculo getById(int id) {   									// SI recibe parametro  ( UNA ID para identificar el Vehiculo que queremos listar)

		Vehiculo v = null;
		String sql = SQL_GET_BY_ID;

		try (Connection conn = ConnectionManager.getConnection(); 			// Establezco conexion
				PreparedStatement pst = conn.prepareStatement(sql);) { 		// creo objeto statement con la consulta

			// parametros de entrada en la consulta
			pst.setLong(1, id); 											// incluyo la id que recibe en la consulta

			try (ResultSet rs = pst.executeQuery()) {						// ejecuto contulta mediante EXECUTECUERY PORQUE es una SELECT

				while (rs.next()) {
					 v = mapeo(rs);			
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;														 	// devuelve un objeto con los datos del Vehiculo que ha encontrado en bbdd
	}
		
	
// PARA  METODO ELIMINAR (DELETE)
	public boolean delete( int id ) throws SQLException  { 					 // SI RECIBE PARAMETRO, ID  que indica que Vehiculo borrar
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
	public boolean create(Vehiculo vehiculo) throws SQLException { 	// SI recibe parametro  ( UNA ID para identificar el Vehiculo que queremos CREAR)
		boolean isCreate = false;

		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(SQL_INSERT);){		
			
			pst.setString(1, vehiculo.getNumeroBastidor());
			pst.setString(2, vehiculo.getMatricula());
			pst.setInt(3, vehiculo.getPersona().getId());
			pst.setInt(4, vehiculo.getCombustible().getId());
			pst.setInt(5, vehiculo.getModelo().getId());
		
				if ( pst.executeUpdate() == 1 ) { 							// UPDATE porque es INSERT
					isCreate = true;
					}		
		}catch (Exception e) {
			e.printStackTrace();
		 	}
			
			return isCreate; 												//  devuelve un boleano. Si se ha creado devuelve true.
		}
	
		
// PARA METODO MODIFICAR (update)
	public boolean update(Vehiculo vehiculo) throws SQLException  { 	// SI recibe parametro  ( UNA ID para identificar el Vehiculo que queremos MODIFICAR)
		boolean resul  = false;
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(SQL_UPDATE);
			){
		
			pst.setString(1, vehiculo.getNumeroBastidor());
			pst.setString(2, vehiculo.getMatricula());
			pst.setInt(3, vehiculo.getPersona().getId());
			pst.setInt(4, vehiculo.getCombustible().getId());
			pst.setInt(5, vehiculo.getModelo().getId());
			pst.setInt(6, vehiculo.getId());
			
			if(  pst.executeUpdate() == 1 ){								// UPDATE porque es UPDATE
				resul = true;
			}					
		}	
		return resul; 														//  devuelve un boleano. Si se ha modificado devuelve true.
	}
	
	
// METODO PARA MAPEO PARAMETROS, PARECIDO A ROWMAPPER 
	private Vehiculo mapeo(ResultSet rs) throws SQLException {
		
		Vehiculo v = new Vehiculo();
		v.setId(rs.getInt("id"));
		v.setNumeroBastidor(rs.getString("numero_bastidor"));
		v.setMatricula(rs.getString("matricula"));
// no recogo id-propietario , id_combustible, id_modelo porque muestro los datos del cliente, del combustible y del modelo al llamar al metodo GET en swagger.
// VER SERCICIO . en el servicio incluyo estos datos en el arraylist de vehiculos
		return v;
	}

}