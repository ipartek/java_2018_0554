package com.ipartek.formacion.tienda.service;

import com.ipartek.formacion.tienda.modelo.pojo.Venta;
import com.ipartek.formacion.tienda.service.exception.VentaException;

public interface VentaService {

	/**
	 * Método para realizar la compra de una animal por una persona
	 * 
	 * @param venta Objeto compuesto por el comprador (<b>Persona</b>) y el
	 * <b>Animal</b> a comprar
	 * @return <b>True</b> en caso de que la compra se realice correctamente,
	 *         <b>False</b> si ocurre algún problema.
	 */
	boolean crear(Venta venta) throws VentaException;

}
