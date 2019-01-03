package com.ipartek.formacion.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.LoginController;
import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Usuario;

public class UsuarioDAO {

	private static UsuarioDAO INSTANCE = null;
	private final static Logger LOG = Logger.getLogger(LoginController.class);

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

	public Usuario login(String email, String pass) {

		Usuario usuario = null;
		String sql = "SELECT id, email, password FROM usuario WHERE email = ? AND password = ?;";

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setString(1, email);
			pst.setString(2, pass);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) { // hemos encontrado usuario
					usuario = new Usuario();
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

	public ArrayList<Usuario> getAll() throws SQLException {

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "SELECT id, email, password FROM usuario ORDER BY id ASC LIMIT 500";

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				try {
					Usuario usuario = new Usuario();
					usuario.setId(rs.getLong("id"));
					usuario.setEmail(rs.getString("email"));
					usuario.setPassword(rs.getString("password"));
					// a�adir en array
					usuarios.add(usuario);
					
				} catch (Exception e) {
					System.out.println("usuario no valido");
					e.printStackTrace();
				}
			}

		} 
		return usuarios;
	}
	
	public boolean delete(long ident) throws SQLException {

		boolean resul=false;
		Usuario usuario = null;
		String sql = "DELETE FROM usuario WHERE id = ? ;";

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setLong(1,ident);
			
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	public Usuario getById(long ident) throws SQLException {


		Usuario usuario = null;
		String sql = "SELECT id, email, password FROM usuario WHERE id = ? ;";

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setLong(1,ident);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					usuario = new Usuario();
					usuario.setId(rs.getLong("id"));
					usuario.setEmail(rs.getString("email"));
					usuario.setPassword(rs.getString("password"));
				}
			}
		} 
		return usuario;
	}

	public boolean insert(Usuario u) throws SQLException {
		boolean resul = false;
		String sql = "INSERT INTO usuario (email, `password`) VALUES (?,?);";
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
	
	public boolean update(Usuario u) throws SQLException {
		boolean resul = false;
		String sql = "UPDATE usuario SET email=?, `password`=? WHERE id=?;";
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

}
