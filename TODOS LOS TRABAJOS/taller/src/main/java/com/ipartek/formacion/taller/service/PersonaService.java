package com.ipartek.formacion.taller.service;

import java.util.ArrayList;

import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.service.exception.PersonaException;

public interface PersonaService {
	
	/**
	 * listado persona ordenado por id descendente
	 * @return ArrayList<Persona>, vacio si no hay datos
	 */
	ArrayList<Persona> listar();
	
	/**
	 * obtener detalle persona
	 * @param idpersona identificador de persona
	 * @return persona si encuentra, sino <b>null</b>
	 */
	
	Persona detalle(int idPersona);
	/**
	 * elimina registro de conbustibles por identificador
	 * @param idpersona identificador persona
	 * @return true si elimina, false si no lo encuentra
	 * @throws personaException  si tiene roles asociados o no existe identificador
	 * @see personaException
	 */
	boolean eliminar (int idPersona) throws PersonaException;
	/**
	 * crear registro de persona
	 * @param persona datos de persona
	 * @return true si lo crea, false si no lo hace (no vacio, min 1 max 45)
	 * @throws personaException si ya existe
	 */
	
	boolean crear (Persona persona) throws PersonaException;
	/**
	 * modifica datos de persona
	 * @param idpersona identificador de persona
	 * @return true si se hizo la modificacion, false si no se hizo (no vacio, min 1 max 45)
	 * @throws personaException si no existe
	 */
	
	boolean modificar (Persona perosna) throws PersonaException;
	

	
	

}
