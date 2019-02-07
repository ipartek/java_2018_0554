package com.ipartek.formacion.taller.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.taller.modelo.config.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.mysql.jdbc.Statement;

@Repository
public class CombustibleDAO implements IDAO<Combustible> {

	private static final String SQL_GET_ALL = "SELECT id, nombre FROM taller.combustible ORDER BY id DESC;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre FROM taller.combustible WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM taller.combustible WHERE id = ?;";
	private static final String SQL_UPDATE = "UPDATE taller.combustible SET nombre=? WHERE id = ?;";
	private static final String SQL_INSERT = "INSERT INTO taller.combustible (nombre) VALUES (?);";
	private static final String SQL_GET_VEHICULO_BY_ID = "select c.id, c.nombre from taller.vehiculo as v,  taller.combustible as c where  v.id_combustible= c.id and v.id = ?;";

	
	// PARA METODO LISTAR (GETALL)
	@Override
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
	@Override
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
	
	// sin @override
	public Combustible getByIdVehiculo(int id) {  // combustible que busco por id de vehiculo
	
		Combustible c = null;
		
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_VEHICULO_BY_ID);) {

			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					c = rowMapper(rs);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	
	// PARA  METODO ELIMINAR (DELETE)
	@Override
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
	@Override
	public boolean insert(Combustible combustible) throws SQLException { 	// SI recibe parametro  ( UNA ID para identificar el combustible que queremos CREAR)
		boolean isCreate = false;

		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
			
		
			pst.setString(1, combustible.getNombre());		
				if ( pst.executeUpdate() == 1 ) { 							// UPDATE porque es INSERT
					
					// recuperar id
					try (ResultSet rs = pst.getGeneratedKeys()) {
						rs.next();
						combustible.setId(rs.getInt(1));
						isCreate = true;
						}								
				}		
		}
		return isCreate;
	}
	

	
	// PARA METODO MODIFICAR (INSERT)
	@Override
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
	
	
	// METODO PARA MAPEO PARAMETROS, iguAL A ROWMAPPER 
	private Combustible mapeo(ResultSet rs) throws SQLException {
		Combustible c = new Combustible();
		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));
		return c;
	}

	
	private Combustible rowMapper(ResultSet rs) throws SQLException {
		Combustible c = new Combustible();
		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));
		return c;
	}
}
