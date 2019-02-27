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
	private static final String SQL_GET_PLACA = "SELECT a.id, a.nombre, a.placa, a.password FROM agente as a WHERE a.placa = ? AND a.password = ?;";
	
	
	// Esta sincronizado para que no haya dos peticiones al mismo tiempo SINGLETON
		public synchronized static AgenteDAO getInstance() {
			if (INSTANCE == null) {
				INSTANCE = new AgenteDAO();
			}
			return INSTANCE;
		}
	
	public Agente getByPlaca (String placa, String password) {
		
		Agente a = null;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_PLACA);) {
			pst.setString(1, placa);
			pst.setString(2, password);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					a = rowMapper(rs);
				}
			}
		} catch (Exception e) {
			LOG.error(e);
		}
		
		return a;
	}

	private Agente rowMapper(ResultSet rs) throws SQLException {
		Agente a = new Agente();
		a.setId(rs.getLong("id"));
		a.setNombre(rs.getString("nombre"));
		a.setPlaca(String.valueOf(rs.getInt("placa")));
		a.setPassword(rs.getString("password"));
		return a;
	}

}
