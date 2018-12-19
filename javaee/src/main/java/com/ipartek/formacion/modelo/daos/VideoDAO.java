package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojos.Video;

public class VideoDAO {

	public ArrayList<Video> getAll() {

		ArrayList<Video> listado = new ArrayList<Video>();
		String sql = "SELECT id, nombre, url FROM hector_videos ORDER BY id DESC LIMIT 100;";

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {
			Video v = null;
			while (rs.next()) {
				try {
					v = new Video();
					v.setId(rs.getLong("id"));
					v.setNombre(rs.getString("nombre"));
					v.setUrl(rs.getString("url"));
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
		String sql = "SELECT id, nombre, url FROM hector_videos WHERE NOMBRE LIKE ? ORDER BY id DESC LIMIT 100;";

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setString(1, "%" + nombre + "%");

			try (ResultSet rs = pst.executeQuery()) {

				Video v = null;
				while (rs.next()) {
					try {
						v = new Video();
						v.setId(rs.getLong("id"));
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

	public Video getById(long id) {

		Video registro = null;
		String sql = "SELECT id, nombre, url FROM hector_videos WHERE id= ?;";
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setLong(1, id);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					registro = new Video();
					registro.setId(rs.getLong("id"));
					registro.setNombre(rs.getString("nombre"));
					registro.setUrl(rs.getString("url"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return registro;
	}
}
