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


public class CocheDAO {

	private final static Logger LOG = Logger.getLogger(CocheDAO.class);
	private static CocheDAO INSTANCE = null;
	
	
	private static final String SQL_GETMATRICULA = "{call pa_coche_getByMatricula(?)}";
	private static final String SQL_GET_ALL = "{call pa_coche_getAll()}";
	private static final String SQL_GET_BY_ID = "{call pa_coche_getById(?)}";
	private static final String SQL_DELETE = "{call pa_coche_borrar(?,?)}";
	private static final String SQL_INSERT = "{call pa_coche_insertar(?,?,?,?)}";
	private static final String SQL_UPDATE = "{call pa_coche_update(?,?,?)}";
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
	 * Obtiene una coleccion de coches ordneados por id descendente y limitado a 100
	 * @return ArrayList<Coche> si no existe devuelve la coleccion inicializada a 0.
	 */
	public ArrayList<Coche> getAll(){
		ArrayList<Coche> coches = new ArrayList<Coche>();
		String sql= SQL_GET_ALL;
		Coche c = null;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(sql);) {
			try (ResultSet rs = cs.executeQuery()) {
				while (rs.next()) {
					coches.add(rowMapper(rs));
					}
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		
		return coches;
	}
	
	/**
	 * Recibe un parametro de entrada, una matricula (tipo String), una vez procesado, 
	 * se obtendrán los datos requeridos del coche.
	 * @param matricula String
	 * @return Coche si encuentra, null en caso contrario
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
	
	
	/** Obtener un coche por su identificador
	 * @param id es el identifacdor de coche no maricula
	 * @return si encuentra devuelve un coche sino devuleve null
	 */
	public Coche getById(Long id) {
		
		Coche c = null;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_GET_BY_ID);) {

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
	 * Eliminar una Coche de la base de datos
	 * @param id, identificador del coche
	 * @return true si elimina, false en caso contrario
	 * @throws SQLException cuando no se pueda eliminar el coche con multas asociadas (integridad referencial)
	 */
	public boolean delete( long id ) throws SQLException {

		boolean resul = false;
		String sql = SQL_DELETE;
		try (Connection conn = ConnectionManager.getConnection();
			CallableStatement cs = conn.prepareCall(sql);) {	
			cs.setLong(1, id);
			cs.registerOutParameter(2, Types.INTEGER );
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		}
		return resul;
	}
	
	
	
	
	/**
	 * Insertar un nuevo Coche
	 * @param coche con datos
	 * @return Coche con los mismos datos y la id generada
	 * @throws SQLException si la matricula ya existe
	 */
	public Coche insert(Coche coche) throws SQLException {

		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_INSERT);) {
			cs.setString(1, coche.getMatricula());
			cs.setString(2, coche.getModelo());
			cs.setInt(3, coche.getKm());
			cs.registerOutParameter(4, Types.INTEGER);
			
			if ( cs.executeUpdate() == 1) {
				coche.setId(cs.getLong(4));
			} else {
				throw new SQLException("No se puede insertar el coche " + coche );
			}
		}
		return coche;
	}
	
	
	/**
	 * 
	 * @param c(coche)
	 * @return
	 * @throws SQLException
	 */
	public boolean update(Coche c) throws SQLException {

		boolean resul = false;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_UPDATE);) {

			cs.setString(1, c.getModelo());
			cs.setInt(2, c.getKm());
			cs.setLong(3, c.getId());
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;

}
	
	
}