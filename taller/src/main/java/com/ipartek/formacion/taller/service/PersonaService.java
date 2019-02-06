package com.ipartek.formacion.taller.service;

import java.util.ArrayList;

import com.ipartek.formacion.taller.modelo.pojo.Persona;

public interface PersonaService {

	/**
	 * Listado Personas
	 * 
	 * @return ArrayList<Persona>
	 */
	ArrayList<Persona> listar();

	/**
	 * Lsitado Vehiculos de una Persona
	 * 
	 * @param idPersona identificador de la Persona
	 * @return ArrayList<Vehiculo>
	 */
	ArrayList<Object> vehiculos(int idPersona);

}
