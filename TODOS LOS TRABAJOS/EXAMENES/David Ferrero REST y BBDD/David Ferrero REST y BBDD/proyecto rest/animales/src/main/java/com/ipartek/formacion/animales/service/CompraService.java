package com.ipartek.formacion.animales.service;

import java.util.List;

import com.ipartek.formacion.animales.modelo.pojo.Compra;
import com.ipartek.formacion.animales.service.exception.CompraException;

public interface CompraService {

	// LISTAR - GET BY ALL  . SIN USO
	List<Compra> listar(); 
	
	// DETALLE - GET BY ID SIN USO
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
	 *   <b>idEmpleado</b> not null, por defecto muestra la fecha de creacion.
	 *  <b>idEmpleado</b> not null
	 *  <b>idTipo</b> not null
	 *  <b>idCliente</b> not null
	 *  
	 * @throws CompraException si el nombre del Compra existe
	 * @see CompraException.EXCEPTION_EXIST
	 */
	boolean crear(Compra compra) throws CompraException; // PARAMETRO OBJETO

	
	// MODIFICAR - UPDATE  SIN USO	
	boolean modificar(Compra compra) throws CompraException; // PARAMETRO OBJETO

}