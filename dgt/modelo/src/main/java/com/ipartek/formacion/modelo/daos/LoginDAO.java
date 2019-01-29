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
	 * comprobar si existe el usuario en la bbdd
	 * 
	 * @param email String
	 * @param pass  String pass
	 * @return usuario con datos si existe, null si no existe
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

//	public ArrayList<Agente> getAll() {
//
//		ArrayList<Agente> agentes = new ArrayList<Agente>();
//		String sql = "SELECT id, email, password FROM usuario ORDER BY id DESC LIMIT 100";
//
//		try (Connection conn = ConnectionManager.getConnection();
//				PreparedStatement pst = conn.prepareStatement(sql);
//				ResultSet rs = pst.executeQuery()) {
//
//			while (rs.next()) {
//				try {
//					Agente agente = new Agente();
//					agente.setId(rs.getLong("id"));
//					// insertar en array
//					agentes.add(agente);
//				} catch (Exception e) {
//					System.out.println("usuario no valido");
//					e.printStackTrace();
//				}
//			} // while
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return agentes;
//	}

//	public Agente getByUser(Agente a) {
//		try (Connection conn = ConnectionManager.getConnection();
//				CallableStatement cs = conn.prepareCall(SQL_GETBYID);) {
//			cs.setLong(1, a.getId());
//
//			try (ResultSet rs = cs.executeQuery()) {
//				while (rs.next()) {
//					a = rowMapper(rs);
//				}
//			}
//		} catch (Exception e) {
//			LOG.error(e);
//		}
//		return a;
//	}

//	public boolean insert(Usuario u) throws SQLException {
//		boolean r = false;
//		String sql = "INSERT INTO `usuario` (`email`, `password`) VALUES (?, ?);";
//		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
//			pst.setString(1, u.getEmail());
//			pst.setString(2, u.getPassword());
//			int affectedRows = pst.executeUpdate();
//			if (affectedRows == 1) {
//				r = true;
//			}
//		}
//		return r;
//	}
//	
//	public boolean update(Usuario u) throws SQLException {
//		boolean r = false;
//		String sql = "UPDATE usuario SET email = ?, `password` = ? WHERE id = ?;";
//		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
//			pst.setString(1, u.getEmail());
//			pst.setString(2, u.getPassword());
//			pst.setLong(3, u.getId());
//			int affectedRows = pst.executeUpdate();
//			if (affectedRows == 1) {
//				r = true;
//			}
//		}
//		return r;
//	}
//	
//	public Agente getById(long id) {
//
//		Agente a = null;
//		try (Connection conn = ConnectionManager.getConnection(); CallableStatement cs = conn.prepareCall(SQL_GETBYID);) {
//
//			cs.setLong(1, id);
//
//			try (ResultSet rs = cs.executeQuery()) {
//
//				while (rs.next()) {
//					a = rowMapper(rs);
//				}
//			}
//
//		} catch (Exception e) {
//			LOG.error("El agente que buscas no existe", e);
//		}
//		return a;
//	}

//	public boolean delete(long id) {
//		boolean r = false;
//		String sql = "DELETE FROM `usuario` WHERE (`id` = ?);";
//		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
//			pst.setLong(1, id);
//			int affectedRows = pst.executeUpdate();
//			if (affectedRows == 1) {
//				r = true;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return r;
//	}

	private Agente rowMapper(ResultSet rs) throws SQLException {
		Agente a = new Agente();
		a.setId(rs.getLong("id"));
		a.setNombre(rs.getString("nombre"));
		a.setPlaca(String.valueOf(rs.getInt("placa")));
		a.setPassword(rs.getString("password"));
		return a;
	}
}