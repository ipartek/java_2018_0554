package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.pojos.Perro;

public class PerroDAO {

	private static PerroDAO INSTANCE = null;

	// constructor privado, solo acceso por getInstance()
	private PerroDAO() {
		super();
	}

	public synchronized static PerroDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new PerroDAO();
		}
		return INSTANCE;
	}

	public Perro getById(long id) {

		Perro registro = null;
		String sql = "SELECT id, raza, img FROM amaia_perros WHERE id= ?;";
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setLong(1, id);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					registro = new Perro();
					registro.setId(rs.getLong("id"));
					registro.setRaza(rs.getString("raza"));
					registro.setImg(rs.getString("img"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return registro;
	}

	public ArrayList<Perro> getAll() {

		ArrayList<Perro> listado = new ArrayList<Perro>();
		String sql = "SELECT id, raza, img FROM amaia_perros ORDER BY id ASC LIMIT 500;";

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {
			Perro p = null;
			while (rs.next()) {
				try {
					p = new Perro();
					p.setId(rs.getLong("id"));
					p.setRaza(rs.getString("raza"));
					p.setImg(rs.getString("img"));
					listado.add(p);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listado;
	}

	public ArrayList<Perro> getAllByRaza(String raza) {

		ArrayList<Perro> listado = new ArrayList<Perro>();
		String sql = "SELECT id, raza, img FROM amaia_perros WHERE RAZA LIKE ? ORDER BY id ASC LIMIT 500;";

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);

		) {

			pst.setString(1, "%" + raza + "%");

			try (ResultSet rs = pst.executeQuery()) {

				Perro p = null;
				while (rs.next()) {
					try {
						p = new Perro();
						p.setId(rs.getLong("id"));
						p.setRaza(rs.getString("raza"));
						p.setImg(rs.getString("img"));
						listado.add(p);
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