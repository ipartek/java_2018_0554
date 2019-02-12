package com.ipartek.formacion.cervezas.service;

import java.util.List;

import com.ipartek.formacion.cervezas.modelo.pojo.Cerveza;
import com.ipartek.formacion.cervezas.service.exception.CervezaException;

public interface CervezaService {

	// LISTAR - GET BY ALL
	/**
	 * Listado Cerveza ordenado por id descente
	 * 
	 * @return List<Cerveza>, Lista vacia si no hay datos
	 */
	List<Cerveza> listar(); // NO INCLUYE PARAMETRO

	// DETALLE - GET BY ID
	/**
	 * Obtener detalle Cerveza
	 * 
	 * @param idCerveza int identificador del Cerveza
	 * @return si encuentra Cerveza, si no <b>null</b>
	 */
	Cerveza detalle(int idCerveza); // PARAMETRO ID

	// ELIMINAR - DELETE
	/**
	 * Elimina Cerveza por su identificador
	 * 
	 * @param idCerveza int identificador del Cerveza
	 * @return true si elima, false si no lo encuentra
	 * @throws CervezaException  esta Cerveza tiene una restriccion.
 	 * @see CervezaException.EXCEPTION_CONSTRAINT 
	 */
	boolean eliminar(int idCerveza) throws CervezaException; // PARAMETRO ID

	// CREAR - INSERT
	/**
	 * Creamos una nueva Cerveza, al crear con exito actualiza el <b>id</b>
	 * 
	 * @param CervezaException Cerveza a crear
	 * @return true si lo crea, false si no puede crear, 
	 *		<b>nombre</b> minimo 1 letra y maximo 45
	 * 		<b>idTipo</b> debe esistir en la base de datos
	 * 		<b>precio</b> float not null. 
	 * 
	 * @throws CervezaException si el nombre de la Cerveza existe
	 * @see CervezaException.EXCEPTION_EXIST
	 */
	boolean crear(Cerveza cerveza) throws CervezaException; // PARAMETRO OBJETO

	// MODIFICAR - UPDATE
	/**
	 * Modifica el <b>nombre</b> de un Cerveza identificado por su <b>id</b>
	 * 
	 * @param CervezaException Cerveza a modificar
	 * @return true si no modifica, false si no la encuentra o <b>nombre</b> minimo
	 * 		<b>nombre</b> minimo 1 letra y maximo 45
	 * 		<b>idTipo</b> debe esistir en la base de datos
	 * 		<b>precio</b> float not null. 
	 * @throws CervezaException el nombre ya existe
	 * @see CervezaException.EXCEPTION_EXIST
	 */
	boolean modificar(Cerveza cerveza) throws CervezaException; // PARAMETRO OBJETO

}