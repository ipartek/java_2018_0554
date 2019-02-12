package com.ipartek.formacion.taller.service;

import java.util.List;

import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.service.exception.CombustibleException;

public interface CombustibleService {

	/**
	 * Listado Combustible ordenado por id descente
	 * @return List<Combustible>, Lista vacia si no hay datos
	 */
	List<Combustible> listar();

	/**
	 * Obtener detalle Combustible
	 * @param idCombustible int identificador del Combustible
	 * @return si encuentra Combustible, si no <b>null</b>
	 */
	Combustible detalle(int idCombustible);
	
	/**
	 * Elimina Combustible por su identificador
	 * @param idCombustible int identificador del Combustible
	 * @return true si elima, false si no lo encuentra
	 * @throws CombustibleException No se puede eliminar si existe un Vehiculo con este combustible asociado 
	 * @see CombustibleException.EXCEPTION_CONSTRAINT
	 */
	boolean eliminar(int idCombustible) throws CombustibleException;
	
	/**
	 * Creamos un nuevo Combustible, al crear con exito actualiza el <b>id</b>
	 * @param combustible Combustible a crear
	 * @return true si lo crea, false si no puede crear
	 * @throws CombustibleException si el nombre del combustible existe o errores de Validacion
	 * 
	 */
	boolean crear(Combustible combustible) throws CombustibleException;
	
	/**
	 * Modifica el <b>nombre</b> de un Combustible identificado por su <b>id</b>
	 * @param combustible Combustible a modificar
	 * @return true si no modifica, false si no lo encuentra 
	 * @throws CombustibleException el nombre ya existe o errores validacion
	 * 
	 */
	boolean modificar(Combustible combustible) throws CombustibleException;

}
