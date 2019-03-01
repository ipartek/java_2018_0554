package com.ipartek.formacion.modelo.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.cm.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Agente;

public class LoginDAO {
	private final static Logger LOG = Logger.getLogger(LoginDAO.class);
	private static LoginDAO INSTANCE = null;
	private static final String SQL_LOGIN = "{call pa_login(?, ?)}";

	// Constructor privado, solo acceso por getInstance()
	private LoginDAO() {
		super();
	}

	public synchronized static LoginDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new LoginDAO();
		}
		return INSTANCE;
	}

	/**
	 * 
	 * 
	 * @param email 
	 * @param pass  
	 * @return usuario existe, null si no existe
	 */
	public Agente login(int placa, String password) {

		Agente a = null;

		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(SQL_LOGIN);) {
			cs.setInt(1, placa);
			cs.setString(2, password);
			try (ResultSet rs = cs.executeQuery()) {
				while (rs.next()) { // hemos encontrado usuario
					a = rowMapper(rs);
				}
			}
			catch (Exception e) {
				LOG.error(e);
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