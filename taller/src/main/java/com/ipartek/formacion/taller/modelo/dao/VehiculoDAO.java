package com.ipartek.formacion.taller.modelo.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;

@Repository
public class VehiculoDAO {
	
	private static final String SQL_GET_ALL_BY_PERSONA_ID="SELECT v.numero_bastidor as 'numero_bastidor', v.matricula as 'matricula', c.nombre as 'combustible', m.nombre as 'modelo' from vehiculo as v INNER JOIN combustible as c ON v.id_combustible = c.id INNER JOIN modelo as m ON v.id_modelo = m.id WHERE v.id_propietario=? ORDER BY v.id DESC LIMIT 1000;";

	public ArrayList<Vehiculo> getAllByPersonaId(int idPersona){
		
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		Vehiculo v = new Vehiculo();
		v.setMatricula("1234AAA");
		vehiculos.add(v);
		
		Vehiculo v2 = new Vehiculo();
		v2.setMatricula("5678BBB");
		vehiculos.add(v2);
		
		return vehiculos;
	}
	
}
