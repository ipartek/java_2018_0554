package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojo.Video;

public class VideoDAO {
	private static final String SQL_DELETE = "DELETE FROM `video` WHERE id = ?;";
	private static final String SQL_UPDATE = "UPDATE `video` SET titulo = ? , codigo = ? WHERE id = ?;";
	private static final String SQL_INSERT = "INSERT INTO `video` (`titulo`, `codigo`) VALUES (?,?);";
	private static final String SQL_GET_ALL_BY_NOMBRE = "SELECT id, titulo, codigo FROM video WHERE titulo LIKE ? ORDER BY titulo ASC LIMIT 500";
	private static final String SQL_GETALL = "SELECT id, titulo, codigo FROM video ORDER BY id DESC LIMIT 500";
	private static final String SQL_GETBYID = "SELECT id, titulo, codigo FROM video WHERE id= ?;";
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
	
public Video getById( long id ) {
		
		Video video = null;
		String sql = SQL_GETBYID;		
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(sql);
			){
			
			pst.setLong(1, id);
			try( ResultSet rs = pst.executeQuery() ){
				while (rs.next()) { 
					video = rowMapper(rs);
				}
			}
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		
		return video;
	}
	
	
	
	

	public ArrayList<Video> getAll() {
		ArrayList<Video> listadoVideos = new ArrayList<Video>();
		Video video = null;
		String sql = SQL_GETALL;
		try (
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			){
				try ( ResultSet rs = pst.executeQuery() ){											
					while(rs.next()) { // hemos encontrado pojo								
						video = rowMapper(rs);	
						listadoVideos.add(video);
					}				
			}	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listadoVideos;
	}
	
	
	
	
	public ArrayList<Video> getAllByNombre(String texto1) {
		String texto = texto1;
		ArrayList<Video> listadoVideosBuscados = new ArrayList<Video>();
		Video video = null;
		String sql = SQL_GET_ALL_BY_NOMBRE;
		try (
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			){
				pst.setString(1, "%"+texto+"%");
				try ( ResultSet rs = pst.executeQuery() ){											
					while(rs.next()) { 							
						video = rowMapper(rs);	
						listadoVideosBuscados.add(video);
					}						
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listadoVideosBuscados;
	}
	
	
	
	
	public boolean insert(Video video) throws SQLException {

		boolean resul = false;
		String sql = SQL_INSERT;
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setString(1, video.getTitulo());
			pst.setString(2, video.getCodigo());
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		}
		return resul;
	}
	
	public boolean update(Video video) throws SQLException {

		boolean resul = false;
		String sql = SQL_UPDATE;
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			
			pst.setString(1, video.getTitulo());
			pst.setString(2, video.getCodigo());
			pst.setLong(3, video.getId());
			
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
	
	
	
	private Video rowMapper(ResultSet rs) throws SQLException {
		Video registro = new Video();
		registro.setId( rs.getLong("id"));
		registro.setCodigo( rs.getString("codigo"));
		registro.setTitulo(rs.getString("titulo"));		
		return registro;
	}

}

