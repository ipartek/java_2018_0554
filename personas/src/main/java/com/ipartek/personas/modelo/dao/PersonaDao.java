package com.ipartek.personas.modelo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.personas.modelo.pojo.Persona;

public class PersonaDao {

	private final static String SQL_INSERT = "{call pa_persona_insert(?,?,?,?,?,?)}";
	private final static Logger LOG = Logger.getLogger(PersonaDao.class);

	private static PersonaDao INSTANCE = null;

	// constructor privado, solo acceso por getInstance
	private PersonaDao() {
		super();
	}

	// Esta sincronizado para que no haya dos peticiones al mismo tiempo SINGLETON
	public synchronized static PersonaDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PersonaDao();
		}
		return INSTANCE;
	}
	
	
	
	
	public boolean insert(String nombre, String apellido1, String apellido2, int edad, String email,String dni) throws SQLException {
		boolean resul = false;
		String sql = SQL_INSERT;
		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(sql);
			){
			// parametros de entrada
			cs.setString(1, nombre);
			cs.setString(2, apellido1);
			cs.setString(3, apellido2);
			cs.setInt(4, edad);
			cs.setString(5, email);
			cs.setString(6, dni);
			
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				conn.commit();
				resul = true;
			}
		}
		return resul;
	}

	public boolean insertArray(ArrayList<Persona> personasInsertar) throws SQLException  {
		boolean resul = false;
		String sql = SQL_INSERT;
		try (Connection conn = ConnectionManager.getConnection(); 
			CallableStatement cs = conn.prepareCall(sql);
			){
			for (int i= 0 ; i<personasInsertar.size(); i++) {
				try {
					// parametros de entrada
					cs.setString(1, personasInsertar.get(i).getNombre());
					cs.setString(2, personasInsertar.get(i).getApellido1());
					cs.setString(3, personasInsertar.get(i).getApellido2());
					cs.setInt(4, personasInsertar.get(i).getEdad());
					cs.setString(5, personasInsertar.get(i).getEmail());
					cs.setString(6, personasInsertar.get(i).getDni());
				
					int affectedRows = cs.executeUpdate();
					if (affectedRows == 1) {
						resul = true;
					}
					
				} catch (SQLException e) {
					//rollback en caso de fallo
					conn.rollback();
					e.printStackTrace();
					LOG.error("Excepción! Se ha realizado el rollback.");
				}
			}
			//En caso de que todo haya funcionado perfectamente se hace un commit
			conn.commit();
			LOG.debug("Todos los resultados se insertaron correctamente, se ha realizado el commit.");


		return resul;
		
	}
}
}
