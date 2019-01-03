package com.ipartek.formacion.modelos.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.VideosController;
import com.ipartek.formacion.modelo.pojo.Usuario;
import com.ipartek.formacion.modelo.pojo.Video;

public class VideosDAO {
	private static final String SQL_DELETE = "DELETE FROM video WHERE id=?";
	private static final String SQL_UPDATE = "UPDATE video SET nombre=?, codigo=? WHERE id=?;";
	private static final String SQL_INSERT = "INSERT INTO video (id,nombre,codigo) VALUES(?,?,?);";
	private static final String SQL_GETBYID = "SELECT id,nombre,codigo FROM video WHERE id=?;";
	private static final String SQL_GETBYNOMBRE = "Select id,nombre, codigo from video where nombre like ? order by id desc limit 100";
	private static final String SQL_GETALL = "Select id, nombre, codigo from video order by id desc limit 100";
	private final static Logger LOG = Logger.getLogger(VideosDAO.class);
	private static VideosDAO INSTANCE = null;
	
	private VideosDAO() {
		super();
	}
	
	/**
	 * Aqui obtenemos la instancia y sino esta creada la creamos
	 * @return devuelve la INSTANCIA
	 */
	public synchronized static VideosDAO getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new VideosDAO();
		}
		
		return INSTANCE;
	}

	
	/**
	 * Metodo que obtiene todos los videos de la tabla daniel
	 * 
	 * @return
	 */
	public ArrayList<Video> getAll() {
		ArrayList<Video> videos = new ArrayList<>();

		String sql = SQL_GETALL;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()
			){
			Video video = null;
			while (rs.next()) {
				try {
					video = rowMapper(rs);
					// añadimos el video al array devideos
					videos.add(video);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return videos;
	}


	
	public ArrayList<Video> getByNombre(String nombreVideo) {
		ArrayList<Video> videos = new ArrayList<>();
		Video video = new Video();

		String sql = SQL_GETBYNOMBRE;

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setString(1, "%" + nombreVideo + "%");
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) { // hemos encontrado ususario
					video = rowMapper(rs);
					videos.add(video);
				}
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return videos;
	}
	
	public Video getById(Long id) {
		Video v= null;
		String sql=SQL_GETBYID;
		
		try(
			Connection conn= ConnectionManager.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			){
			pst.setLong(1, id);
			try(ResultSet rs = pst.executeQuery();){
				while(rs.next()) {
					v = rowMapper(rs);
				}
			}
		}catch (Exception e) {
			LOG.debug(e);
		}
		return v;
	}
	
	public boolean insert(Video v) throws SQLException {
		boolean resul= false;
		
		String sql=SQL_INSERT;
		
		try(Connection conn= ConnectionManager.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			){
			pst.setLong(1, v.getId());
			pst.setString(2, v.getNombre());
			pst.setString(3, v.getCodigo());
			
			int affectedRows = pst.executeUpdate();
			if(affectedRows== 1){
				resul =true;
			}	
		}
		return resul;
	}
	
	public boolean update(Video v) throws SQLException {
		boolean resul= false;
		String sql =SQL_UPDATE;
		
		try(Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
			){
			pst.setString(1, v.getNombre());
			pst.setString(2, v.getCodigo());
			pst.setLong(3, v.getId());
			int affectedRows = pst.executeUpdate();
			if(affectedRows == 1) {
				resul = true;
			}	
		}
		return resul;
	}
	
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
	private Video rowMapper(ResultSet rs) throws SQLException {
		Video video = new Video();
		video.setId(rs.getLong("id"));
		video.setNombre(rs.getString("nombre"));
		video.setCodigo(rs.getString("codigo"));
		return video;
	}
}
