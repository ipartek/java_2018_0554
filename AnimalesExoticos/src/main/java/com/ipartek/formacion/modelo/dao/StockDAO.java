package com.ipartek.formacion.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.modelo.config.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Animal;
import com.ipartek.formacion.modelo.pojo.Dieta;
import com.ipartek.formacion.modelo.pojo.Especie;

@Repository
public class StockDAO {

	private static final String SQL_GET_ALL = "SELECT e.id 'id_especie', e.nombre 'especie', a.id 'id_animal', a.nombre 'animal', d.id 'id_dieta', d.nombre 'dieta', precio "
			+ " FROM animal a, especie e, dieta d "
			+ " WHERE a.id_especie = e.id AND a.id_dieta = d.id ORDER BY especie ASC;";

	public ArrayList<Animal> getAll() {

		ArrayList<Animal> lista = new ArrayList<Animal>();
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				lista.add(rowMapper(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	private Animal rowMapper(ResultSet rs) throws SQLException {

		Especie e = new Especie();
		e.setId(rs.getInt("id_especie"));
		e.setNombre(rs.getString("especie"));

		Dieta d = new Dieta();
		d.setId(rs.getInt("id_dieta"));
		d.setNombre(rs.getString("dieta"));

		Animal a = new Animal();
		a.setId(rs.getInt("id_animal"));
		a.setNombre(rs.getString("animal"));
		a.setPrecio(rs.getFloat("precio"));
		a.setEspecie(e);
		a.setDieta(d);

		return a;
	}
}