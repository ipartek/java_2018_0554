package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;

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
					v.setInt(rs.getInt("id"));
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

	public Video getByNombre(String nombreVideo) {
		Video video = new Video();

		String sql = "Select id,nombre, url from hector_videos where nombre like ? order by id desc limit 100";

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setString(1, "%" + nombreVideo + "%");
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) { // hemos encontrado ususario
					video = new Video();
					video.setId(rs.getInt("id"));
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
