package com.ipartek.formacion.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Categoria;
import com.ipartek.formacion.modelo.pojo.Agente;
import com.ipartek.formacion.modelo.pojo.Video;

public class CategoriaDAO {

	private static CategoriaDAO INSTANCE = null;
	HttpSession session;

	private static final String SQL_GETBYID = "SELECT c.id as 'id_video', u.id as 'id_usuario', email, password, nombre, codigo FROM video as v, usuario as u WHERE v.id_usuario = u.id AND v.id = ?;";
	private static final String SQL_GETALL = "SELECT v.id as 'id_video', u.id as 'id_usuario', email, password, nombre, codigo FROM video as v, usuario as u WHERE v.id_usuario = u.id ORDER BY v.id DESC LIMIT 1000;";
	private static final String SQL_GETALL_USU = "SELECT v.id as 'id_video', u.id as 'id_usuario', email, password, nombre, codigo FROM video as v, usuario as u WHERE v.id_usuario = u.id AND v.id_usuario = ? ORDER BY v.id DESC LIMIT 1000;";
	private static final String SQL_INSERT = "INSERT INTO categoria  (texto) VALUES( ? );";
	private static final String SQL_UPDATE = "UPDATE video SET nombre = ? , codigo = ? , id_usuario = ?  WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM video WHERE id = ?;";

	// constructor privado, solo acceso por getInstance()
	private CategoriaDAO() {
		super();
	}

	public synchronized static CategoriaDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new CategoriaDAO();
		}
		return INSTANCE;
	}

	public Categoria getById(long id) {

		Categoria c = null;

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GETBYID);) {
			pst.setLong(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					c = rowMapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	public ArrayList<Categoria> getAll() {

		ArrayList<Categoria> videos = new ArrayList<Categoria>();

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GETALL);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				try {
					videos.add(rowMapper(rs));
				} catch (Exception e) {
					System.out.println("categoria no valida");
					e.printStackTrace();
				}
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}
		return videos;
	}

	public boolean insert(Categoria c) throws SQLException {

		boolean resul = false;

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_INSERT);) {

			pst.setString(1, c.getNombre());
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		}
		return resul;

	}

	public boolean update(Video v) throws SQLException {

		boolean resul = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_UPDATE);) {

			pst.setString(1, v.getNombre());
			pst.setString(2, v.getCodigo());
			pst.setLong(3, v.getUsuario().getId());
			pst.setLong(4, v.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;

	}

	public boolean delete(long id) throws SQLException {

		boolean resul = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_DELETE);) {

			pst.setLong(1, id);

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		}
		return resul;

	}

	private Categoria rowMapper(ResultSet rs) throws SQLException {
		Categoria c = new Categoria();
		c.setId(rs.getLong("id"));
		c.setNombre(rs.getString("nombre"));

		return c;
	}

}
