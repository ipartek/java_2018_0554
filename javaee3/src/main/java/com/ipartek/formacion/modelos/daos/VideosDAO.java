package com.ipartek.formacion.modelos.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojo.Video;

public class VideosDAO {

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

		String sql = "Select id, nombre, url from daniel order by id desc limit 100";
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()
			){
			Video video = null;
			while (rs.next()) {
				try {
					video = new Video();
					video.setId(rs.getLong("id"));
					video.setNombre(rs.getString("nombre"));
					video.setUrl(rs.getString("url"));
					// a�adimos el video al array devideos
					videos.add(video);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return videos;
	}

	public ArrayList<Video> getByNombre(String nombreVideo) {
		ArrayList<Video> videos = new ArrayList<>();
		Video video = new Video();

		String sql = "Select id,nombre, url from daniel where nombre like ? order by id desc limit 100";

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setString(1, "%" + nombreVideo + "%");
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) { // hemos encontrado ususario
					video = new Video();
					video.setId(rs.getLong("id"));
					video.setNombre(rs.getString("nombre"));
					video.setUrl(rs.getString("url"));
					videos.add(video);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return videos;
	}
}
