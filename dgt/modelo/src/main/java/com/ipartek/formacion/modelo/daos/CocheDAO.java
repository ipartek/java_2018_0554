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
	 * Devuelve todos los coches de la base de datos
	 * @return ArrayList<Coche>
	 */
	public ArrayList<Coche> getAll(){
		ArrayList<Coche> coches = new ArrayList<Coche>();
		String sql= SQL_GET_ALL;
		Coche c = null;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(sql);) {
			try (ResultSet rs = cs.executeQuery()) {
				try {
					while (rs.next()) {
						c = rowMapper(rs);
						coches.add(c);
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
	
	/**
	 * Recibe un parametro de entrada, una matricula (tipo String), una vez procesado, 
	 * se obtendrán los datos requeridos del coche.
	 * @param matricula
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
	
	
	/**
	 * Buscar un coche por su id
	 * @param id es el identifacdor de coche no maricula
	 * @return si encuentra devuelve un coche sino devuleve null
	 */
	public Coche getById(Long id) {
		
		Coche c = null;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_GET_BY_ID);) {

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
	
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean delete( long id ) throws SQLException {

		boolean resul = false;
		String sql = SQL_DELETE;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(sql);) {
			
			cs.setLong(1, id);		
			//parametro de salida
			cs.registerOutParameter(2, Types.INTEGER );
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		}
		return resul;

	}
	
	
	
	
	/**
	 * Devuelve true o false
	 * @param c es un objeto de tipo coche
	 * @return true si inserta false si no inserta
	 * @throws SQLException
	 */
	public boolean insert(Coche c) throws SQLException {

		boolean resul = false;
		String sql = SQL_INSERT;
		try (Connection conn = ConnectionManager.getConnection(); 
			CallableStatement cs = conn.prepareCall(sql);) {
			
			// parametros de entrada
			cs.setString(1, c.getMatricula());
			cs.setString(2, c.getModelo());
			cs.setLong(3, c.getKm());
		
			//parametro de salida
			cs.registerOutParameter(4, Types.INTEGER );

			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				// conseguir id generado
				c.setId( cs.getLong(5) );	
				resul = true;
				LOG.debug("coche insertado");
			}
			
		}
		return resul;
}
	
	
	
	
	
	
}