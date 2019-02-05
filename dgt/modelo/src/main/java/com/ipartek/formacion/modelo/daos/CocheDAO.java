package com.ipartek.formacion.modelo.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.cm.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Coche;
import java.sql.PreparedStatement;

public class CocheDAO {

	private final static Logger LOG = Logger.getLogger(CocheDAO.class);
	private static CocheDAO INSTANCE = null;
	private String indetmatricula = "";

	private static final String SQL_GETMATRICULA = "{call pa_coche_getByMatricula(?)}";
	private static final String SQL_GETMATRICULAS = "SELECT id, matricula, modelo, km FROM coche ORDER BY id DESC LIMIT 100;";

	private static final String SQL_GETBYID = "SELECT id, matricula, modelo, km FROM coche where id=? ;";
	private static final String SQL_INSERTCOCHE = "INSERT INTO coche(matricula, modelo, km) values (?,?,?);";
	private static final String SQL_UPDATE = null;
	private static final String SQL_DELETE = null;

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
	 * 
	 * Obtiene una coleccion de coches ordenados por id en orden descendente,
	 * limitado a 100 registros
	 * 
	 * @return si no existe ninguno coleccion inicializada a cero
	 */

	public ArrayList<Coche> getMatriculas() {
		ArrayList<Coche> matriculas = new ArrayList<Coche>();
		indetmatricula = "getMatriculas";
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GETMATRICULAS);) {

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					matriculas.add(rowMapper(rs));
				}
			}
		} catch (Exception e) {
			LOG.error(e);
		}
		return matriculas;
	}

	/**
	 * 
	 * @param id identidicador del coche
	 * @return null si no lo encuentra, coches con datos si los hay
	 */

	public Coche getById(long id) {

		Coche coche = null;

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GETBYID);) {
			pst.setLong(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					coche = rowMapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coche;
	}

//funcion insertar coche 

	/**
	 * 
	 * 
	 * 
	 * @param coche con los datos
	 * @return retorna el coche con los datos y la id que se genera
	 * @throws SQLException si la matricula ya existe
	 */

	public Coche insertarCoche(Coche coche) throws SQLException {

		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_INSERTCOCHE);) {
			cs.setString(1, coche.getMatricula());
			cs.setString(2, coche.getModelo());
			cs.setInt(3, coche.getKm());
			cs.registerOutParameter(4, Types.INTEGER);

			if (cs.executeUpdate() == 1) {
				coche.setId(cs.getLong(4));
			} else {
				throw new SQLException("No se puede insertar el coche " + coche);
			}
		}
		return coche;
	}

	/**
	 * 
	 * @param id
	 * @return true si eleimina el coche, false si no hay donde borrar
	 * @throws SQLException
	 */
	public boolean delete(long id) throws SQLException {
		boolean resul = false;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_DELETE);) {

			cs.setLong(1, id);

			if (cs.executeUpdate() == 1) {

				resul = true;
			}
			return resul;

		}

	}

	/**
	 * @lanzamos sql exception si la matricula ya existe
	 *
	 */
	public boolean update(Coche coche) throws SQLException {

		boolean resul = false;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_UPDATE);) {

			cs.setString(1, coche.getModelo());

			cs.setInt(2, coche.getKm());
			cs.setLong(3, coche.getId());

			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {

				resul = true;
			}
			return resul;

		}

	}

	/**
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Coche rowMapper(ResultSet rs) throws SQLException {
		Coche c = new Coche();
		c.setId(rs.getLong("id"));
		c.setMatricula(rs.getString("matricula"));
		c.setModelo(rs.getString("modelo"));
		c.setKm(rs.getInt("km"));
		return c;
	}

	/**
	 * 
	 * 
	 * Obtenemos un coche por su matricula
	 * 
	 * @param mat String , matricula del coche
	 * @return Coche y sus datos si lo encuentra, null si no hay
	 */

	public Coche getByMatricula(String mat) {
		Coche c = null;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_GETMATRICULA);) {

			cs.setString(1, mat);

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
}