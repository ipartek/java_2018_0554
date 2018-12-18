package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojos.Usuario;
import com.ipartek.formacion.modelo.pojos.Video;

public class VideosDAO {

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
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				try {
					Video video = new Video();
					video.setId(rs.getLong("id"));
					video.setNombre(rs.getString("nombre"));
					video.setUrl(rs.getString("url"));
					// añadimos el video al array devideos
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

	public Video getByNombre(String nombreVideo) {
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
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return video;
	}
}
