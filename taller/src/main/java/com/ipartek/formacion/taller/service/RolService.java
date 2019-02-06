package com.ipartek.formacion.taller.service;

import java.util.List;

import com.ipartek.formacion.taller.modelo.pojo.Rol;

import com.ipartek.formacion.taller.service.exception.RolException;

public interface RolService {

	/**
	 * Listado Rol ordenado por id ascendente
	 * 
	 * @return List<Rol>, Lista vacio si no hay datos
	 */
	List<Rol> listar();

	/**
	 * Lsitado oles de una Persona
	 * 
	 * @param idRol int identificador del rol
	 * @return si encuentra el rol, si no <b>null</b>
	 */
	Rol detalle(int id); // id o idRol pero como está funciona

	/**
	 * Elimina rol por su identificador
	 * 
	 * @param idRol int identificador del rol
	 * @return true si lo elimina, false si no lo encuentra
	 * @throws RolException - No se puede eliminar si existe una persona con
	 *                              ese rol
	 * @see RolException.EXCEPTION_CONSTRAINT
	 */

	boolean eliminar(int id) throws RolException; 
	/**
	 * 
	 * Creamos un nuevo rol
	 * 
	 * 
	 * @param rol Rol a crear, al crear con exito actualiza el
	 *                    <b>id</b>
	 * 
	 * @return true si lo crea, false si no lo puede crear, <b>nombre</b> minimo y
	 *         letra maximo 45
	 * @throws RolException - si ya existe o hay errores de validacion
	 * @see RolException.EXCEPTION_EXIST
	 */


	boolean modificar(Rol rol) throws RolException; // En caso de fallar, habilitar el de abajo


	/**
	 * Modifica el nombre de un rol identificado por su id
	 * 
	 * 
	 * @param id del rol a modificar
	 * @return true si lo ha modificado, false si no encuentra la id
	 * @throws RolException
	 * 
	 *                              <ol>
	 *                              <li>EXCEPTION_EXIST: el nombre del rol ya existe</li>
	 *                              <li>Validacion; <b>nombre</b> minimo 1 letra y
	 *                              maximo 45</li>
	 *                              </ol>
	 * 
	 * @see RolException.EXCEPTION_EXIST
	 */


	boolean crear(Rol rol) throws RolException;

}
