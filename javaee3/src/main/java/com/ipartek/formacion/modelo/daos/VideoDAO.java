package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.pojos.Usuario;
import com.ipartek.formacion.modelo.pojos.Video;

public class VideoDAO {
	private static VideoDAO INSTANCE = null;
	// Constructor privado, solo acceso por getInstance()
	private VideoDAO(){
		super();
	}
	
	public synchronized static VideoDAO getInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new VideoDAO();
        }
        return INSTANCE;
    }

	public ArrayList<Video> getAll() {

		ArrayList<Video> listado = new ArrayList<Video>();
		String sql = "SELECT id, nombre, codigo FROM video ORDER BY id DESC LIMIT 100;";

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
			Video v = null;
			while (rs.next()) {
				try {
					v = new Video();
					v.setId(rs.getLong("id"));
					v.setNombre(rs.getString("nombre"));
					v.setCodigo(rs.getString("codigo"));
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
						v.setCodigo(rs.getString("url"));
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

		Video v = null;
		String sql = "SELECT id, nombre, codigo FROM video WHERE id= ?;";
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setLong(1, id);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					v = new Video();
					v.setId(rs.getLong("id"));
					v.setNombre(rs.getString("nombre"));
					v.setCodigo(rs.getString("codigo"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return v;
	}
	
	public boolean insert(Video v) throws SQLException {
		boolean r = false;
		String sql = "INSERT INTO `video` (`nombre`, `codigo`) VALUES (?, ?);";
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setString(1, v.getNombre());
			pst.setString(2, v.getCodigo());
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				r = true;
			}
		}
		return r;
	}
	
	public boolean update(Video v) throws SQLException {
		boolean r = false;
		String sql = "UPDATE video SET nombre = ?, codigo = ? WHERE id = ?;";
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setString(1, v.getNombre());
			pst.setString(2, v.getCodigo());
			pst.setLong(3, v.getId());
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				r = true;
			}
		}
		return r;
	}
	
	public boolean delete(long id) {
		boolean r = false;
		String sql = "DELETE FROM `video` WHERE (`id` = ?);";
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setLong(1, id);
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				r = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
}
