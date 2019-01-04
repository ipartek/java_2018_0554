package com.ipartek.formacion.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Usuario;
import com.ipartek.formacion.modelo.pojo.Video;

public class VideoDAO {

	private static VideoDAO INSTANCE = null;
	private static final String SQL_GET_BY_ID="SELECT v.id as id_video, nombre, codigo FROM video AS v, usuario AS u WHERE v.id_usuario = u.id AND v.id= ?;";
	private static final String SQL_GET_ALL="SELECT v.id as id_video, nombre, codigo FROM video AS v, usuario AS u WHERE v.id_usuario = u.id ORDER BY id DESC LIMIT 500;";
	private static final String SQL_UPDATE="SELECT v.id as id_video, nombre, codigo FROM video AS v, usuario AS u WHERE v.id_usuario = u.id ORDER BY id DESC LIMIT 500;";
	private static final String SQL_INSERT="SELECT v.id as id_video, nombre, codigo FROM video AS v, usuario AS u WHERE v.id_usuario = u.id ORDER BY id DESC LIMIT 500;";
	private static final String SQL_DELETE="DELETE FROM video WHERE id = ? ;";

	private VideoDAO() {
		super();
	}

	public synchronized static VideoDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new VideoDAO();
		}
		return INSTANCE;
	}

	public Video getById(long id) throws SQLException {

		Video registro = null;
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(SQL_GET_BY_ID);) {

			pst.setLong(1, id);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					registro = new Video();
					registro.setId(rs.getLong("id"));
					registro.setNombre(rs.getString("nombre"));
					registro.setCodigo(rs.getString("codigo"));
				}
			}

		}

		return registro;
	}

	public ArrayList<Video> getAll() throws SQLException {

		ArrayList<Video> listado = new ArrayList<Video>();

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery()) {
			Video v = null;
			while (rs.next()) {
				try {
					listado.add(rowMapper(rs));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		return listado;
	}

	public ArrayList<Video> getByNombre(String nombre) throws SQLException {

		ArrayList<Video> listado = new ArrayList<Video>();
		String sql = "SELECT id, nombre, codigo FROM video WHERE nombre LIKE ? ORDER BY id DESC LIMIT 500;";

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);

		) {

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
				}
			}

		}
		return listado;
	}

	public boolean delete(long ident) throws SQLException {

		boolean resul = false;
		Video video = null;

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(SQL_DELETE);) {
			pst.setLong(1, ident);

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		} 
		return resul;
	}

	public boolean insert(Video v) throws SQLException {
		boolean resul = false;
		String sql = "INSERT INTO video (nombre, codigo) VALUES (?,?);";
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
		String sql = "UPDATE video SET nombre=?, codigo=? WHERE id=?;";
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
	
	
	private Video rowMapper(ResultSet rs) throws SQLException {
		Video v = new Video();
		v.setId( rs.getLong("id_video"));
		v.setCodigo( rs.getString("codigo"));
		v.setNombre(rs.getString("nombre"));
		
		Usuario u = new Usuario();
		u.setId(rs.getLong("id_usuario"));
		u.setEmail(rs.getString("email"));
		u.setPassword(rs.getString("password"));
		
		v.setUsuario(u);
		
		return v;
	}

}
