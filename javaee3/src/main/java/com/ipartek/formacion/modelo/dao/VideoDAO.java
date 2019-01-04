package com.ipartek.formacion.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.pojo.Usuario;
import com.ipartek.formacion.modelo.pojo.Video;

public class VideoDAO {
	
	private static final String SQL_DELETE = "DELETE FROM video WHERE id = ? ;";
	private static final String SQL_INSERT = "INSERT INTO `javaee`.`video` (`nombre`, `codigo`, `id_usuario`) VALUES (?, ?, ?);";
	private static final String SQL_UPDATE = "UPDATE video SET nombre = ?, codigo = ?, id_usuario = ? WHERE id= ? ;";
	private static final String SQL_GETALL = "SELECT v.id as 'id_video', u.id as 'id_usuario', nombre, codigo, email, `password` FROM video as v INNER JOIN usuario as u ON u.id=v.id_usuario ORDER BY v.id DESC LIMIT 1000";
	private static final String SQL_SEARCHBYNAME = "SELECT id, nombre, codigo FROM video WHERE nombre LIKE ? ORDER BY id DESC LIMIT 500";
	private static final String SQL_GETBYID = "SELECT v.id as 'id_video', u.id as 'id_usuario', nombre, codigo, email, `password` FROM video as v INNER JOIN usuario as u ON v.id_usuario = u.id  WHERE v.id=? ;";

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
		String sql = SQL_GETALL;
		try(Connection conn = ConnectionManager.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery()
		) {
			
			while(rs.next()) {
				try {
				videos.add(rowMapper(rs));
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
		String sql = SQL_SEARCHBYNAME;
		try(Connection conn = ConnectionManager.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
		) {
			
			pst.setString(1, "%" + nombre + "%");
			
			try(ResultSet rs = pst.executeQuery()
			){
				while(rs.next()) {
					try {
					videos.add(rowMapper(rs));
					}catch (Exception e) {
						System.out.println("Video no válido");
						e.printStackTrace();
					}
				}
				
			}catch (Exception e) {
				LOG.error("Fallo en la consulta 'Buscar video'");
			}
		}catch (Exception e) {
			LOG.error("Fallo creando la conexión para la consulta 'Buscar video'");
			e.printStackTrace();
		}
		
		return videos;
	}

	public Video getById(Long identificador) {
		Video video = null;
		
		String sql = SQL_GETBYID;
		try( Connection conn = ConnectionManager.getConnection();
			 PreparedStatement pst = conn.prepareStatement(sql);
			){
			pst.setLong(1, identificador);
			try ( ResultSet rs = pst.executeQuery() ){											
				while(rs.next()) { // hemos encontrado usuario								
					video = rowMapper(rs);								
				}						
			}
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		
		return video;
	}

	private Video rowMapper(ResultSet rs) throws SQLException {
		Video video = new Video();
		video.setId( rs.getLong("id_video"));
		video.setNombre( rs.getString("nombre"));
		video.setCodigo(rs.getString("codigo"));
		
		Usuario u = new Usuario();
		u.setId(rs.getLong("id_usuario"));
		u.setEmail(rs.getString("email"));
		u.setPassword(rs.getString("password"));
		
		video.setUsuario(u);
		
		return video;
	}

	public boolean update(Video v) throws SQLException {
		boolean result = false;
		String sql = SQL_UPDATE;
		try( Connection conn = ConnectionManager.getConnection();
			 PreparedStatement pst = conn.prepareStatement(sql);
			){
			pst.setString(1, v.getNombre());
			pst.setString(2, v.getCodigo());
			pst.setLong(3, v.getUsuario().getId());
			pst.setLong(4, v.getId());
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				result = true;
			}
		}
		return result;
		
	}

	public boolean insert(Video v) throws SQLException {
		boolean result = false;
		String sql = SQL_INSERT;
		try( Connection conn = ConnectionManager.getConnection();
			 PreparedStatement pst = conn.prepareStatement(sql);
			){
			pst.setString(1, v.getNombre());
			pst.setString(2, v.getCodigo());
			pst.setLong(3, v.getUsuario().getId());
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

}
