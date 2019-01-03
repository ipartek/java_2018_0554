package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.pojos.Video;

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

	/**
	 * comprobar si existe el usuario en la bbdd
	 * 
	 * @param email String
	 * @param pass  String contrase�a
	 * @return usuario con datos si existe, null si no existe
	 */
	public Video login(String nombre, String codigo) {

		Video video = null;
		String sql = "SELECT id, nombre, codigo FROM videos WHERE id = ?;";

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setString(1, nombre);
			pst.setString(2, codigo);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) { // hemos encontrado usuario
					video = new Video();
					video.setId(rs.getLong("id"));
					video.setNombre(rs.getString("nombre"));
					video.setCodigo(rs.getString("codigo"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return video;
	}

	public Video getById(long id) {

		Video video = null;
		String sql = "SELECT id, nombre, codigo FROM videos WHERE id = ?;";

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setLong(1, id);
			
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) { // hemos encontrado usuario
					video = new Video();
					video.setId(rs.getLong("id"));
					video.setNombre(rs.getString("nombre"));
					video.setCodigo(rs.getString("codigo"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return video;
	}

	public ArrayList<Video> getAll() {

		ArrayList<Video> videos = new ArrayList<Video>();
		String sql = "SELECT id, nombre, codigo FROM videos ORDER BY id DESC LIMIT 500";

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				try {
					Video video = new Video();
					video.setId(rs.getLong("id"));
					video.setNombre(rs.getString("nombre"));
					video.setCodigo(rs.getString("codigo"));
					// a�adir en array
					videos.add(video);
				} catch (Exception e) {
					System.out.println("video no valido");
					e.printStackTrace();
				}
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}
		return videos;
	}

	public boolean insert(Video v) throws SQLException {

		boolean resul = false;
		String sql = "INSERT INTO `videos` (`nombre`, `codigo`) VALUES (?,?);";
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setString(1, v.getNombre());
			pst.setString(2, v.getCodigo());
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		}
		return resul;

	}
	
	public boolean update(Video v) throws SQLException {

		boolean resul = false;
		String sql = "UPDATE `videos` SET nombre = ? , codigo = ? WHERE id = ?;";
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			
			pst.setString(1, v.getNombre());
			pst.setString(2, v.getCodigo());
			pst.setLong(3, v.getId());
			
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		}
		return resul;

	}
	
	
	public boolean delete( long id ) throws SQLException {

		boolean resul = false;
		String sql = "DELETE FROM `videos` WHERE id = ?;";
		try (Connection conn = ConnectionManager.getConnection(); 
			 PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setLong(1, id);
			
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		}
		return resul;

	}

}