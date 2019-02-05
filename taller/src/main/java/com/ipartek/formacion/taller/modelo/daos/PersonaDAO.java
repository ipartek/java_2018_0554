package com.ipartek.formacion.taller.modelo.daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.modelo.cm.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.modelo.pojo.Rol;

@Repository
public class PersonaDAO {

	private static final String SQL_GET_ALL = "SELECT p.id as 'id_persona', p.nombre as 'nombre_persona', r.id as 'id_rol', r.nombre as 'nombre_rol' FROM persona as p, persona_has_rol as pr, rol as r WHERE p.id = pr.id_persona AND pr.id_rol = r.id ORDER BY p.id DESC LIMIT 1000;";

	public HashMap<Integer, Persona> getAll() {

		HashMap<Integer, Persona> hmPersonas = new HashMap<Integer, Persona>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {
				
				int idPersona = rs.getInt("id_persona");
				Persona persona = hmPersonas.get(idPersona);
				
				if ( persona == null ) {         // si no encentro crear
					
					persona = new Persona();
					persona.setId(idPersona);
					persona.setNombre( rs.getString("nombre_persona"));
										
				}
				
				Rol rol = new Rol();
				rol.setId(rs.getInt("id_rol"));
				rol.setNombre(rs.getString("nombre_rol"));
				
				ArrayList<Rol> roles = persona.getRoles();
				roles.add(rol);
				persona.setRoles(roles);
								
				//guardar en hasMap
				hmPersonas.put(idPersona, persona);
				
			}// end while

		} catch (Exception e) {
			e.printStackTrace();
		}

		return hmPersonas;
	}

}