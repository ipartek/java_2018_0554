package com.ipartek.formacion.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.pojo.Usuario;

public class UsuarioDAO {
	
	private static final String SQL_COUNT = "SELECT COUNT(*) as n_usuarios FROM usuario";
	private static final String SQL_DELETE = "DELETE FROM usuario WHERE id = ? ;";
	private static final String SQL_UPDATE = "UPDATE usuario SET email = ?, `password` = ? WHERE id= ? ;";
	private static final String SQL_GETBYID = "SELECT id, email, `password` FROM usuario WHERE id=? ;";
	private static final String SQL_INSERT = "INSERT INTO `usuario` (`email`, `password`) VALUES (?, ?) ;";
	private static final String SQL_GETALL = "SELECT id, email, password FROM usuario ORDER BY id DESC LIMIT 500 ;";
	private static final String SQL_LOGIN = "SELECT id, email, password FROM usuario WHERE email = ? AND password = ? ;";
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
		String sql = SQL_LOGIN;
		
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
		String sql = SQL_GETALL;
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
		String sql = SQL_INSERT;
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
		
		String sql = SQL_GETBYID;
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
		String sql = SQL_UPDATE;
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
	


	public boolean delete(Long identificador) throws SQLException {
		boolean result = false;
		String sql = SQL_DELETE;
		try( Connection conn = ConnectionManager.getConnection();
			 PreparedStatement pst = conn.prepareStatement(sql);
			){
			pst.setLong(1, identificador);
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				result = true;
			}
		}
		return result;
		
	}
	
	public int countUsers() {
		int usuarios = 0;
		
		String sql = SQL_COUNT;
		try( Connection conn = ConnectionManager.getConnection();
			 PreparedStatement pst = conn.prepareStatement(sql);
			){
			
			try ( ResultSet rs = pst.executeQuery() ){											
				while(rs.next()) { // hemos encontrado usuario								
					usuarios =  rs.getInt("n_usuarios");	
				}						
			}
		} catch (SQLException e) {
			LOG.error(e);
		}
		
		return usuarios;
	}

}
