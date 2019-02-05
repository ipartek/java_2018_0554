package com.ipartek.formacion.taller.service;

import java.sql.SQLException;
import java.util.List;

import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.service.exception.CombustibleException;

public interface CombustibleService {
	
	/**
	 * Listado de todos los combustibles registrados ordenado por ID descendente
	 * @return List<Combustible>, Lista vacía si no hay datos
	 */
	List<Combustible> listar();
	
	/**
	 * Detalle de un combustible concreto
	 * @param idCombustible int ID del combustible del que se quiere obtener el detalle
	 * @return Combustible, <b>Null</b> si no existe
	 */
	Combustible detalle(int idCombustible);
	
	/**
	 * Elimina el combustible del que se proporcione su ID
	 * @param idCombustible int ID del combustible a eliminar
	 * @return <b>True</b> si elimina, <b>False</b> si no lo encuentra
	 * @throws CombustibleException <b>EXCEPTION_CONSTRAINT</b> No se puede eliminar si existe un Vehículo con este combustible asociado
	 * @throws SQLException 
	 * @see CombustibleException.EXCEPTION_CONSTRAINT
	 */
	boolean eliminar(int idCombustible) throws CombustibleException, SQLException;
	
	/**
	 * Crear un nuevo Combustible en la BD. Al crear con éxito, actualiza el <b>ID</b>
	 * @param combustible Combustible a crear
	 * @return <b>True</b> si lo crea, <b>False</b> si no lo puede crear, <b>Nombre</b> mínimo 1 letra, máximo 45
	 * @throws CombustibleException <b>EXCEPTION_EXIST</b> El nombre del combustible ya existe
	 * @see CombustibleException.EXCEPTION_EXIST
	 */
	boolean crear(Combustible combustible) throws CombustibleException;
	
	/**
	 * Modifica el <b>nombre</b> de un Combustible, identificado por su <b>ID</b>
	 * @param combustible Combustible a modificar
	 * @return <b>True</b> si lo modifica, <b>False</b> si no lo encuentra o mínimo 1 letra, máximo 45 en el <b>nombre</b>
	 * @throws CombustibleException <b>EXCEPTION_EXIST</b> El nombre ya existe
	 * @see CombustibleException.EXCEPTION_EXIST
	 */
	boolean modificar(Combustible combustible) throws CombustibleException;

}
