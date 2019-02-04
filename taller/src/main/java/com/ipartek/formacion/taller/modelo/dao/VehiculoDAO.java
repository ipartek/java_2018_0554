package com.ipartek.formacion.taller.modelo.dao;


import java.util.HashMap;

import org.springframework.stereotype.Repository;


import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;

@Repository
public class VehiculoDAO {
	
	private static final String SQL_GET_ALL_BY_PERSONA_ID = "SELECT p.id as 'id_persona', p.nombre as 'nombre_persona',  m.nombre AS 'modelo' FROM persona as p, vehiculo AS v, modelo AS m WHERE p.id = v.id_propietario AND v.id_modelo = m.id AND p.id = ?;";
	
	
	public HashMap<Integer, Vehiculo> getAllByPersonaId(int idPersona) {	
		
		
		return null;
	}
}
