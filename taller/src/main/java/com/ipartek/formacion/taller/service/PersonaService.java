package com.ipartek.formacion.taller.service;

import java.util.ArrayList;

import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;

public interface PersonaService {

	/**
	 * Listado de personas
	 * 
	 * @return ArrayList<Persona>
	 */
	ArrayList<Persona> listar();

	/**
	 * Listado de vehículos de una persona
	 * 
	 * @param idPersona Identificador de la persona.
	 * @return ArrayList<Vehiculo>
	 */
	ArrayList<Vehiculo> vehiculos(int idPersona);

}
