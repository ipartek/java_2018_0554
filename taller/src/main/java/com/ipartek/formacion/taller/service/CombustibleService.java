package com.ipartek.formacion.taller.service;

import java.sql.SQLException;
import java.util.List;

import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.service.exception.CombustibleException;

public interface CombustibleService {

	/**
	 * Obtener todos los combustibles disponibles ordenado por id descendente
	 * 
	 * @return List<Combustible> lista vacia si no hay datos
	 */
	List<Combustible> listarCombustible();

	/**
	 * Obtener detalle del combustible
	 * 
	 * @param idCombustible
	 * @return combustible si encuentra , si no null
	 */
	Combustible detalle(int idCombustible);

	/**
	 * Eliminar un combustible por su id
	 * 
	 * @param idCombustible identifacodr del combustible
	 * @return true si elimina , false si no lo encuentra
	 * @throws CombustibleException No se puede eliminar si existe un vehiculo con
	 *                              este combustible asociado
	 * @see CombustibleException.EXCEPTION_CONSTRAINT
	 */
	Boolean eliminar(int idCombustible) throws CombustibleException;

	/**
	 * Crear un combustible
	 * 
	 * @param combustible Combustible a crear
	 * @return true si crea , false si no puede crear, minimo 1 maximo 45
	 * @throws CombustibleException si el nombre del combustible ya existe
	 * @throws SQLException 
	 * @see CombustibleException.EXCEPTION_EXIST
	 */
	Boolean crear(Combustible combustible) throws CombustibleException;

	/**
	 * Modifica el nombre de un combustible identificado por su id
	 * 
	 * @param combustible Combustible a modificar
	 * @return true si modifica, false si no puede modificar, minimo 1 maximo 45
	 *         caracteres
	 * @throws CombustibleException si el nombre del combustible ya existe
	 * @see CombustibleException.EXCEPTION_EXIST
	 */
	Boolean modificar(Combustible combustible) throws CombustibleException;

}
