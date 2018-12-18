package com.ipartek.formacion.modelos.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.modelos.pojos.Usuario;
import com.ipartek.formacion.modelos.pojos.Video;

public class VideoDAO {

	public boolean creatabla() {
		boolean error = false;
		String sql = ("CREATE TABLE Borja (id int NOT NULL AUTO_INCREMENT,titulo varchar(255),url varchar(255), PRIMARY KEY (ID))");
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.execute();

		} catch (Exception e) {
			error = true;
			e.printStackTrace();
		}
		return error;
	}

	public ArrayList<Video> getAll() {
		ArrayList<Video> videos = new ArrayList<Video>();
		String sql = "select id,titulo, url from Borja";
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			Video video;
			while (rs.next()) {
				try {
					video = new Video();
					video.setId((long) rs.getInt("id"));
					video.setTitulo(rs.getString("titulo"));
					video.setUrl(rs.getString("url"));
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

	public ArrayList<Video> buscarvideo(String busqueda) {
		ArrayList<Video> videos = new ArrayList<Video>();
		String sql = "select id,titulo, url from Borja WHERE titulo LIKE '%" + busqueda + "%'";
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				try {
					Video video = new Video();
					video.setId((long) rs.getInt("id"));
					video.setTitulo(rs.getString("titulo"));
					video.setUrl(rs.getString("url"));
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

}
