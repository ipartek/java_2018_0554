package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojos.Video;

public class VideosDAO {
	public ArrayList<Video> getAll() {
		ArrayList<Video> videos = new ArrayList<>();

		String sql = "Select id, nombre, url from hector_videos order by id desc limit 100";
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				try {
					Video v = new Video();
					v.setId(rs.getInt("id"));
					v.setNombre(rs.getString("nombre"));
					v.setUrl(rs.getString("url"));
					// añadimos el video al array de videos
					videos.add(v);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return videos;
	}

	public ArrayList<Video> getAllByNombre(String nombre) {

		ArrayList<Video> listado = new ArrayList<Video>();
		String sql = "SELECT id, nombre, url FROM hector_videos WHERE NOMBRE LIKE ? ORDER BY id DESC LIMIT 100;";

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);

		) {

			pst.setString(1, "%" + nombre + "%");

			try (ResultSet rs = pst.executeQuery()) {

				Video v = null;
				while (rs.next()) {
					try {
						v = new Video();
						v.setId(rs.getInt("id"));
						v.setNombre(rs.getString("nombre"));
						v.setUrl(rs.getString("url"));
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

}
