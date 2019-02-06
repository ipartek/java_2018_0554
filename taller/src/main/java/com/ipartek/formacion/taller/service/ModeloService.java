package com.ipartek.formacion.taller.service;

import java.sql.SQLException;
import java.util.List;

import com.ipartek.formacion.taller.modelo.pojo.Modelo;
import com.ipartek.formacion.taller.service.exception.CombustibleException;

public interface ModeloService {

	/**
	 * Obtener todos los combustibles disponibles ordenado por id descendente
	 * 
	 * @return List<Combustible> lista vacia si no hay datos
	 */
	List<Modelo> listarCombustible();

	/**
	 * Obtener detalle del combustible
	 * 
	 * @param idCombustible
	 * @return combustible si encuentra , si no null
	 */
	Modelo detalle(int idModelo);

	/**
	 * Eliminar un Modelo por su id
	 * 
	 * @param idCModelo identifacodr del Modelo
	 * @return true si elimina , false si no lo encuentra
	 * @throws ModeloeException No se puede eliminar si existe un vehiculo con
	 *                              este Modelo asociado
	 * @see ModeloException.EXCEPTION_CONSTRAINT
	 */
	Boolean eliminar(int idModelo) throws CombustibleException;

	/**
	 * Crear un Modelo
	 * 
	 * @param combustible Modelo a crear
	 * @return true si crea , false si no puede crear, minimo 1 maximo 45
	 * @throws ModeloException si el nombre del Modelo ya existe
	 * @throws SQLException
	 * @see ModeloException.EXCEPTION_EXIST
	 */
	Boolean crear(Modelo modelo) throws CombustibleException;

	/**
	 * Modifica el nombre de un Modelo identificado por su id
	 * 
	 * @param Modelo Modelo a modificar
	 * @return true si modifica, false si no puede modificar, minimo 1 maximo 45
	 *         caracteres
	 * @throws ModeloException si el nombre del Modelo ya existe
	 * @see ModeloException.EXCEPTION_EXIST
	 */
	Boolean modificar(Modelo modelo) throws CombustibleException;

}
