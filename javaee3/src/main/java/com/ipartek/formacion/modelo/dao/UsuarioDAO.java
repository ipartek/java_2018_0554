package com.ipartek.formacion.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Agente;

public class UsuarioDAO {

	private static UsuarioDAO INSTANCE = null;

	// constructor privado, solo acceso por getInstance()
	private UsuarioDAO() {
		super();
	}

	public synchronized static UsuarioDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}
		return INSTANCE;
	}

	/**
	 * comprobar si existe el usuario en la bbdd
	 * 
	 * @param email String
	 * @param pass  String contrase�a
	 * @return usuario con datos si existe, null si no existe
	 */
	public Agente login(String email, String pass) {

		Agente usuario = null;
		String sql = "SELECT id, email, password FROM usuario WHERE email = ? AND password = ?;";

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setString(1, email);
			pst.setString(2, pass);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) { // hemos encontrado usuario
					usuario = new Agente();
					usuario.setId(rs.getLong("id"));
					usuario.setEmail(rs.getString("email"));
					usuario.setPassword(rs.getString("password"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public Agente getById(long id) {

		Agente usuario = null;
		String sql = "SELECT id, email, password FROM usuario WHERE id = ?;";

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setLong(1, id);
			
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) { // hemos encontrado usuario
					usuario = new Agente();
					usuario.setId(rs.getLong("id"));
					usuario.setEmail(rs.getString("email"));
					usuario.setPassword(rs.getString("password"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public ArrayList<Agente> getAll() {

		ArrayList<Agente> usuarios = new ArrayList<Agente>();
		String sql = "SELECT id, email, password FROM usuario ORDER BY id DESC LIMIT 500";

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				try {
					Agente usuario = new Agente();
					usuario.setId(rs.getLong("id"));
					usuario.setEmail(rs.getString("email"));
					usuario.setPassword(rs.getString("password"));
					// a�adir en array
					usuarios.add(usuario);
				} catch (Exception e) {
					System.out.println("usuario no valido");
					e.printStackTrace();
				}
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public boolean insert(Agente u) throws SQLException {

		boolean resul = false;
		String sql = "INSERT INTO `usuario` (`email`, `password`) VALUES (?,?);";
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		}
		return resul;

	}
	
	public boolean update(Agente u) throws SQLException {

		boolean resul = false;
		String sql = "UPDATE `usuario` SET email = ? , password = ? WHERE id = ?;";
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			pst.setLong(3, u.getId());
			
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		}
		return resul;

	}
	
	
	public boolean delete( long id ) throws SQLException {

		boolean resul = false;
		String sql = "DELETE FROM `usuario` WHERE id = ?;";
		try (Connection conn = ConnectionManager.getConnection(); 
			 PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setLong(1, id);
			
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		}
		return resul;

	}

}
