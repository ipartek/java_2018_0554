package com.ipartek.formacion.taller.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.ipartek.appMultas.modelo.dao.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.modelo.pojo.Rol;

@Repository
public class PersonaDAO {

	private static final String SQL_GET_ALL = "SELECT p.id AS 'ID_Persona', p.nombre AS 'Nombre_Persona', r.id AS 'ID_Rol', r.nombre AS 'Nombre_Rol' FROM persona AS p, persona_has_rol AS pr, rol AS r WHERE p.id = pr.id_persona AND pr.id_rol = r.id ORDER BY p.id DESC LIMIT 1000";

	public HashMap<Integer, Persona> getAll() {
		HashMap<Integer, Persona> hmPersonas = new HashMap<Integer, Persona>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {
				int idPersona = rs.getInt("ID_Persona");
				Persona persona = hmPersonas.get(idPersona);

				if (persona == null) {// Si no encuentro, crear

					persona = new Persona();
					persona.setId(idPersona);
					persona.setNombre(rs.getString("Nombre_Persona"));

				}

				Rol rol = new Rol();
				rol.setId(rs.getInt("ID_Rol"));
				rol.setNombre(rs.getString("Nombre_Rol"));

				ArrayList<Rol> roles = persona.getRoles();
				roles.add(rol);
				persona.setRoles(roles);

				// Guardar en HashMap
				hmPersonas.put(idPersona, persona);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return hmPersonas;
	}

}
