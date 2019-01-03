package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojo.Usuario;
import com.ipartek.formacion.modelo.pojo.Video;

public class UsuarioDAO {
	
	private static final String SQL_DELETE = "DELETE FROM `usuario` WHERE id = ?;";
	private static final String SQL_UPDATE = "UPDATE `usuario` SET email = ? , password = ? WHERE id = ?;";
	private static final String SQL_INSERT = "INSERT INTO `usuario` (`email`, `password`) VALUES (?,?);";
	private static final String SQL_GET_ALL = "SELECT id, email, password FROM usuario ORDER BY id DESC LIMIT 500";
	private static final String SQL_GET_BY_ID = "SELECT id, email, password FROM usuario WHERE id = ?;";
	private static final String SQL_LOGIN = "SELECT id, email, password FROM usuario WHERE email = ? AND password = ?;";
	private static UsuarioDAO INSTANCE = null;
	
	//CONSTRUCTOR PRIVADO SOLO ACCESO POR getInstance
	//PATRON SINGLETON
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
		String sql = SQL_LOGIN;
		
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(sql);
				){						
					pst.setString(1, email);
					pst.setString(2, pass);			
					try ( ResultSet rs = pst.executeQuery() ){											
							while(rs.next()) { 						
								usuario = rowMapper(rs);								
							}						
					}
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return usuario;
	}
	
	
	public Usuario getById(long id) {

		Usuario usuario = null;
		String sql = SQL_GET_BY_ID;

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setLong(1, id);
			
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) { // hemos encontrado usuario
					usuario = rowMapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
	

	public ArrayList<Usuario> getAll() {
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = SQL_GET_ALL;	
		Usuario usuario = null;
		
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(sql);
			  ResultSet rs = pst.executeQuery() 
			){
			
			while(rs.next()) { 			
				try {
					usuario = rowMapper(rs);
					usuarios.add(usuario);
				}catch (Exception e) {
					System.out.println("usuario no valido");
					e.printStackTrace();
				}		
			} // while	
			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return usuarios;
	}
	
	
	

//	public ArrayList<String> getAllNoValid() {
//		
//		ArrayList<String> usuariosmal= new ArrayList<String>();
//		String sql = SQL_GET_ALL;		
//		
//		try ( Connection conn = ConnectionManager.getConnection();
//				  PreparedStatement pst = conn.prepareStatement(sql);
//				  ResultSet rs = pst.executeQuery() 
//				){
//				
//				while(rs.next()) { 			
//					try {
//						Usuario usuario = new Usuario();
//						//usuario.setId( rs.getLong("id"));
//						usuario.setEmail( rs.getString("email"));
//						usuario.setPassword(rs.getString("password"));
//						
//					}catch (Exception e) {
//						String nombre = rs.getString("email");
//						usuariosmal.add(nombre);
//					}	
//				} // while	
//				
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		return usuariosmal;
//	}
	
	
	
	
	
	
	
	public boolean insert(Usuario u) throws SQLException {

		boolean resul = false;
		String sql = SQL_INSERT;
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
		String sql = SQL_UPDATE;
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
		String sql = SQL_DELETE;
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
	
	private Usuario rowMapper(ResultSet rs) throws SQLException {
		Usuario registro = new Usuario();
		registro.setId( rs.getLong("id"));
		registro.setEmail( rs.getString("email"));
		registro.setPassword(rs.getString("password"));		
		return registro;
	}

}
