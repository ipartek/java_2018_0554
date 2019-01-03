package com.ipartek.formacion.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.UsuariosController;
import com.ipartek.formacion.modelo.pojo.Usuario;
import com.ipartek.formacion.modelo.pojo.Video;

public class VideoDAO {
	
	private static VideoDAO INSTANCE = null;
	
	private final static Logger LOG = Logger.getLogger(VideoDAO.class);
	
	private VideoDAO() {
		super();
	}
	
	public synchronized static VideoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VideoDAO();
		}
		
		return INSTANCE;
	}
	
	public ArrayList<Video> getAll(){
		ArrayList<Video> videos = new ArrayList<Video>();
		String sql = "SELECT id, nombre, codigo FROM video ORDER BY id DESC LIMIT 500";
		try(Connection conn = ConnectionManager.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery()
		) {
			
			while(rs.next()) {
				try {
					
				Video video = new Video();
				video.setId(rs.getLong("id"));
				video.setNombre(rs.getString("nombre"));
				video.setCodigo(rs.getString("codigo"));
				videos.add(video);
				}catch (Exception e) {
					
					System.out.println("Video no válido");
					e.printStackTrace();
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return videos;
	}
	
	public ArrayList<Video> buscarVideo(String nombre){
		ArrayList<Video> videos = new ArrayList<Video>();
		String sql = "SELECT id, nombre, codigo FROM video WHERE nombre LIKE ? ORDER BY id DESC LIMIT 500";
		try(Connection conn = ConnectionManager.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
		) {
			
			pst.setString(1, "%" + nombre + "%");
			
			try(ResultSet rs = pst.executeQuery()
			){
				while(rs.next()) {
					try {
						
					Video video = new Video();
					video.setId(rs.getLong("id"));
					video.setNombre(rs.getString("nombre"));
					video.setCodigo(rs.getString("codigo"));
					videos.add(video);
					}catch (Exception e) {
						
						System.out.println("Video no válido");
						e.printStackTrace();
					}
				}
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return videos;
	}

	public Video getById(Long identificador) {
		Video video = null;
		
		String sql = "SELECT id, nombre, codigo FROM video WHERE id=? ;";
		try( Connection conn = ConnectionManager.getConnection();
			 PreparedStatement pst = conn.prepareStatement(sql);
			){
			pst.setLong(1, identificador);
			try ( ResultSet rs = pst.executeQuery() ){											
				while(rs.next()) { // hemos encontrado usuario								
					video = new Video();
					video.setId( rs.getLong("id"));
					video.setNombre( rs.getString("nombre"));
					video.setCodigo(rs.getString("codigo"));								
				}						
			}
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		
		return video;
	}

	public boolean update(Video v) throws SQLException {
		boolean result = false;
		String sql = "UPDATE video SET nombre = ?, codigo = ? WHERE id= ? ;";
		try( Connection conn = ConnectionManager.getConnection();
			 PreparedStatement pst = conn.prepareStatement(sql);
			){
			pst.setString(1, v.getNombre());
			pst.setString(2, v.getCodigo());
			pst.setLong(3, v.getId());
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				result = true;
			}
		}
		return result;
		
	}

	public boolean insert(Video v) throws SQLException {
		boolean result = false;
		String sql = "INSERT INTO `video` (`nombre`, `codigo`) VALUES (?, ?) ;";
		try( Connection conn = ConnectionManager.getConnection();
			 PreparedStatement pst = conn.prepareStatement(sql);
			){
			pst.setString(1, v.getNombre());
			pst.setString(2, v.getCodigo());
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				result = true;
			}
		}
		return result;
		
	}

	public boolean delete(Long identificador) throws SQLException {
		boolean result = false;
		String sql = "DELETE FROM video WHERE id = ? ;";
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

}
