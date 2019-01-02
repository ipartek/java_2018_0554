package com.ipartek.formacion.libroCompartido.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.libroCompartido.modelo.pojo.Usuario;


public class UsuarioDAO {
	 private static UsuarioDAO INSTANCE = null;
	 
	 //constructor privado, solo acceso por getInstance
	 private UsuarioDAO() {
		 super();
	 }
	 //Esta sincronizado para que no haya dos peticiones al mismo tiempo SINGLETON
	 public synchronized static UsuarioDAO getInstance() {
		 if(INSTANCE == null) {
			 INSTANCE = new UsuarioDAO();
		 }
		 return INSTANCE;
	 }
	 
	/**
	 * Metodo que comprueba si existe el usuario en la base de datos
	 * 
	 * @param email    String
	 * @param password String
	 * @return Usuario o null si no existe
	 */
	public Usuario login(String email, String password) {
		Usuario usuario = null;
		String sql = "Select id,email,password from usuario where email=? and password=?";
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setString(1, email);
			pst.setString(2, password);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) { // hemos encontrado ususario
					usuario = new Usuario();
					usuario.setId(rs.getLong("id"));
					usuario.setUsuario(rs.getString("nombre"));
					usuario.setPassword(rs.getString("password"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	/**
	 * Devuelve todos los usuarios
	 * 
	 * @return
	 */
	public ArrayList<Usuario> getAll() {
		ArrayList<Usuario> usuarios = new ArrayList<>();

		String sql = "Select id,email,password from usuario order by id desc limit 500";

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				try {
					Usuario usuario = new Usuario();
					usuario.setId(rs.getLong("id"));
					usuario.setUsuario(rs.getString("nombre"));
					usuario.setPassword(rs.getString("password"));
					// a�adir en array
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


}
