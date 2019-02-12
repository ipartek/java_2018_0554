package com.ipartek.formacion.cervezas.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.cervezas.modelo.config.ConnectionManager;
import com.ipartek.formacion.cervezas.modelo.pojo.Cerveza;

@Repository
public class CervezaDAO  {

	private static final String SQL_GET_ALL = "SELECT id, nombre, precio, id_tipo FROM  cervezas.cerveza ORDER BY id DESC LIMIT 100;";
	private static final String SQL_GET_BY_ID = "SELECT id,nombre,id_tipo, precio FROM cervezas.cerveza WHERE id=?;";
	private static final String SQL_INSERT = "INSERT INTO cervezas.cerveza (nombre, id_tipo, precio) VALUES (?, ?, ?);";	
	private static final String SQL_DELETE = "DELETE FROM cerveza WHERE id=?;";	
	private static final String SQL_UPDATE = "UPDATE cervezas.cerveza SET  nombre= ?, id_tipo=?, precio=? WHERE id=?;";

	
	
// PARA METODO LISTAR (GETALL)
	public ArrayList<Cerveza> getAll() {									// NO recibe parametro
		ArrayList<Cerveza> lista = new ArrayList<Cerveza>();
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
	
	
	
//  PARA METODO DETALLE PRECIO (GETBYID)

	public Cerveza getById(int id) {   										// SI recibe parametro  ( UNA ID para identificar el Vehiculo que queremos listar)

		Cerveza c = null;
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
		return c;														 	// devuelve un objeto con los datos del Vehiculo que ha encontrado en bbdd
	}


	
	
	// ELIMINAR
	
	public boolean delete(int id) throws SQLException {
		boolean isDelete = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_DELETE);) {

			pst.setInt(1, id);
			if (pst.executeUpdate() == 1) {
				isDelete = true;
			}
		}
		return isDelete;
	}
	
	
	// METODO PARA INSERTAR
	public boolean insert(Cerveza cerveza) throws SQLException {
		boolean isCreate = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
				
			pst.setString(1, cerveza.getNombre());		
			pst.setInt(2, cerveza.getTipo().getId());
			pst.setFloat(3, cerveza.getPrecio());
		
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						cerveza.setId(generatedKeys.getInt(1));
					}
				}
				isCreate = true;
			}
		}
		return isCreate;
	}
	
	
	// METODO MODIFICAR UPDATE
	//@Override
	public boolean update(Cerveza cerveza) throws SQLException {
		boolean resul = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_UPDATE);) {

			pst.setString(1, cerveza.getNombre());		
			pst.setInt(2, cerveza.getTipo().getId());
			pst.setFloat(3, cerveza.getPrecio());
			pst.setInt(4, cerveza.getId());

			if (1 == pst.executeUpdate()) {
				resul = true;
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}
	// MAPEO PARA GET, 
		private Cerveza mapeo(ResultSet rs) throws SQLException {
			
			Cerveza c = new Cerveza();
			c.setId(rs.getInt("id"));
			c.setNombre(rs.getString("nombre"));
			c.setPrecio(rs.getFloat("precio"));
			

			return c;
		}

	
	
}
