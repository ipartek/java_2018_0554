package com.ipartek.formacion.modelo.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.cm.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Coche;


public class CocheDAO {

	private final static Logger LOG = Logger.getLogger(CocheDAO.class);
	private static CocheDAO INSTANCE = null;	
	private static final String SQL_GETMATRICULA = "{call pa_coche_getByMatricula(?)}";

	
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
	 * Obtenemos un Coche por su matricula
	 * @param matricula
	 * @return Coche si encuentra, null en caso contrario
	 */
	public Coche getByMatricula(String matricula) {
		Coche c = null;
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
	
	
	private Coche rowMapper(ResultSet rs) throws SQLException {
		Coche c = new Coche();
		c.setId(rs.getLong("id"));
		c.setMatricula(rs.getString("matricula"));
		c.setModelo(rs.getString("modelo"));
		c.setKm(rs.getInt("km"));
		return c;
	}
}