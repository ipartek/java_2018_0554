package com.ipartek.formacion.taller.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.taller.modelo.config.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;

@Repository
public class CombustibleDAO implements IDAO<Combustible> {

	private static final String SQL_GET_ALL = "SELECT id, nombre FROM combustible ORDER BY id DESC;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre FROM combustible WHERE id=?;";
	private static final String SQL_DELETE = "DELETE FROM combustible WHERE id=?;";
	private static final String SQL_CREATE = "INSERT INTO combustible (nombre) VALUES(?)";
	private static final String SQL_UPDATE = "UPDATE combustible SET  nombre=? WHERE id=?;";

	@Override
	public ArrayList<Combustible> getAll() {
		ArrayList<Combustible> combustibles = new ArrayList<Combustible>();
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				combustibles.add(rowMapper(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return combustibles;
	}
	
	@Override
	public Combustible getById(int idCombustible) {
		Combustible c = null;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_BY_ID);) {
			pst.setInt(1, idCombustible);
			try (ResultSet rs = pst.executeQuery();) {
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
	public boolean delete(int idCombustible) throws SQLException {
		boolean isDelete = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_DELETE);) {
			pst.setInt(1, idCombustible);
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				isDelete = true;
			}
		}
		return isDelete;
	}

	@Override
	public boolean insert(Combustible combustible) throws SQLException {
		boolean isCreate = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);) {
			pst.setString(1, combustible.getNombreC());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						combustible.setId(generatedKeys.getInt(1));
					}
				}
				isCreate = true;
			}
		}
		return isCreate;
	}

	@Override
	public boolean update(Combustible combustible) throws SQLException {
		boolean isUpdate = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_UPDATE);) {
			
			pst.setString(1, combustible.getNombreC());
			pst.setInt(2, combustible.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				isUpdate = true;
			}

		}

		return isUpdate;
	}

	private Combustible rowMapper(ResultSet rs) throws SQLException {
		Combustible c = new Combustible();
		c.setId(rs.getInt("id"));
		c.setNombreC(rs.getString("nombre"));
		return c;
	}
}
