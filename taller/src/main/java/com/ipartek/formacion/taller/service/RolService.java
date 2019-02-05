package com.ipartek.formacion.taller.service;




import java.util.List;

import com.ipartek.formacion.taller.modelo.pojo.Rol;
import com.ipartek.formacion.taller.service.exception.CombustibleException;
import com.ipartek.formacion.taller.service.exception.RolException;



public interface RolService {
	
	// LISTAR - GET BY ALL
	/**
	 * Listado Rol ordenado por id descente
	 * @return List<Rol>, Lista vacia si no hay datos
	 */ 
	List<Rol> listar();   // NO INCLUYE PARAMETRO

	
	// DETALLE - GET BY ID
	/**
	 * Obtener detalle Rol
	 * @param idRol int identificador del Rol
	 * @return si encuentra Rol, si no <b>null</b>
	 */
	Rol detalle(int idRol);  // PARAMETRO ID
	
	
	// ELIMINAR - DELETE
	/**
	 * Elimina Rol por su identificador
	 * @param idRol int identificador del Rol
	 * @return true si elima, false si no lo encuentra
	 * @throws RolException No se puede eliminar si existe un Vehiculo con este rol asociado 
	 * @see RolException.EXCEPTION_CONSTRAINT
	 */
	boolean eliminar(int idRol) throws RolException;   // PARAMETRO ID
	
	
	// CREAR - INSERT
	/**
	 * Creamos un nuevo Rol, al crear con exito actualiza el <b>id</b>
	 * @param combustible rol a crear
	 * @return true si lo crea, false si no puede crear, <b>nombre</b> minimo 1 letra y maximo 45
	 * @throws RolException si el nombre del rol existe
	 * @see RolException.EXCEPTION_EXIST
	 */
	boolean crear(Rol rol) throws RolException; // PARAMETRO OBJETO 
	 
	
	// MODIFICAR - UPDATE
	/**
	 * Modifica el <b>nombre</b> de un Rol identificado por su <b>id</b>
	 * @param rol Rol a modificar
	 * @return true si no modifica, false si no lo encuentra o <b>nombre</b> minimo 1 letra y maximo 45
	 * @throws RolException el nombre ya existe
	 * @see RolException.EXCEPTION_EXIST
	 */
	boolean modificar(Rol rol) throws RolException; // PARAMETRO OBJETO

}
	

