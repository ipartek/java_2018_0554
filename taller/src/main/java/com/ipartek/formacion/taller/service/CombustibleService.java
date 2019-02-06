package com.ipartek.formacion.taller.service;

import java.util.List;

import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.service.exception.CombustibleException;

public interface CombustibleService {

	/**
	 * Listado Combustible ordenado por id descendente 
	 * @return List<Combustible>, Lista vacia si no hay datos
	 */
	List<Combustible> listar();

	/**
	 * Obtener detalle combustible
	 * @param idCombustible int identificador combustible
	 * @return Combustible si encuentra, si no <b>null</b>
	 */
	Combustible detalleId(int idCombustible);

	/**
	 * Elimina combustible por su identificador
	 * @param idCombustible int identificador combustible
	 * @return true si elimina, false si no lo encuentra
	 * @throws CombustibleException No se puede eliminar si existe un vehiculo con este combustible asociado 
	 * @see CombustibleException.EXCEPTION_CONSTRAINT
	 */
	boolean eliminar(int idCombustible) throws CombustibleException;
	
	/**
	 *  Crea un nuevo Combustible, al crear con exito actualza el <b>id</b>
	 * @param combustible Combustible a crear
	 * @return true si lo crea, false si no puede crear, <b>nombre</b> mínimo una letra y maximo 45
	 * @throws CombustibleException si el nombre del combustible existe o  errrores de Validacion
	 * 
	 */
	boolean crear(Combustible combustible) throws CombustibleException ;
	
	/**
	 * Modifica el <b>nombre</b> de un combustible, identificado por su <b>id</b>
	 * @param combustible combustible a modificar
	 * @return True si lo modifica, false si no lo encuentra o <b>nombre</b> minimo de una 1 letra y maximo 45
	 * @throws CombustibleException   o  errrores de Validacion
	 */
	boolean modificar(Combustible combustible) throws CombustibleException;

}
