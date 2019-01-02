package com.ipartek.formacion.modelos.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojo.Usuario;


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
		String sql = "SELECT id,email,password FROM usuario WHERE email=? AND password=?";
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setString(1, email);
			pst.setString(2, password);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) { // hemos encontrado ususario
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

	/**
	 * Devuekve todos los usuarios
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
					usuario.setEmail(rs.getString("email"));
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
	
	public boolean insert(Usuario u ) throws SQLException {
		boolean resul= false;
		String sql ="INSERT INTO usuario (email,`password`) VALUES(?,?);";
		
		try(
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			){
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			int affectedRows = pst.executeUpdate();
			
			if(affectedRows == 1) {
				resul = true;
			}
		}
		return resul;
	}
	
	public boolean update(Usuario u) throws SQLException {
		boolean resul= false;
		String sql ="UPDATE usuario SET email=?, `password`=? WHERE id=?;";
		
		try(Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
			){
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			pst.setLong(3, u.getId());
			int affectedRows = pst.executeUpdate();
			
			if(affectedRows == 1) {
				resul = true;
			}
			
		}
		
		return resul;
	}
	public void eliminar(String id) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Metodo que busca un usuario por su id
	 * @param id
	 * @return
	 */
	public Usuario getById(Long id) {
		Usuario usuario = null;
		String sql = "SELECT id,email,password FROM usuario WHERE id=?";
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setLong(1, id);
	
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) { // hemos encontrado ususario
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



}
