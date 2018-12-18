package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojos.Usuario;


public class UsuarioDao {
	
	/**
	 * comprobar si existe el usuario en la BD
	 * @param email String
	 * @param pass String
	 * @return Usuario con datos si existe, null si no existe
	 */
	public Usuario login (String email, String pass) {
		
		Usuario usuario = null;
		
		String sql = "SELECT id, nombre, password FROM usuario\r\n" + 
				" WHERE nombre = ? AND password = ?";
				
		try(Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				
				) {
			
			pst.setString(1, email);
			pst.setString(2, pass);
			
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next()) {
					usuario = new Usuario();
					usuario.setId(rs.getLong("id"));
					usuario.setEmail(rs.getString("nombre"));
					usuario.setPassword(rs.getString("password"));
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
				
		return usuario;
	}

	public ArrayList<Usuario> getAll() {
		ArrayList <Usuario> usuarios = new ArrayList <Usuario>();
		//ArrayList<Usuario>
		
		String sql = "SELECT id, nombre, password FROM usuario ORDER BY id DESC LIMIT 500";
		try(Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {
			
			while(rs.next()) {
				try {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setEmail(rs.getString("nombre"));
				usuario.setPassword(rs.getString("password"));
				//añadimos en array
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

	public ArrayList<String> getAllNoValid() {
		ArrayList <Usuario> usuarios = new ArrayList <Usuario>();
		ArrayList<String> usuariosNoValidos = new ArrayList <String>();
		
		String sql = "SELECT id, nombre, password FROM usuario ORDER BY id DESC LIMIT 500";
		try(Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {
			
			while(rs.next()) {
				try {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setEmail(rs.getString("nombre"));
				usuario.setPassword(rs.getString("password"));
				//añadimos en array
				usuarios.add(usuario);
				}catch(Exception e) {
					String usuarioNo = rs.getString("nombre");
					usuariosNoValidos.add(usuarioNo);
					System.out.println("usuario no valido");
					e.printStackTrace();
				}
			}
			
		}catch(Exception e) {
			
		}
		return usuariosNoValidos;
	}
	
	

}
