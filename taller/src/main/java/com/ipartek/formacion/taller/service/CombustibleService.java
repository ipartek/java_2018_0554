package com.ipartek.formacion.taller.service;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.service.exception.CombustibleException;

public interface CombustibleService {

	/**
	 * Listado Combustible ordenado por id ascendente
	 * 
	 * @return List<Combustible>, Lista vacio si no hay datos
	 */
	List<Combustible> listar();

	/**
	 * Lsitado Vehiculos de una Persona
	 * 
	 * @param idCombustible int identificador del combustible
	 * @return si encuentra combustible, si no <b>null</b>
	 */
	Combustible detalle(int id);	//id o idCombustible pero como está funciona

	/**
	 * Elimina combustible por su identificador
	 * 
	 * @param idCombustible int identificador del combustible
	 * @return true si lo elimina, false si no lo encuentra
	 * @throws CombustibleException - No se puede eliminar si existe un vehiculo con
	 *                              ese combustible
	 * @see CombustibleException.EXCEPTION_CONSTRAINT
	 */

	boolean eliminar(int id) throws CombustibleException; //id o idCombustible pero como está funciona

	/**
	 * 
	 * Creamos un nuevo combustible
	 * 
	 * 
	 * @param combustible Combustible a crear, al crear con exito actualiza el  <b>id</b>
	 *                   
	 * @return true si lo crea, false si no lo puede crear, <b>nombre</b> minimo y
	 *         letra maximo 45
	 * @throws CombustibleException - si ya existe
	 * @see CombustibleException.EXCEPTION_EXIST
	 */

	boolean crear(int idCombustible) throws CombustibleException; //En caso de fallar, habilitar el de abajo
//	boolean crear(Combustible combustible) throws CombustibleException; 
	/**
	 *  Modifica el nombre de un combustible identificado por su id
	 * 
	 * 
	 * @param idCombustible a modificar
	 * @return true si lo ha modificado, false si no encuentra la id
	 * @throws CombustibleException
	 * 
	 * 	<ol>
	 * 		<li>EXCEPTION_EXIST: el nombre ya existe</li>
	 * 		<li>Validacion; <b>nombre</b> minimo 1 letra y maximo 45</li>
	 * </ol>
	 * 
	 * @see CombustibleException.EXCEPTION_EXIST
	 */


	boolean modificar(Combustible combustible) throws CombustibleException;

	
	
}
