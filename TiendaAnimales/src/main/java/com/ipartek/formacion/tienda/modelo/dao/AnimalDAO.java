package com.ipartek.formacion.tienda.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.tienda.modelo.config.ConnectionManager;
import com.ipartek.formacion.tienda.modelo.pojo.Animal;
import com.mysql.jdbc.Connection;

@Repository
public class AnimalDAO {

	private static final String SQL_GET_ALL = "SELECT a.id as 'id', a.nombre as 'nombre', a.id_tipo, t.nombre as 'tipo', a.id_dieta, d.nombre as 'dieta', "
			+ "a.peso as 'peso', a.precio as 'precio' FROM animal as a INNER JOIN tipo as t ON a.id_tipo = t.id INNER JOIN dieta "
			+ "as d ON a.id_dieta = d.id ORDER BY a.id DESC LIMIT 500;";

	/**
	 * Método para obtener todos los tipos de animales existentes en la BD
	 * 
	 * @return ArrayList<Animal> con todos los animales disponibles
	 */
	public ArrayList<Animal> getAll() {
		ArrayList<Animal> animales = new ArrayList<Animal>();

		try (Connection con = (Connection) ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				animales.add(RowMapper(rs));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return animales;
	}

	/**
	 * Método para rellenar un objeto <b>Animal</b> con datos de la BD
	 * 
	 * @param rs ResultSet
	 * @return Objeto <b>Animal</b> con datos de la BD
	 * @throws SQLException
	 */
	private Animal RowMapper(ResultSet rs) throws SQLException {
		Animal a = new Animal();
		a.setId(rs.getInt("id"));
		a.setNombre(rs.getString("nombre"));
		a.setTipo(rs.getString("tipo"));
		a.setDieta(rs.getString("dieta"));
		a.setPeso(rs.getFloat("peso"));
		a.setPrecio(rs.getFloat("precio"));
		return a;
	}

}
