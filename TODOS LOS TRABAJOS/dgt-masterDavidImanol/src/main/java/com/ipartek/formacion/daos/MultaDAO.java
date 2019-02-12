package com.ipartek.formacion.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojos.Agente;
import com.ipartek.formacion.pojos.Multa;

public class MultaDAO {
	
	// dao
	private static MultaDAO INSTANCE = null;
	
	// log 
	private final static Logger LOG = Logger.getLogger(MultaDAO.class);

	// consultas sql con parametros almacenados
	private static final String SQL_INSERT = "{call multa_insert(?,?,?,?,?)}"; // tantos interrogantes como parametros de entrada  y salida
	private static final String SQL_UPDATE = "{call multa_update(?,?)}";
	private static final String SQL_ACTIVAR = "{call multa_activar(?,?)}";
	private static final String SQL_OBJETIVOS = "SELECT importe, id_agente FROM v_objetivos Where id_agente = 4;";
	
	
	// metodo constructor superclase
	private MultaDAO() {
		super();
	}

	// instance singleton
	public synchronized static MultaDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MultaDAO();
		}
		return INSTANCE;
	}

	// metodo para insertar multa
	public boolean insert(Multa multa, Agente agente) throws SQLException {

		boolean resul = false;
		String sql = SQL_INSERT;
		try (Connection conn = ConnectionManager.getConnection(); 
			CallableStatement cs = conn.prepareCall(sql);) {
			
			// parametros de entrada
			cs.setFloat(1, multa.getImporte());
			cs.setString(2, multa.getConcepto());
			cs.setLong(3, multa.getCoche().getId());
			cs.setLong(4, agente.getId());
		
			//parametro de salida
			cs.registerOutParameter(5, Types.INTEGER );

			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				// conseguir id generado
				multa.setId( cs.getLong(5) );	
				resul = true;
				LOG.debug("coche insertado");
			}
			
		}
		return resul;
	}

	// metodo para actualizar multa
	public boolean update(Multa m) throws SQLException {
		
		boolean resul = false;
		String sql = SQL_UPDATE;
		try (Connection conn = ConnectionManager.getConnection(); 
			CallableStatement cs = conn.prepareCall(sql);) {

			// parametros de entrada
			cs.setLong(1, m.getId());
			
			//parametro de salida
			cs.registerOutParameter(2, Types.INTEGER );
	
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				m.setId( cs.getLong(2) );	
				resul = true;
			}
		}
		return resul;

	}

	// metodo para vover a activar la multa
	public boolean activar(Multa m) throws SQLException {
		
		boolean resul = false;
		String sql = SQL_ACTIVAR;
		try (Connection conn = ConnectionManager.getConnection(); 
			CallableStatement cs = conn.prepareCall(sql);) {

			// parametros de entrada
			cs.setLong(1, m.getId());
			
			
			//parametro de salida
			cs.registerOutParameter(2, Types.INTEGER );
	
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				m.setId( cs.getLong(2) );	
				resul = true;
			}
		}
		return resul;

	}
	
	public boolean objetivos(Multa m) throws SQLException {
		
		boolean resul = false;
		String sql  = SQL_OBJETIVOS;
		try (Connection conn = ConnectionManager.getConnection(); 
				PreparedStatement pst = conn.prepareStatement(sql);) {

			// parametros de entrada
			pst.setLong(1, m.getId());
			pst.setFloat(2, m.getImporte());
			
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
				}
			}
			return resul;

	}

	
	
}
