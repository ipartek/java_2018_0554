package com.ipartek.formacion.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.pojo.Usuario;

public class UsuarioDAO {
	
	private static UsuarioDAO INSTANCE = null;
	private final static Logger LOG = Logger.getLogger(UsuarioDAO.class);
	
	//Constructor privado, solo acceso por getInstance()
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
	 * @param email String 
	 * @param pass String contraseña
	 * @return usuario con datos si existe, null si no existe
	 */
	public Usuario login (String email, String pass) {
		
		Usuario usuario = null;
		String sql = "SELECT id, email, password FROM usuario WHERE email = ? AND password = ?;";
		
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(sql);
				){						
					pst.setString(1, email);
					pst.setString(2, pass);			
					try ( ResultSet rs = pst.executeQuery() ){											
							while(rs.next()) { // hemos encontrado usuario								
								usuario = new Usuario();
								usuario.setId( rs.getLong("id"));
								usuario.setEmail( rs.getString("email"));
								usuario.setPassword(rs.getString("password"));								
							}						
					}
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return usuario;
	}

	public ArrayList<Usuario> getAll() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "SELECT id, email, password FROM usuario ORDER BY id DESC LIMIT 500";
		try(Connection conn = ConnectionManager.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery()
		) {
			
			while(rs.next()) {
				try {
					
				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setEmail(rs.getString("email"));
				usuario.setPassword(rs.getString("password"));
				usuarios.add(usuario);
				}catch (Exception e) {
					
					LOG.error("Error construyendo el usuario de la DB");
					e.printStackTrace();
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuarios;
	}
	
	public boolean insert(Usuario u) throws SQLException {
		boolean result = false;
		String sql = "INSERT INTO `usuario` (`email`, `password`) VALUES (?, ?)";
		try( Connection conn = ConnectionManager.getConnection();
			 PreparedStatement pst = conn.prepareStatement(sql);
			){
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				result = true;
			}
		}
		return result;
	}
	
	public Usuario getById(Long identificador) {
		Usuario usuario = null;
		
		String sql = "SELECT id, email, `password` FROM usuario WHERE id=?";
		try( Connection conn = ConnectionManager.getConnection();
			 PreparedStatement pst = conn.prepareStatement(sql);
			){
			pst.setLong(1, identificador);
			try ( ResultSet rs = pst.executeQuery() ){											
				while(rs.next()) { // hemos encontrado usuario								
					usuario = new Usuario();
					usuario.setId( rs.getLong("id"));
					usuario.setEmail( rs.getString("email"));
					usuario.setPassword(rs.getString("password"));								
				}						
			}
		} catch (SQLException e) {
			LOG.error(e);
		}
		
		return usuario;
	}
	
	public boolean update(Usuario u) throws SQLException {
		boolean result = false;
		String sql = "UPDATE usuario SET email = ?, `password` = ? WHERE id= ? ;";
		try( Connection conn = ConnectionManager.getConnection();
			 PreparedStatement pst = conn.prepareStatement(sql);
			){
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			pst.setLong(3, u.getId());
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				result = true;
			}
		}
		return result;
	}
	


	public void delete(Long identificador) {
		// TODO Auto-generated method stub
		
	}

}
