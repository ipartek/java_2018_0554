package com.ipartek.insercionUsuarios.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.insercionUsuarios.pojo.Persona;

public class InsertarDAO {
	
	private final static String SQL_INSERT = "{call persona_insert(?,?,?,?,?,?)}";
	
	private final static Logger LOG = Logger.getLogger(InsertarDAO.class);
	
	private static InsertarDAO INSTANCE = null;

	// constructor privado, solo acceso por getInstance
	private InsertarDAO() {
		super();
	}

	// Esta sincronizado para que no haya dos peticiones al mismo tiempo SINGLETON
	public synchronized static InsertarDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new InsertarDAO();
		}
		return INSTANCE;
	}
	
	public boolean insert(ArrayList<Persona> personas) throws SQLException {
		boolean resul = false;
		String sql = SQL_INSERT;
		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);) {
			int affectedRows = 0;
			for (Persona p : personas) {
				try{
				cs.setString(1, p.getNombre());
				cs.setString(2, p.getAp1());
				cs.setString(3, p.getAp2());
				cs.setInt(4, p.getEdad());
				cs.setString(5, p.getEmail());
				cs.setString(6, p.getDni());

				affectedRows = affectedRows + cs.executeUpdate();
				LOG.info("Personas insertadas: " + affectedRows);
				} catch (Exception e) {
					e.printStackTrace();
					conn.rollback();
					LOG.error("Excepción! Se ha realizado el rollback.");
			    }
				
			}
				resul = true;
				conn.commit();
				LOG.debug("Todos los resultados se insertaron correctamente, se ha realizado el commit.");
			}
		return resul;
	}

}
