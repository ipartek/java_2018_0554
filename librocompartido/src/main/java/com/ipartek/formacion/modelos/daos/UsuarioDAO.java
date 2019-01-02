package com.ipartek.formacion.modelos.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.modelos.pojos.Usuario;

public class UsuarioDAO {
	private static UsuarioDAO INSTANCE = null;

	private UsuarioDAO() {
		super();
	}
	
	public synchronized static UsuarioDAO getInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new UsuarioDAO();
        }
        return INSTANCE;
    }

	public Usuario loginCorrecto(String email, String password) {
		Usuario usuario = null;
		String sql = "SELECT id, email, password FROM usuario WHERE email=? AND password=?";
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setString(1, email);
			pst.setString(2, password);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					usuario = new Usuario(rs.getInt("id"),rs.getString("email"), rs.getString("password"), rs.getString("nombre"));
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public ArrayList<Usuario> leerTodos() {
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

}
