package com.ipartek.formacion.taller.modelo.dao;

import java.sql.Connection;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.taller.modelo.config.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.mysql.jdbc.Statement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CombustibleDAO implements IDAO<Combustible> {

	private static final String SQL_GET_ALL = "SELECT id, nombre FROM combustible ORDER BY id DESC;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre FROM combustible WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM combustible WHERE id = ?;";
	private static final String SQL_UPDATE = "UPDATE combustible SET nombre=? WHERE id = ?;";
	private static final String SQL_INSERT = "INSERT INTO combustible (nombre) VALUES (?);";
	private static final String SQL_GET_VEHICULO_ID = "SELECT c.id, c.nombre FROM combustible AS c INNER JOIN vehiculo AS v ON c.id = v.id_combustible WHERE v.id= ?;";

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
	public Combustible getById(int id) {
		Combustible c = null;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_BY_ID);) {

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

	public Combustible getByVehiculoId(int idVehiculo) {
		Combustible c = null;

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_VEHICULO_ID)) {
			pst.setInt(1, idVehiculo);
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

	@Override
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

	@Override
	public boolean update(Combustible combustible) throws SQLException {
		boolean resul = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_UPDATE);) {

			pst.setString(1, combustible.getNombre());
			pst.setInt(2, combustible.getId());

			if (1 == pst.executeUpdate()) {
				resul = true;
			}

		}
		return resul;
	}

	@Override
	public boolean insert(Combustible combustible) throws SQLException {
		boolean resul = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, combustible.getNombre());
			if (1 == pst.executeUpdate()) {

				// recuperar id
				try (ResultSet rs = pst.getGeneratedKeys()) {
					rs.next();
					combustible.setId(rs.getInt(1));
					resul = true;
				}
			}

		}
		return resul;
	}

	private Combustible rowMapper(ResultSet rs) throws SQLException {
		Combustible c = new Combustible();
		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));
		return c;
	}

}
