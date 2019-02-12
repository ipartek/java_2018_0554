package com.ipartek.formacion.cervezas.service;

import java.util.List;

import com.ipartek.formacion.cervezas.modelo.pojo.Compra;
import com.ipartek.formacion.cervezas.service.exception.CompraException;

public interface CompraService {

	// LISTAR - GET BY ALL
	/**
	 * Listado Compra ordenado por id descente
	 * 
	 * @return List<Compra>, Lista vacia si no hay datos
	 */
	List<Compra> listar(); // NO INCLUYE PARAMETRO

	// DETALLE - GET BY ID
	/**
	 * Obtener detalle Compra
	 * 
	 * @param idCompra int identificador de la Compra
	 * @return si encuentra Compra, si no <b>null</b>
	 */
	Compra detalle(int idCompra); // PARAMETRO ID

	// ELIMINAR - DELETE
	/**
	 * Elimina Compra por su identificador
	 * 
	 * @param idCompra int identificador de la Compra
	 * @return true si elimina, false si no lo encuentra
	 * @throws CompraException  Compra asociada
	 * @see CompraException.EXCEPTION_CONSTRAINT
	 */
	boolean eliminar(int idCompra) throws CompraException; // PARAMETRO ID

	// CREAR - INSERT
	/**
	 * Creamos un nuevo Compra, al crear con exito actualiza el <b>id</b>
	 * 
	 * @param CompraException Compra a crear
	 * @return true si lo crea, false si no puede crear,
	 *  <b>cantidad</b> not null
	 *  <b>idTipo</b> not null
	 *  <b>idCliente</b> not null
	 *  
	 * @throws CompraException si el nombre del Compra existe
	 * @see CompraException.EXCEPTION_EXIST
	 */
	boolean crear(Compra compra) throws CompraException; // PARAMETRO OBJETO

	// MODIFICAR - UPDATE
	/**
	 * Modifica el <b>nombre</b> de un Compra identificado por su <b>id</b>
	 * 
	 * @param CompraException Compra a modificar
	 * @return true si no modifica, false si no lo encuentra o <b>nombre</b> minimo
	 *         1 letra y maximo 45
	 * @throws CompraException el nombre ya existe
	 * @see CompraException.EXCEPTION_EXIST
	 */
	boolean modificar(Compra compra) throws CompraException; // PARAMETRO OBJETO

}