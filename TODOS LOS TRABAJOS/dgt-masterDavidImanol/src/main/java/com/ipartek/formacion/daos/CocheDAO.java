package com.ipartek.formacion.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojos.Coche;

public class CocheDAO {
	
	// DAO
	private static CocheDAO INSTANCE = null;
	
	// LOG PARA MENSAJES
	private final static Logger LOG = Logger.getLogger(AgenteDAO.class);
	
	// CONSULTA SQL CON PROCEDIMIENTO ALMACENADO
	private static final String SQL_GET_MATRICULA = "call dgt.coche_get_matricula(?);";
	
	// CONSULTA SIN PROCEDIMIENTO ALMACENADO
	//private static final String SQL_GET_MATRICULA = "SELECT id, matricula, modelo, km FROM coche WHERE matricula =?;";
	
	
	//metodo constructor superclase
	private CocheDAO() {
		super();
	}
	
	// instance/singleton
	public synchronized static CocheDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CocheDAO();
		}
		return INSTANCE;
	}
	
	// metodo para obtener matricula y resto parametros coche
	public Coche getMatricula(String matricula) {
		String sql = SQL_GET_MATRICULA;
		Coche coche = null;
		try (Connection conn = ConnectionManager.getConnection(); 
				CallableStatement cs = conn.prepareCall(sql);) {
						cs.setString(1, matricula);
			try (ResultSet rs = cs.executeQuery()) {
				while (rs.next()) {
					coche = new Coche();
					coche.setId(rs.getLong("id"));
					coche.setMatricula(rs.getString("matricula"));
					coche.setModelo(rs.getString("modelo"));
					coche.setKm(rs.getInt("km"));
				}
			}

		} catch (Exception e) {
			LOG.fatal("getMultas:---> " + e);
		}
		LOG.debug("Listado multas OK");
		return coche;
	}

}
