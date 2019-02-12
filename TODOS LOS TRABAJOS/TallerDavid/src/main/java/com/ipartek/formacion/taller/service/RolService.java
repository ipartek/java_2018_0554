package com.ipartek.formacion.taller.service;

import java.util.List;

import com.ipartek.formacion.taller.modelo.pojo.Rol;
import com.ipartek.formacion.taller.service.exception.CombustibleException;
import com.ipartek.formacion.taller.service.exception.RolException;

public interface RolService {
	
	
	/**
	 * Listado Rol ordenado por id descente
	 * @return List<Rol>, Lista vacia si no hay datos
	 */
	List<Rol> listar();

	/**
	 * Obtener detalle Rol
	 * @param idRol int identificador del Rol
	 * @return si encuentra Rol, si no <b>null</b>
	 */
	Rol detalle(int idRol);
	
	/**
	 * Elimina Rol por su identificador
	 * @param idRol int identificador del Rol
	 * @return true si elima, false si no lo encuentra
	 * @throws RolException No se puede eliminar si existe una Persona con este rol asociado
	 * @see RolException.EXCEPTION_CONSTRAINT
	 */
	boolean eliminar(int idRol) throws RolException;
	
	/**
	 * Creamos un nuevo Rol, al crear con exito actualiza el <b>id</b>
	 * @param rol Rol a crear
	 * @return true si lo crea, false si no puede crear
	 * @throws RolException si el nombre del Rol existe o errores de validacion (<b>nombre</b> minimo 1 letra y maximo 45)
	 * @see RolException.EXCEPTION_EXIST
	 */
	boolean crear(Rol rol) throws RolException;
	
	/**
	 * Modifica el <b>nombre</b> de un Rol identificado por su <b>id</b>
	 * @param rol Rol a modificar
	 * @return true si no modifica, false si no lo encuentra o <b>nombre</b> minimo 1 letra y maximo 45
	 * @throws RolException el nombre ya existe
	 * @see RolException.EXCEPTION_EXIST
	 */
	
	boolean modificar(Rol rol) throws RolException;
}
