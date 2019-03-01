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
import com.ipartek.formacion.modelo.pojo.Vehiculo;

public class VehiculoDAO {

	private final static Logger LOG = Logger.getLogger(VehiculoDAO.class);
	private static VehiculoDAO INSTANCE = null;
	private static final String SQL_GETMATRICULA = "{call pa_coche_getByMatricula(?)}";
	private static final String SQL_GETALL = "SELECT * FROM coche ORDER BY id DESC LIMIT 100";
	private static final String SQL_BYID = "SELECT * FROM COCHE WHERE ID=?";
	private static final String SQL_DELETEBYID = "DELETE FROM coche WHERE id = ?;";
	private static final String SQL_INSERT = "{call pa_coche_insert(?,?,?,?)}";
	private static final String SQL_UPDATE = "{call pa_coche_update(?,?,?)}";

	private VehiculoDAO() {
		super();
		
	}

	public synchronized static VehiculoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VehiculoDAO();
		}
		return INSTANCE;
	}

	/**
	 * Obtenemos un Vehiculo por su matricula
	 * 
	 * @param matricula
	 * @return Coche si encuentra, null en caso contrario
	 */
	public Vehiculo getByMatricula(String matricula) {
		Vehiculo c = null;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_GETMATRICULA);) {

			cs.setString(1, matricula);

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
	 * obtenemos un coche por su identificador
	 * 
	 * @param id
	 * @return coche con datos, null si no encuentra
	 */
	public Vehiculo getById(long id) {

		Vehiculo c = null;

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_BYID);) {
			pst.setLong(1, id);

			try (ResultSet rs = pst.executeQuery()) {
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
	 * obtiene una coleccion de Coche ordenado por identificador descendente y
	 * limitados a 100
	 * 
	 * @return si no existe ningun new ArrayList<Coche>
	 */
	public ArrayList<Vehiculo> getAll() {

		ArrayList<Vehiculo> coches = new ArrayList<Vehiculo>();

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GETALL);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				try {
					Vehiculo coche = new Vehiculo();
					coche.setId(rs.getLong("id"));
					coche.setMatricula(rs.getString("matricula"));
					coche.setKm(rs.getInt("km"));
					coche.setModelo(rs.getString("modelo"));
					coches.add(coche);
				} catch (Exception e) {
					System.out.println("usuario no valido");
					e.printStackTrace();
				}
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}
		return coches;
	}

	// ELIMINAR

	/**
	 * Eliminar un coche de la base de datos
	 * 
	 * @param id identificador del coche
	 * @return true si elimina, false en caso contrario
	 * @throws SQLException si el coche tiene alguna multa asociada (integridad
	 *                      referencial)
	 */

	public boolean eliminar(long id) throws SQLException {

		boolean resul = false;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_DELETEBYID);) {

			cs.setLong(1,id);
			
			if (cs.executeUpdate() == 1) {
				resul = true;
			}

		}
		return resul;

	}

	// INSERTAR

	/**
	 * inserta un nuevo Coche (matricula, modelo, km)
	 * 
	 * @param coche con datos
	 * @return Coche con los mismos datos y la id generada 
	 * @throws SQLException si la matricula ya existe
	 */

	public Vehiculo insert(Vehiculo coche) throws SQLException{

		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_INSERT);) {
			cs.setString(1, coche.getMatricula());
			cs.setString(2, coche.getModelo());
			cs.setInt(3, coche.getKm());
			cs.registerOutParameter(4, Types.INTEGER);
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				coche.setId(cs.getLong(4));
			}else {
				coche=null;
			}
		}
		return coche;
	}

	/**
	 * Actualizar un coche menos su id y matricula @param coche @throws
	 * SQLException @returntrue si se modifica, false e caos contrario @throws
	 */
	public boolean update(Vehiculo coche) throws SQLException {

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
		}
		return resul;
	}

	private Vehiculo rowMapper(ResultSet rs) throws SQLException {
		Vehiculo c = new Vehiculo();
		c.setId(rs.getLong("id"));
		c.setMatricula(rs.getString("matricula"));
		c.setModelo(rs.getString("modelo"));
		c.setKm(rs.getInt("km"));
		return c;
	}
}