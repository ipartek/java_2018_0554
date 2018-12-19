package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojos.Perro;

public class PerroDAO {

	public ArrayList<Perro> getAll() {
		ArrayList<Perro> perros = new ArrayList<>();

		String sql = "Select id,raza,origen,img from danielperros order by id desc limit 500";

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				try {
					Perro perroInsertar = new Perro();
					perroInsertar.setId(rs.getLong("id"));
					perroInsertar.setRaza(rs.getString("raza"));
					perroInsertar.setOrigen(rs.getString("origen"));
					perroInsertar.setImg(rs.getString("img"));
					// añadir en array
					perros.add(perroInsertar);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return perros;
	}

	public Perro getById(Long id) {
		Perro registro = null;
		String sql = "Select id,raza,origen,img from danielperros where id=?";

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setLong(1, id);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					registro = new Perro();
					registro.setId(rs.getLong("id"));
					registro.setRaza(rs.getString("raza"));
					registro.setOrigen(rs.getString("origen"));
					registro.setImg(rs.getString("img"));

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return registro;
	}
}
