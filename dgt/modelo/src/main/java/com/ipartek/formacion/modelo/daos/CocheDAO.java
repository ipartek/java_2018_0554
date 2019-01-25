package com.ipartek.formacion.modelo.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.cm.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Coche;
import com.ipartek.formacion.modelo.pojo.Multa;

public class CocheDAO {

	private final static Logger LOG = Logger.getLogger(CocheDAO.class);
	private static CocheDAO INSTANCE = null;

	private static final String SQL_GETMATRICULA = "select id, matricula, modelo, km from coche where id=?;";
	private static final String SQL_GETALL = "select id, matricula, modelo, km from coche;";
	private static final String SQL_DELETE = "delete from coche where id = ?;";

	// constructor privado, solo acceso por getInstance()
	private CocheDAO() {
		super();
	}

	public synchronized static CocheDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new CocheDAO();
		}
		return INSTANCE;
	}

	private Coche rowMapper(ResultSet rs) throws SQLException {
		Coche c = new Coche();
		c.setId(rs.getLong("id"));
		c.setMatricula(rs.getString("matricula"));
		c.setModelo(rs.getString("modelo"));
		c.setKm(rs.getInt("km"));
		return c;
	}

	/**
	 * Devuelve un objeto de tipo Coche asociado a la matricula
	 * 
	 * @param mat
	 * @return
	 */
	public Coche getById(long id) {
		Coche c = null;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_GETMATRICULA);) {

			cs.setLong(1, id);

			try (ResultSet rs = cs.executeQuery()) {
				try {
					while (rs.next()) {
						c = rowMapper(rs);
					}
				} catch (Exception e) {
					LOG.warn(e);
				}
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return c;
	}

	public ArrayList<Coche> getAll() {
		ArrayList<Coche> coches = new ArrayList<Coche>();

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GETALL);) {

			try (ResultSet rs = pst.executeQuery()) {
				try {
					while (rs.next()) {
						coches.add(new Coche(rs.getLong("id"), rs.getString("matricula"), rs.getString("modelo"),
								rs.getInt("km")));
					}
				} catch (Exception e) {
					LOG.warn(e);
				}
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return coches;
	}

	public boolean delete(long id) throws SQLException {

		boolean resul = false;

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_DELETE);) {
			pst.setLong(1, id);

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {

				resul = true;
			}

		}
		return resul;

	}

}