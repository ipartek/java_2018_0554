package com.ipartek.formacion.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojo.Usuario;


public class UsuarioDao {
	
	 private static UsuarioDao INSTANCE = null;
	 
	 //constructor privado, solo acceso por Getinstance
	 private UsuarioDao() {
		 super();
	 }
	 
	 public synchronized static UsuarioDao getInstance() {
		 if(INSTANCE == null) {
			 INSTANCE = new UsuarioDao();
		 }
		 return INSTANCE;
	 }
	
	/**
	 * comprobar si existe el usuario en la BD
	 * @param email String
	 * @param pass String
	 * @return Usuario con datos si existe, null si no existe
	 */
	public Usuario login (String email, String pass) {
		
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

	public ArrayList<Usuario> getAll() {
		ArrayList <Usuario> usuarios = new ArrayList <Usuario>();
		//ArrayList<Usuario>
		
		String sql = "SELECT id, email, password FROM usuario ORDER BY id DESC LIMIT 500";
		try(Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {
			
			while(rs.next()) {
				try {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setEmail(rs.getString("email"));
				usuario.setPassword(rs.getString("password"));
				//a�adimos en array
				usuarios.add(usuario);
				}catch(Exception e) {
					usuarios.toString();
					System.out.println("usuario no valido");
					e.printStackTrace();
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return usuarios;
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
	
	

	public ArrayList<String> getAllNoValid() {
		ArrayList <Usuario> usuarios = new ArrayList <Usuario>();
		ArrayList<String> usuariosNoValidos = new ArrayList <String>();
		
		String sql = "SELECT id, email, password FROM usuario ORDER BY id DESC LIMIT 500";
		try(Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {
			
			while(rs.next()) {
				try {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setEmail(rs.getString("email"));
				usuario.setPassword(rs.getString("password"));
				//a�adimos en array
				usuarios.add(usuario);
				}catch(Exception e) {
					String usuarioNo = rs.getString("email");
					usuariosNoValidos.add(usuarioNo);
					System.out.println("usuario no valido");
					e.printStackTrace();
				}
			}
			
		}catch(Exception e) {
			
		}
		return usuariosNoValidos;
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
	
	
	public boolean update(Usuario u) throws SQLException {

		boolean resul = false;
		String sql = "UPDATE `usuario` SET email = ?, password = ? WHERE id = ?;";
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
