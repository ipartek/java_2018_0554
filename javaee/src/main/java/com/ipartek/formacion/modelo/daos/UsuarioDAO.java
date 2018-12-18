package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.daos.ConnectionManager;
import com.ipartek.formacion.modelo.pojos.Usuario;

public class UsuarioDAO {

	/**
	 * comprobar si existe el usuario en la bbdd
	 * 
	 * @param email
	 *            String
	 * @param pass
	 *            String contraseña
	 * @return usuario con datos si existe, null si no existe
	 */
	public Usuario login(String email, String pass) {

		Usuario usuario = null;
		String sql = "SELECT id, nombre, password FROM usuario WHERE nombre = ? AND password = ?;";

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setString(1, email);
			pst.setString(2, pass);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) { // hemos encontrado usuario
					usuario = new Usuario();
					usuario.setId(rs.getLong("id"));
					usuario.setEmail(rs.getString("nombre"));
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
		String sql = "SELECT id, nombre, password FROM usuario ORDER BY id DESC LIMIT 100";

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				try {
					Usuario usuario = new Usuario();
					usuario.setId(rs.getLong("id"));
					usuario.setEmail(rs.getString("nombre"));
					usuario.setPassword(rs.getString("password"));
					// añadir en array
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

}