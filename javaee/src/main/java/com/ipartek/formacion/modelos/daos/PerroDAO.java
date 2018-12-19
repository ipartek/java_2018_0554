package com.ipartek.formacion.modelos.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.modelos.pojos.Perro;

public class PerroDAO {
	public ArrayList<Perro> getAll() {
		ArrayList<Perro> perros = new ArrayList<Perro>();
		String sql = "SELECT id,raza,imagen FROM perros_borja ORDER BY id LIMIT 500";
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			Perro perro;
			while (rs.next()) {
				try {
					perro = new Perro();
					perro.setId(rs.getInt("id"));
					perro.setRaza(rs.getString("raza"));
					perro.setImagen(rs.getString("imagen"));
					perros.add(perro);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return perros;
	}
	public Perro devolverdatosperro(int id) throws SQLException {
		Perro perro=new Perro();
		String sql = "SELECT id,raza,imagen,precio FROM perros_borja WHERE id='"+id+"' ORDER BY id LIMIT 500";
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				try {
					perro.setId(rs.getInt("id"));
					perro.setRaza(rs.getString("raza"));
					perro.setImagen(rs.getString("Imagen"));
					perro.setPrecio(rs.getDouble("precio"));
					break;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return perro;
	}
	
}
