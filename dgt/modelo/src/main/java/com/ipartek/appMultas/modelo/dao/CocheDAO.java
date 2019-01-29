package com.ipartek.appMultas.modelo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.appMultas.modelo.pojo.Coche;

public class CocheDAO {

	private final static String SQL_GETALL = "{call coche_getAll()}";
	private final static String SQL_GETBYMATRICULA = "{call coche_getByMatricula(?)}";
	private final static String SQL_GETBYID = "{call coche_getById(?)}";
	private final static String SQL_DELETE = "{call coche_delete(?)}";
	private static final String SQL_DAR_DE_BAJA = "{call coche_dar_de_baja(?)}";
	private static final String SQL_INSERT = "{call coche_insert(?,?,?,?)}";
	private static final String SQL_UPDATE = "{call coche_update(?,?,?,?)}";

	private final static Logger LOG = Logger.getLogger(CocheDAO.class);
	private static CocheDAO INSTANCE = null;

	// constructor privado, solo acceso por getInstance
	private CocheDAO() {
		super();
	}

	// Esta sincronizado para que no haya dos peticiones al mismo tiempo SINGLETON
	public synchronized static CocheDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CocheDAO();
		}
		return INSTANCE;
	}
	
	/**
	 * Obtiene todos los vehiculos de la base de datos
	 * @return ArrayList de coches
	 */
	public ArrayList<Coche> getAll(){
		ArrayList<Coche> coches = new ArrayList<Coche>();
		Coche c = null;
		String sql = SQL_GETALL;

		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
			try (ResultSet rs = cs.executeQuery();) {
				while (rs.next()) {
					c = rowMapper(rs);
					coches.add(c);
				}
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return coches;
	}
	
	/**
	 * Obtiene un coche a partir de la matrícula que recibe por parámetro. 
	 * @param matricula Matrícula del coche
	 * @return Coche con dicha matricula. Null si el coche no existe.
	 */
	public Coche getByMatricula(String matricula) {
		Coche c = null;

		String sql = SQL_GETBYMATRICULA;

		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
			cs.setString(1, matricula);
			try (ResultSet rs = cs.executeQuery();) {
				while (rs.next()) {
					c = rowMapper(rs);
				}
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return c;
	}
	/**
	 * Obtiene un coche a partir del ID que recibe por parámetro. 
	 * @param id ID del coche en la BD.
	 * @return Coche con dicho ID. Null si el coche no existe.
	 */
	public Coche getBYId(Long id) {
		Coche c = new Coche();

		String sql = SQL_GETBYID;

		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
			cs.setLong(1, id);
			try (ResultSet rs = cs.executeQuery();) {
				while (rs.next()) {
					c = rowMapper(rs);
				}
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return c;
	}
	
	/**
	 * Método para insertar un objeto Coche nuevo en la BD
	 * @param c Coche a insertar en la BD
	 * @return True si la inserción ha sido correcta.
	 * @return False si no se ha podido insertar el coche.
	 * @throws SQLException P.E: Si algún dato no llega en el formato esperado.
	 */
	public boolean insert(Coche c) throws SQLException {
		boolean resul = false;
		String sql = SQL_INSERT;
		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
			// parametros de entrada
			cs.setString(1, c.getMatricula());
			cs.setString(2, c.getModelo());
			cs.setLong(3, c.getKm());
			
			// parametros de salida
			cs.registerOutParameter(4, Types.INTEGER);

			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				// conseguir id generado
				c.setId(cs.getLong(4));
				resul = true;
			}
		}
		return resul;
	}
	
	/**
	 * Método para actualizar los datos de un coche específico en la BD. 
	 * @param c Datos nuevos para actualizar el coche existente. 
	 * @return True si la modificación ha sido correcta.
	 * @return False si no se ha podido modificar el coche. 
	 * @throws SQLException P.E: Si algún dato no llega en el formato esperado.
	 */
	public boolean update(Coche c) throws SQLException {
		boolean result = false;
		String sql = SQL_UPDATE;

		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
			cs.setLong(1, c.getId());
			cs.setString(2, c.getMatricula());
			cs.setString(3, c.getModelo());
			cs.setLong(4, c.getKm());

			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param id del coche a eliminar en la BD. 
	 * @return True si la inserción ha sido correcta.
	 * @return False si no se ha podido insertar el coche.
	 * @throws SQLException Si hay algún problema con la consulta a la BD.
	 */
	public boolean delete(Long id) throws SQLException {
		boolean result = false;
		String sql = SQL_DELETE;

		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
			cs.setLong(1, id);
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * Método que actualiza la fecha de baja del coche en la base de datos.
	 * Da de baja el coche, pero no lo elimina. 
	 * @param id del coche a dar de baja
	 * @return True si la inserción ha sido correcta.
	 * @return False si no se ha podido insertar el coche.
	 * @throws SQLException Si hay algún problema con la consulta a la BD.
	 */
	public boolean darDeBaja(Long id) throws SQLException {
		boolean result = false;
		String sql = SQL_DAR_DE_BAJA;

		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
			cs.setLong(1, id);
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * Constructor del coche mediante una consulta a la BD. 
	 * @param rs REsultSet de la consulta realizada a la BD. 
	 * @return Coche existente en la BD.
	 * @throws SQLException
	 */
	private Coche rowMapper(ResultSet rs) throws SQLException {
		Coche c = new Coche();
		c.setId(rs.getLong("id"));
		c.setMatricula(rs.getString("matricula"));
		c.setModelo(rs.getString("modelo"));
		c.setKm(rs.getLong("km"));
		return c;
	}

}
