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
	 * Datos de una Persona
	 * 
	 * @param idPersona identificador de la Persona
	 * @return ArrayList<Persona> con una persona
	 */
	ArrayList<Persona> persona(int idPersona);

	/**
	 * Listado Vehiculos de una Persona
	 * 
	 * @param idPersona identificador de la Persona
	 * @return ArrayList<Vehiculo>
	 */
	ArrayList<Vehiculo> vehiculos(int idPersona);

}
