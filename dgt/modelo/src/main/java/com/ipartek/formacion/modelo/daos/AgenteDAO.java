package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.ipartek.formacion.modelo.cm.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Agente;

public class AgenteDAO {
	private final static Logger LOG = Logger.getLogger(MultaDAO.class);
	private static AgenteDAO INSTANCE = null;

	private static final String SQL_GETBYID = "SELECT nombre, placa, password FROM agente WHERE placa=? and password=?;";

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

	public Agente getAgente(int placaAgente, String password) {

		Agente a = null;

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_GETBYID);) {
			ps.setInt(1, placaAgente);
			ps.setString(2, password);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					a = rowMapper(rs);
				}
				LOG.debug("Agente localizado");
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
		a.setPlaca(rs.getString("placa"));
		a.setPassword(rs.getString("password"));

		return a;

	}



}
