package com.ipartek.appMultas.modelo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

import com.ipartek.appMultas.modelo.pojo.Agente;

public class AgenteDAO {
	
	private final static String SQL_GETBYID = "{call pa_getAgenteById(?)}";
	private final static String SQL_LOGIN = "{call pa_login(?,?)}";

	private final static Logger LOG = Logger.getLogger(AgenteDAO.class);
	private static AgenteDAO INSTANCE = null;

	// constructor privado, solo acceso por getInstance
	private AgenteDAO() {
		super();
	}

	// Esta sincronizado para que no haya dos peticiones al mismo tiempo SINGLETON
	public synchronized static AgenteDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AgenteDAO();
		}
		return INSTANCE;
	}
	/**
	 * metodo que comprueba si los datos del agente son correctos
	 * @param placa 
	 * @param password 
	 * @return el agente , null si no lo encuentra
	 */
	public Agente login(String placa, String password) {
		Agente a = null;

		String sql = SQL_LOGIN;
		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
			cs.setString(1, placa);
			cs.setString(2, password);
			try (ResultSet rs = cs.executeQuery();) {
				while (rs.next()) {
					a = rowMapper(rs);
				}
			}
		} catch (Exception e) {
			LOG.error(e);
		}
		return a;
	}

	/**
	 * Obtener los datos del agente
	 * 
	 * @param id Identificador del agente en la BD.
	 * @return Retorna el agente si existe en la BD.
	 */
	public Agente getByID(Long id) {
		Agente a = new Agente();

		String sql = SQL_GETBYID;
		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
			cs.setLong(1, id);
			try (ResultSet rs = cs.executeQuery();) {
				while (rs.next()) {
					a = rowMapper(rs);
				}
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return a;
	}
	

	
//<--------------ROWMAP----------------------------------------->

	private Agente rowMapper(ResultSet rs) throws SQLException {
		Agente a = new Agente();
		a.setId(rs.getLong("id"));
		a.setNombre(rs.getString("nombre"));
		a.setPlaca(rs.getString("placa"));
		
		return a;
	}

}
