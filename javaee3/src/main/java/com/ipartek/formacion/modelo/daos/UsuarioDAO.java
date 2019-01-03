package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;

import com.ipartek.formacion.modelo.pojos.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {
	
	private static UsuarioDAO INSTANCE = null;
	
	//constructor privado, solo acceso por get instance
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
	 * @param pass String contrase�a
	 * @return usuario con datos si existe, null si no existe
	 */
	public Usuario login (String email, String pass) {
		
		Usuario usuario = null;
		String sql = "SELECT id, email, password FROM usuario WHERE email = ? AND password = ?;";
		
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(sql);
				){						
					pst.setString(1, email); //sustituimos la primera ? por el email
					pst.setString(2, pass);		//sustituimos la segunda ? por el pass	
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
		
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(sql);
			  ResultSet rs = pst.executeQuery() 
			){
			
			while(rs.next()) { 			
				try {
					Usuario usuario = new Usuario();
					usuario.setId( rs.getLong("id"));
					usuario.setEmail( rs.getString("email"));
					usuario.setPassword(rs.getString("password"));
					// añadir en array
					usuarios.add(usuario);
				}catch (Exception e) {					
					e.printStackTrace();
				}		
			} // while	
			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return usuarios;
	}

public boolean insert( Usuario u) throws SQLException {
		
		boolean resul = false;
		String sql = "INSERT INTO `usuario` (`email`, `password`) VALUES (?,?);";
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(sql);				   
			){
			
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());			
			int affectedRows = pst.executeUpdate();
			if ( affectedRows == 1 ) {
				resul = true;
			}
			
		}
		return resul;
		
	}
	
public Usuario getById (long id) {
	
	Usuario usuario = null;
	String sql = "SELECT id, email, password FROM usuario WHERE id = ?;";
	
	try ( Connection conn = ConnectionManager.getConnection();
		  PreparedStatement pst = conn.prepareStatement(sql);
			){						
				pst.setLong(1, id); //sustituimos la primera ? por el id
				
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

public boolean eliminar( long id) throws SQLException {
	
	boolean resul = false;
	String sql = "DELETE FROM `usuario` WHERE `id`=?;";
	try ( Connection conn = ConnectionManager.getConnection();
		  PreparedStatement pst = conn.prepareStatement(sql);				   
		){
		
		pst.setLong(1, id);			
		int affectedRows = pst.executeUpdate();
		if ( affectedRows == 1 ) {
			resul = true;
		}
		
	}
	return resul;
	
}

public boolean update(Usuario u) {
	boolean resul = false;
	String sql = "UPDATE usuario SET email=?, `password`=? WHERE id=?;";
	try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {

		pst.setString(1, u.getEmail());
		pst.setString(2, u.getPassword());
		pst.setLong(3, u.getId());

		int affectedRows = pst.executeUpdate();
		if (affectedRows == 1) {
			resul = true;
		}
	} catch (SQLException e) {
		
	}
	return resul;

}

}