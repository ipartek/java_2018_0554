package com.ipartek.formacion.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Usuario;
import com.ipartek.formacion.modelo.pojo.Video;

public class VideoDAO {

	public static final String SQL_GETALL = "SELECT id, nombre, codigo FROM video ORDER BY id DESC LIMIT 500;";
	public static final String SQL_GETBYID = "SELECT id, nombre, codigo FROM video WHERE id= ?;";
	public static final String SQL_GETALLBYNOMBRE = "SELECT id, nombre, codigo FROM video WHERE NOMBRE LIKE ? ORDER BY id DESC LIMIT 500;";
	public static final String SQL_INSERT = "INSERT INTO `video` (`nombre`, `codigo`) VALUES (?,?);";
	public static final String SQL_UPDATE = "UPDATE `video` SET nombre=? , codigo=? WHERE id=?";
	public static final String SQL_DELETE = "DELETE from `video` where id=?";
	
	private static VideoDAO INSTANCE = null;

	// constructor privado, solo acceso por getInstance()
	private VideoDAO() {
		super();
	}

	public synchronized static VideoDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new VideoDAO();
		}
		return INSTANCE;
	}

	public Video getById(long id) {

		Video registro = null;

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(SQL_GETBYID);) {

			pst.setLong(1, id);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					registro = new Video();
					registro.setId(rs.getLong("id"));
					registro.setNombre(rs.getString("nombre"));
					registro.setCodigo(rs.getString("codigo"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return registro;
	}

	public ArrayList<Video> getAll() {

		ArrayList<Video> listado = new ArrayList<Video>();

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GETALL);
				ResultSet rs = pst.executeQuery()) {
			Video v = null;
			while (rs.next()) {
				try {
					v = new Video();
					v.setId(rs.getLong("id"));
					v.setNombre(rs.getString("nombre"));
					v.setCodigo(rs.getString("codigo"));
					listado.add(v);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listado;
	}

	public ArrayList<Video> getAllByNombre(String nombre) {

		ArrayList<Video> listado = new ArrayList<Video>();
		

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(SQL_GETALLBYNOMBRE);

		) {

			pst.setString(1, "%" + nombre + "%");

			try (ResultSet rs = pst.executeQuery()) {

				Video v = null;
				while (rs.next()) {
					try {
						v = new Video();
						v.setId(rs.getLong("id"));
						v.setNombre(rs.getString("nombre"));
						v.setCodigo(rs.getString("codigo"));
						listado.add(v);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} // while
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listado;
	}
public boolean insert( Video v) throws SQLException {
		
		boolean resul = false;

		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(SQL_INSERT);				   
			){
			
			pst.setString(1, v.getNombre());
			pst.setString(2, v.getCodigo());			
			int affectedRows = pst.executeUpdate();
			if ( affectedRows == 1 ) {
				resul = true;
			}
			
		}
		return resul;
		
	}

	
public boolean update(Video v) throws SQLException {
		
		boolean resul = false;

		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(SQL_UPDATE);				   
			){
			
			pst.setString(1, v.getNombre());
			pst.setString(2, v.getCodigo());
			pst.setLong(3,v.getId());	
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

//private Video rowMapper{
//	v = new Video();
//	v.setId(rs.getLong("id"));
//	v.setNombre(rs.getString("nombre"));
//	v.setCodigo(rs.getString("codigo"));
//	listado.add(v);
//}

}
