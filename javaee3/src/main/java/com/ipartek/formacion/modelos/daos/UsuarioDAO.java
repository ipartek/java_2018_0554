package com.ipartek.formacion.modelos.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.pojo.Usuario;


public class UsuarioDAO {
	private static final String SQL_GETBYID = "SELECT id,email,password FROM usuario WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM usuario WHERE id=?";
	private static final String SQL_UPDATE = "UPDATE usuario SET email=?, `password`=? WHERE id=?;";
	private static final String SQL_INSERT = "INSERT INTO usuario (email,`password`) VALUES(?,?);";
	private static final String SQL_GETALL = "Select id,email,password from usuario order by id desc limit 500";
	private static final String SQL_LOGIN = "SELECT id,email,password FROM usuario WHERE email=? AND password=?";
	private static final String SQL_COUNTUSUARIOS="SELECT count(*) AS totalUsuarios FROM usuario";
	private final static Logger LOG = Logger.getLogger(UsuarioDAO.class);
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
		String sql = SQL_LOGIN;
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

		String sql = SQL_GETALL;

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
	/**
	 * Metodo que cuenta el total de usuarios que hay en la base de datos
	 * @return Devuelve un int --> el total de usuarios en la BBDD
	 */
	public int count() {
		int numTotalUsuarios= 0;
		String sql = SQL_COUNTUSUARIOS;
		try(Connection conn = ConnectionManager.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery()
			){
			while(rs.next()) {
				numTotalUsuarios= rs.getInt("totalUsuarios");
			}
		} catch (Exception e) {
			LOG.trace(e);
		}
		return numTotalUsuarios;
	}
	public boolean insert(Usuario u ) throws SQLException {
		boolean resul= false;
		String sql =SQL_INSERT;
		
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
		String sql =SQL_UPDATE;
		
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
	/**
	 * Metodo que elimina un usuario de la base de datos mediante el id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean eliminar(Long id) throws SQLException {
		boolean resul=false;
		String sql=SQL_DELETE;
		
		
		try(
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			){
			pst.setLong(1, id);
			int affectedRows = pst.executeUpdate();
			
			if(affectedRows == 1) {
				resul = true;
			}
		}
		return resul;
	}

	/**
	 * Metodo que busca un usuario por su id
	 * @param id
	 * @return
	 */
	public Usuario getById(Long id) {
		Usuario usuario = null;
		String sql = SQL_GETBYID;
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
