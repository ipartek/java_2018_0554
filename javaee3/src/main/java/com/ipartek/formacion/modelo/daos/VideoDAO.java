package com.ipartek.formacion.modelo.daos;

import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.ipartek.formacion.modelo.daos.ConnectionManager;

import com.ipartek.formacion.modelo.pojos.Videos;

public class VideoDAO {

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

	public Videos getById(long id) {

		Videos registro = null;
		String sql = "SELECT id, nombre, url FROM oscar WHERE id= ?;";
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setLong(1, id);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					registro = new Videos();
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

	public ArrayList<Videos> getAll() {

		ArrayList<Videos> listado = new ArrayList<Videos>();
		String sql = "SELECT id, nombre, url FROM oscar ORDER BY id DESC LIMIT 500;";

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {
			Videos v = null;
			while (rs.next()) {
				try {
					v = new Videos();
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

	public ArrayList<Videos> getAllByNombre(String nombre) {

		ArrayList<Videos> listado = new ArrayList<Videos>();
		String sql = "SELECT id, nombre, url FROM oscar WHERE NOMBRE LIKE ? ORDER BY id DESC LIMIT 500;";

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);

		) {

			pst.setString(1, "%" + nombre + "%");

			try (ResultSet rs = pst.executeQuery()) {

				Videos v = null;
				while (rs.next()) {
					try {
						v = new Videos();
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

}