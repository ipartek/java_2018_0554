package com.ipartek.formacion.modelo.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.cm.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Coche;

public class CocheDAO {

	private final static Logger LOG = Logger.getLogger(CocheDAO.class);
	private static CocheDAO INSTANCE = null;
	private static final String SQL_INSERT = "insert into coche values(null,?,?,?,null);";
	private static final String SQL_GETALL = "SELECT * FROM coche ORDER BY id DESC LIMIT 100";
	private static final String SQL_GETMATRICULA = "{call pa_coche_getByMatricula(?)}";
	private static final String SQL_GETBYID = "SELECT * FROM COCHE WHERE ID=?";
	private static final String SQL_DELETEBYID = "DELETE FROM COCHE WHERE ID=?";
	private static final String SQL_UPDATE = "update coche set matricula=?, modelo=?, km=? where id=?";
	private static final String SQL_DARDEBAJA = "update coche set fecha_baja=now() where id=?;";

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

	/**
	 * Actulizar un coche menos su id y matricula
	 * 
	 * @param coche
	 * @return true si se modifica, false en caso contrario
	 * @throws Exception si id < 1
	 */
	public boolean update(Coche coche) throws Exception {

		boolean resul = false;

		if (coche.getId() < 1) {
			throw new Exception("Identificador de coche debe ser >= 1");

		} else {

			try (Connection conn = ConnectionManager.getConnection();
					PreparedStatement cs = conn.prepareStatement(SQL_UPDATE);) {

				cs.setString(1, coche.getMatricula());
				cs.setString(2, coche.getModelo());
				cs.setInt(3, coche.getKm());
				cs.setLong(4, coche.getId());
				int affectedRows = cs.executeUpdate();
				if (affectedRows == 1) {
					resul = true;
				}
			}
		}
		return resul;

	}

	/**
	 * Obtenemos un Coche por su identificador
	 * 
	 * @param id long identificador del Coche
	 * @return Coche con datos si encuentra, null si no encuentra
	 */
	public Coche getById(long id) {

		Coche c = null;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement cs = conn.prepareStatement(SQL_GETBYID);) {

			cs.setLong(1, id);

			try (ResultSet rs = cs.executeQuery()) {

				while (rs.next()) {
					c = rowMapper(rs);
				}
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return c;
	}

	/**
	 * Obtenemos un Coche por su matricula
	 * 
	 * @param matricula String matricula del coche
	 * @return Coche con datos si lo encuentra, null si no encuentra
	 */
	public Coche getByMatricula(String matricula) {
		Coche c = null;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_GETMATRICULA);) {

			cs.setString(1, matricula);

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

	/**
	 * Obtiene una coleccion de Coche ordenado por identificador descendente y
	 * limitado a 100
	 * 
	 * @return si no existe ninguno new ArrayList<Coche>()
	 */
	public ArrayList<Coche> getAll() {

		ArrayList<Coche> coches = new ArrayList<Coche>();

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GETALL);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				coches.add(rowMapper(rs));
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return coches;
	}

	/**
	 * Eliminar un Coche de la base datos
	 * 
	 * @param id identificaodr del Coche
	 * @return true si elimina, false en caso contrario
	 * @throws SQLException Si el Coche tiene alguna multa asociada ( integridad
	 *                      referencial )
	 */
	public boolean delete(long id) throws SQLException {

		boolean resul = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement cs = conn.prepareStatement(SQL_DELETEBYID);) {

			cs.setLong(1, id);
			if (cs.executeUpdate() == 1) {
				resul = true;
			}
		}
		return resul;
	}

	/**
	 * Insertar un nuevo Coche
	 * 
	 * @param coche con datos
	 * @return Coche con los mismos datos y la id generada
	 * @throws SQLException si la matricula ya existe
	 */
	public Coche insert(Coche coche) throws SQLException {

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement cs = conn.prepareStatement(SQL_INSERT);) {
			cs.setString(1, coche.getMatricula());
			cs.setString(2, coche.getModelo());
			cs.setInt(3, coche.getKm());

			if (cs.executeUpdate() != 1) {
				throw new SQLException("No se puede insertar el coche " + coche);
			}
		}
		return coche;
	}

	private Coche rowMapper(ResultSet rs) throws SQLException {
		Coche c = new Coche();
		c.setId(rs.getLong("id"));
		c.setMatricula(rs.getString("matricula"));
		c.setModelo(rs.getString("modelo"));
		c.setKm(rs.getInt("km"));
		return c;
	}

	public boolean darDeBaja(long id) throws SQLException {

		boolean resul = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement cs = conn.prepareStatement(SQL_DARDEBAJA);) {

			cs.setLong(1, id);
			if (cs.executeUpdate() == 1) {
				resul = true;
			}
		}
		return resul;
	}
}