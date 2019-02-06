package com.ipartek.formacion.taller.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.taller.modelo.config.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.modelo.pojo.Modelo;

@Repository
public class ModeloDAO {
	// LOG
	private final static Logger LOG = Logger.getLogger(ModeloDAO.class);

	private static final String SQL_GET_ALL = "SELECT id, nombre FROM modelo ORDER BY id DESC;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre FROM modelo WHERE id = ? ;";
	private static final String SQL_CREAR = "INSERT INTO modelo (`nombre`) VALUES (?);";
	private static final String SQL_DELETE = "DELETE FROM `taller`.`modelo` WHERE (`id` = ? ); ;";
	private static final String SQL_UPDATE = "UPDATE `taller`.`modelo` SET `nombre` = ? WHERE (`id` = ?);";

	/**
	 * 
	 * @return
	 */
	public ArrayList<Modelo> getAll() {
		ArrayList<Modelo> modelos = new ArrayList<Modelo>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				Modelo modelo = rowMapper(rs);
				modelos.add(modelo);
			} // end while
		} catch (Exception e) {
			LOG.debug(e);
		}
		return modelos;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Modelo getById(int id) {
		Modelo modelo = null;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID);) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					modelo = rowMapper(rs);
				} // end while
			} catch (SQLException e) {
				LOG.debug(e);
			}

		} catch (Exception e) {
			LOG.debug(e);
		}

		return modelo;
	}

	public Boolean insert(Modelo modelo) throws SQLException {
		boolean resul = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_CREAR, Statement.RETURN_GENERATED_KEYS);) {
			pst.setString(1, modelo.getNombre());
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					modelo.setId(rs.getInt(1));
				}
				resul = true;
			}
		}
		return resul;
	}

	public Boolean delete(Integer id) throws SQLException {// lanza la excepcion hacia el service
		boolean resul = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_DELETE);) {
			pst.setInt(1, id);
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;
	}

	public Boolean update(Modelo modelo) throws SQLException {// lanza la excepcion hacia el service
		boolean resul = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_UPDATE);) {

			pst.setString(1, modelo.getNombre());
			pst.setInt(2, modelo.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;
	}

	private Modelo rowMapper(ResultSet rs) throws SQLException {
		Modelo m = new Modelo();
		m.setId(rs.getInt("id"));
		m.setNombre(rs.getString("nombre"));
		return m;
	}

}
