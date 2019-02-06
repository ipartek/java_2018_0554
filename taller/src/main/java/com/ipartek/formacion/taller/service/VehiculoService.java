package com.ipartek.formacion.taller.service;

import java.util.List;

import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;
import com.ipartek.formacion.taller.service.exception.VehiculoException;

public interface VehiculoService {
	
	// LISTAR - GET BY ALL
	/**
	 * Listado Vehiculo ordenado por id descente
	 * @return List<Vehiculo>, Lista vacia si no hay datos
	 */ 
	List<Vehiculo> listar();   // NO INCLUYE PARAMETRO

	
	// DETALLE - GET BY ID
	/**
	 * Obtener detalle Vehiculo
	 * @param idVehiculo int identificador del Vehiculo
	 * @return si encuentra Vehiculo, si no <b>null</b>
	 */
	Vehiculo detalle(int idVehiculo);  // PARAMETRO ID
	
	
	// ELIMINAR - DELETE
	/**
	 * Elimina Vehiculo por su identificador
	 * @param idVehiculo int identificador del Vehiculo
	 * @return true si elima, false si no lo encuentra
	 * @throws VehiculoException No se puede eliminar si existe un Vehiculo con este Vehiculo asociado 
	 * @see VehiculoException.EXCEPTION_CONSTRAINT
	 */
	boolean eliminar(int idVehiculo) throws VehiculoException;   // PARAMETRO ID
	
	
	// CREAR - INSERT
	/**
	 * Creamos un nuevo Vehiculo, al crear con exito actualiza el <b>id</b>
	 * @param Vehiculo Vehiculo a crear
	 * @return true si lo crea, false si no puede crear, <b>nombre</b> minimo 1 letra y maximo 45
	 * @throws VehiculoException si el nombre del Vehiculo existe
	 * @see VehiculoException.EXCEPTION_EXIST
	 */
	boolean crear(Vehiculo vehiculo) throws VehiculoException; // PARAMETRO OBJETO 
	 
	
	// MODIFICAR - UPDATE
	/**
	 * Modifica el <b>nombre</b> de un Vehiculo identificado por su <b>id</b>
	 * @param Vehiculo Vehiculo a modificar
	 * @return true si no modifica, false si no lo encuentra o <b>nombre</b> minimo 1 letra y maximo 45
	 * @throws VehiculoException el nombre ya existe
	 * @see VehiculoException.EXCEPTION_EXIST
	 */
	boolean modificar(Vehiculo vehiculo) throws VehiculoException; // PARAMETRO OBJETO

}