package com.ipartek.formacion.taller.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.taller.modelo.config.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Modelo;
import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;

@Repository
public class VehiculoDAO {

	private static final String SQL_GET_ALL_BY_PERSONA_ID = "SELECT p.id as 'id_persona', p.nombre as 'nombre_persona',  m.nombre AS 'modelo' FROM persona as p, vehiculo AS v, modelo AS m WHERE p.id = v.id_propietario AND v.id_modelo = m.id AND p.id = ?;";

	public HashMap<Integer, Vehiculo> getAllByPersonaId(int idPersona) {

		Vehiculo v = null;

		try (Connection conn = ConnectionManager.getConnection();
			PreparedStatement pst = conn.prepareStatement(SQL_GET_ALL_BY_PERSONA_ID);) {
				pst.setLong(1, idPersona);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					v = rowMapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	private Vehiculo rowMapper(ResultSet rs) throws SQLException {

		Vehiculo v = new Vehiculo();

		Persona p = new Persona();
		p.setId(rs.getInt("id_persona"));
		p.setNombre(rs.getString("nombre_persona"));

		Modelo m = new Modelo();
		m.setNombre(rs.getString("modelo"));

		return v;
	}
}
