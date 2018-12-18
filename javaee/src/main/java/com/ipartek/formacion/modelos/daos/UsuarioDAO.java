package com.ipartek.formacion.modelos.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.modelos.pojos.Usuario;

public class UsuarioDAO {

	public Usuario login(String email, String password) {

		Usuario usuario = null;
		String sql = "SELECT id, nombre, password FROM usuario WHERE nombre=? AND Password=?";
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setString(1, email);
			pst.setString(2, password);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("password"));
					break;
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public ArrayList<Usuario> getAllValidos() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "select id,nombre, password from usuario";
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {
				try {
					Usuario usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setEmail(rs.getString("nombre"));
					usuario.setPassword(rs.getString("password"));
					usuarios.add(usuario);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public ArrayList<String> getAllNoValidos() {
		ArrayList<String> usuarios = new ArrayList<String>();
		String sql = "select id,nombre, password from usuario";
		Usuario usuario;
		Integer id=null;
		String email=null;
		String pass=null;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {
				try {
					usuario = new Usuario();
					id= rs.getInt("id");
					email= rs.getString("nombre");
					pass=rs.getString("password");
					usuario.setId(id);
					usuario.setEmail(email);
					usuario.setPassword(pass);
				} catch (Exception e) {
					usuarios.add("Usuario "+id+" "+email+" "+pass);
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}

}
