package com.ipartek.formacion.taller.service;

import java.util.List;

import com.ipartek.formacion.taller.modelo.pojo.Modelo;
import com.ipartek.formacion.taller.service.exception.ModeloException;

public interface ModeloService {

	// LISTAR - GET BY ALL
	/**
	 * Listado Modelo ordenado por id descente
	 * 
	 * @return List<Modelo>, Lista vacia si no hay datos
	 */
	List<Modelo> listar(); // NO INCLUYE PARAMETRO

	// DETALLE - GET BY ID
	/**
	 * Obtener detalle Modelo
	 * 
	 * @param idModelo int identificador del Modelo
	 * @return si encuentra Modelo, si no <b>null</b>
	 */
	Modelo detalle(int idModelo); // PARAMETRO ID

	// ELIMINAR - DELETE
	/**
	 * Elimina Modelo por su identificador
	 * 
	 * @param idModelo int identificador del Modelo
	 * @return true si elima, false si no lo encuentra
	 * @throws ModeloException No se puede eliminar si existe un Vehiculo con
	 *                              este Modelo asociado
	 * @see ModeloException.EXCEPTION_CONSTRAINT
	 */
	boolean eliminar(int idModelo) throws ModeloException; // PARAMETRO ID

	// CREAR - INSERT
	/**
	 * Creamos un nuevo Modelo, al crear con exito actualiza el <b>id</b>
	 * 
	 * @param Modelo Modelo a crear
	 * @return true si lo crea, false si no puede crear, <b>nombre</b> minimo 1
	 *         letra y maximo 45
	 * @throws ModeloException si el nombre del Modelo existe
	 * @see ModeloException.EXCEPTION_EXIST
	 */
	boolean crear(Modelo modelo) throws ModeloException; // PARAMETRO OBJETO

	// MODIFICAR - UPDATE
	/**
	 * Modifica el <b>nombre</b> de un Modelo identificado por su <b>id</b>
	 * 
	 * @param Modelo Modelo a modificar
	 * @return true si no modifica, false si no lo encuentra o <b>nombre</b> minimo
	 *         1 letra y maximo 45
	 * @throws ModeloException el nombre ya existe
	 * @see ModeloException.EXCEPTION_EXIST
	 */
	boolean modificar(Modelo modelo) throws ModeloException; // PARAMETRO OBJETO

}