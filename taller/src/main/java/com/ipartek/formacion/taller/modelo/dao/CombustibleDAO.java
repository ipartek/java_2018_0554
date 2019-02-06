package com.ipartek.formacion.taller.modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.tree.RowMapper;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.modelo.cm.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public class CombustibleDAO implements IDAO<Combustible> {

	private static final String SQL_GET_ALL = "SELECT id, nombre FROM combustible ORDER BY id DESC;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre FROM combustible WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM combustible WHERE id = ?;";
	private static final String SQL_UPDATE = "UPDATE combustible SET nombre=? WHERE id = ?;";
	private static final String SQL_INSERT = "INSERT INTO `taller_correccion`.`combustible` (`nombre`) VALUES ('?');";
	
	@Override
	public ArrayList<Combustible> getAll() {
		ArrayList<Combustible> lista = new ArrayList<Combustible>();
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
	public Combustible getById(int id) { // funcion
		Combustible c = null;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_BY_ID);) { // inicio try

			pst.setLong(1, id); // parametros del string SQL

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					c = rowMapper(rs);
				}
			}
		} // fin try
		catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}// fin funcion

	@Override
	public boolean delete(int id) throws SQLException {
		// por defecto lo ponemos como no eliminado (resul=false;)

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

	@Override
	public boolean update(Combustible combustible) throws SQLException {

		// funcion a la que se le pasa el objeto combustible de tipoCombustible
		// ejecuta el UPDATE para el contenido de ese objeto

		// por defecto lo ponemos como no modificado (resul=false;)

		boolean resul = false;

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_UPDATE);) {

			pst.setString(1, combustible.getNombre());
			pst.setInt(2, combustible.getId());

			if (pst.executeUpdate() == 1) {

				resul = true;
			}
		}

		return resul;
	}
	
	private Combustible rowMapper (ResultSet rs) throws SQLException {
		Combustible c = new Combustible();
		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));
		return c;
	}

	@Override
	public boolean insert(Combustible combustible) throws SQLException {
		// TODO Auto-generated method stub
		boolean resul = false;
		
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, combustible.getNombre());
			

			if (pst.executeUpdate() == 1) {
					//recuperar id
				try(ResultSet rs= pst.getGeneratedKeys()){
					
					rs.next();
					combustible.setId(rs.getInt(1));
					
				//si todo esto funciona, el resultado es igual a true
					resul=true;
					
					
				}
				resul = true;
			}
		}
		
		
		return resul;
	}
	

//	private Combustible mapeo(ResultSet rs) throws SQLException {
//		Combustible c = new Combustible();
//		c.setId(rs.getInt("id"));
//		c.setNombre(rs.getString("nombre"));
//		return c;
//
//	}

}
