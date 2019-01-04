package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.pojos.Usuario;

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

	public Usuario getById(long id) {

		Usuario usuario = null;
		String sql = "SELECT id, email, password FROM usuario WHERE id = ?;";

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setLong(1, id);

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

	public ArrayList<Usuario> getAll() {

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "SELECT id, email, password FROM usuario ORDER BY id DESC LIMIT 500";

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
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public boolean insert(Usuario u) throws SQLException {

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

	public boolean delete(long id) throws SQLException {

		boolean resul = false;
		
		String sql = "DELETE FROM `usuario` WHERE id = ?;"; //SQL
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setLong(1, id); //cambiamos uno, donde diga el id

			int affectedRows = pst.executeUpdate(); //valor 1??
			if (affectedRows == 1) {  //cambios
				resul = true;
			}

		}
		return resul;

	}

	public boolean update(Usuario u) throws SQLException { //throw para irse los errores
		boolean resul = false;
		
		//UPDATE table_name SET column1 = value1, column2 = value2, ... WHERE condition;
		
		String sql = "UPDATE `usuario` SET email=? , password=?  WHERE id = ?;"; //SQL
		
	try(	Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {

		pst.setString(1,  u.getEmail());
		pst.setString(2, u.getPassword());
		pst.setLong(3, u.getId());
		
		int affectedRows = pst.executeUpdate(); //valor 1??
		if (affectedRows == 1) {  //cambios
			resul = true;
		}
	}
return resul;
}
}