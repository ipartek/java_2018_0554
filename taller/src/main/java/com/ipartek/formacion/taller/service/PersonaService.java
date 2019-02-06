package com.ipartek.formacion.taller.service;

import java.util.ArrayList;

import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;

public interface PersonaService {

	/**
	 * Listado Personas
	 * 
	 * @return ArrayList<Persona>
	 */
	ArrayList<Persona> listar();

	/**
	 * Listado vehiculos de una persona
	 * 
	 * @param idPersona identificador de la persona
	 * @return ArrayList<Vehiculo>
	 */
	ArrayList<Vehiculo> vehiculos(int idPersona);

}
