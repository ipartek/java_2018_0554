package com.ipartek.formacion.taller.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.taller.modelo.config.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.service.exception.CombustibleException;

@Repository
public class CombustibleDAO {
	// LOG
	private final static Logger LOG = Logger.getLogger(CombustibleDAO.class);

	private static final String SQL_GET_ALL = "SELECT id, nombre FROM combustible ORDER BY id DESC;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre FROM combustible WHERE id = ? ;";
	private static final String SQL_CREAR = "INSERT INTO combustible (`nombre`) VALUES (?);";
	private static final String SQL_DELETE = "DELETE FROM `taller`.`combustible` WHERE (`id` = ? ); ;";
	private static final String SQL_UPDATE = "UPDATE `taller`.`combustible` SET `nombre` = ? WHERE (`id` = ?);";
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Combustible> getAll() {
		ArrayList<Combustible> combustibles = new ArrayList<Combustible>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				Combustible combustible = new Combustible();
				combustible.setId(rs.getInt("id"));
				combustible.setNombre(rs.getString("nombre"));
				combustibles.add(combustible);
			} // end while
		} catch (Exception e) {
			LOG.debug(e);
		}
		return combustibles;
	}
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Combustible getById(int id) {
		Combustible combustible = null;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID);) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					combustible = new Combustible();
					combustible.setId(rs.getInt("id"));
					combustible.setNombre(rs.getString("nombre"));
				} // end while
			} catch (SQLException e) {
				LOG.debug(e);
			}

		} catch (Exception e) {
			LOG.debug(e);
		}

		return combustible;
	}
	
	
	public Boolean insert(Combustible combustible) throws SQLException {
		boolean resul= false;
		try (Connection conn = ConnectionManager.getConnection();
			PreparedStatement pst = conn.prepareStatement(SQL_CREAR);) {
			pst.setString(1, combustible.getNombre());
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				// TODO conseguir id generado
				//combustible.setId( pst.geInt(2) );	
				 resul = true;			
			}		
		}
		return resul;
	}
	
	
	public Boolean delete(Integer id) throws SQLException {//lanza la excepcion hacia el service
		boolean resul= false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareCall(SQL_DELETE);) {
				pst.setInt(1, id);
				int affectedRows = pst.executeUpdate();
				if (affectedRows == 1) {
					resul = true;			
				}		
			}
		return resul;
	}
	
	public Boolean update(Combustible combustible) throws SQLException {//lanza la excepcion hacia el service
		boolean resul= false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareCall(SQL_UPDATE);) {
				
				pst.setString(1, combustible.getNombre());
				pst.setInt(2, combustible.getId());
				
				int affectedRows = pst.executeUpdate();
				if (affectedRows == 1) {
					resul = true;			
				}		
			}
		return resul;
	}
	
	

}
	

