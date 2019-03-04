package com.ipartek.formacion.modelo.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.cm.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Agente;


public class AgenteDAO {
	private final static Logger LOG = Logger.getLogger(AgenteDAO.class);
	private static AgenteDAO INSTANCE = null;
	
	private static final String SQL_GETLOGIN = "SELECT id, nombre, placa, password FROM dgt.agente where agente.placa= ? and agente.password = ?;";
	
	// constructor privado, solo acceso por getInstance()
		private AgenteDAO() {
			super();
		}

		public synchronized static AgenteDAO getInstance() {

			if (INSTANCE == null) {
				INSTANCE = new AgenteDAO();
			}
			return INSTANCE;
		}
		
		
		public Agente getLogin( int placa, String password){
			Agente agenteEncontrado = null;
			

			try (Connection conn = ConnectionManager.getConnection();
					PreparedStatement ps = conn.prepareStatement(SQL_GETLOGIN);) {
				
				ps.setInt(1, placa);
				ps.setString(2, password);
				
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						agenteEncontrado = rowMapper(rs);
					}
					LOG.debug("Agente encontrado");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return agenteEncontrado;
		}
		
		
		
		private Agente rowMapper(ResultSet rs) throws SQLException {
			Agente ag = new Agente();
			ag.setId((long)rs.getInt("id"));
			ag.setNombre(rs.getString("nombre"));
			ag.setPlaca(rs.getString("placa"));
			ag.setPassword(rs.getString("password"));
			return ag;
		}
}
