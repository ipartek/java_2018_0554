package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojos.Usuario;
import com.ipartek.formacion.modelo.pojos.UsuarioNoValido;
import com.mysql.fabric.Response;

public class UsuarioDAO {

	/**
	 * Metodo que comprueba si existe el usuario en la base de datos
	 * 
	 * @param email    String
	 * @param password String
	 * @return Usuario o null si no existe
	 */
	public Usuario login(String email, String password) {
		Usuario usuario = null;
		String sql = "Select id,nombre,password from usuario where nombre=? and password=?";
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setString(1, email);
			pst.setString(2, password);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) { // hemos encontrado ususario
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

	/**
	 * Devuekve todos los usuarios
	 * 
	 * @return
	 */
	public ArrayList<Usuario> getAll() {
		ArrayList<Usuario> usuarios = new ArrayList<>();

		String sql = "Select id,nombre,password from usuario order by id desc limit 500";

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
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

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	public ArrayList<UsuarioNoValido> getAllNoValid() {
		ArrayList<UsuarioNoValido> usuariosNovalidos = new ArrayList<>();

		String sql = "Select id,nombre,password from usuario order by id desc limit 500";

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				try {
					Usuario usuario = new Usuario();
					usuario.setId(rs.getLong("id"));
					usuario.setEmail(rs.getString("nombre"));
					usuario.setPassword(rs.getString("password"));

				} catch (Exception e) {
					UsuarioNoValido userNoValido = new UsuarioNoValido(rs.getLong("id"), rs.getString("nombre"),rs.getString("password"));
					// añadir en array
					usuariosNovalidos.add(userNoValido);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuariosNovalidos;
	}
}
