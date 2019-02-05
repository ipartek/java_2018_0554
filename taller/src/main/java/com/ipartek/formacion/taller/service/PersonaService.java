package com.ipartek.formacion.taller.service;

import java.util.ArrayList;

import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;



public interface PersonaService {

	/**
	 * Listado Personas 
	 * @return ArrayList<Persona>
	 */
	ArrayList<Persona> listar();
	
	/**
	 * Listado Vehiculos de una Persona
	 * @param idPersona identificador de la Persona
	 * @return ArrayList<Vehiculo>
	 */
	ArrayList<Vehiculo> vehiculos( int idPersona );
	
	
	/**
	 * Detalle de un Vehiculo de una Persona
	 * @param idPersona int identificador Persona
	 * @param idVehiculo int identificador Vehiculo
	 * @return vehiculo si lo encuentra, null si no existe
	 */
	Vehiculo vehiculo( int idPersona, int idVehiculo );
	
}