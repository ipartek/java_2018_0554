package com.ipartek.formacion.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Categoria;
import com.ipartek.formacion.modelo.pojo.Usuario;
import com.ipartek.formacion.modelo.pojo.Video;

public class CategoriaDAO {

	public static final String SQL_GETALL = "SELECT id, nombre from categoria;";
	public static final String SQL_INSERT = "INSERT INTO `categoria` (`nombre`) VALUES (?);";
	public static final String SQL_UPDATE = "UPDATE `categoria` SET nombre=? WHERE id=?";
	public static final String SQL_DELETE = "DELETE from `categoria` where id=?";
	
	private static CategoriaDAO INSTANCE = null;

	// constructor privado, solo acceso por getInstance()
	private CategoriaDAO() {
		super();
	}

	public synchronized static CategoriaDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new CategoriaDAO();
		}
		return INSTANCE;
	}

	public ArrayList<Video> getAll() {

		ArrayList<Video> listado = new ArrayList<Video>();

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GETALL);
				ResultSet rs = pst.executeQuery()) {
			Video v = null;
			while (rs.next()) {
				try {

					listado.add(rowMapper(rs));
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listado;
	}


public boolean insert( Categoria c) throws SQLException {
		
		boolean resul = false;

		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(SQL_INSERT);				   
			){
			
			pst.setString(1, v.getNombre());
			pst.setString(2, v.getCodigo());	
			pst.setLong(3, v.getUsuario().getId());
			int affectedRows = pst.executeUpdate();
			if ( affectedRows == 1 ) {
				resul = true;
			}
			
		}
		return resul;
		
	}

	
public boolean update(Categoria c) throws SQLException {
		
		boolean resul = false;

		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(SQL_UPDATE);				   
			){
			
			pst.setString(1, v.getNombre());
			pst.setString(2, v.getCodigo());
			pst.setLong(3, v.getUsuario().getId());
			pst.setLong(4, v.getId());
				
			int affectedRows = pst.executeUpdate();
			if ( affectedRows == 1 ) {
				resul = true;
			}
			
		}
		return resul;
	}

public boolean delete( long id) throws SQLException {
		
		boolean resul = false;

		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(SQL_DELETE);				   
			){
			
			pst.setLong(1, id);		
			int affectedRows = pst.executeUpdate();
			if ( affectedRows == 1 ) {
				resul = true;
			}
			
		}
		return resul;
		
	}

private Video rowMapper(ResultSet rs) throws SQLException{
	Video v = new Video();
	v.setId(rs.getLong("id_video"));
	v.setNombre(rs.getString("nombre"));
	v.setCodigo(rs.getString("codigo"));

	 
	 Usuario u = new Usuario();
	 u.setId(rs.getLong("id_usuario"));
	 u.setEmail(rs.getString("email"));
	 u.setPassword(rs.getString("password"));
	 
	 v.setUsuario(u);
	 
	 return v;
}

}
