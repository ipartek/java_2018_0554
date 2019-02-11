package com.ipartek.formacion.tienda.service.exception;

public class VentaException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Excepción genérica para lanzar si ocurre algún <b>error inesperado</b> en el proceso de compra
	 */
	public static final String EXCEPTION_VENTA = "Error en la creación de la venta";
	/**
	 * Excepción para lanzar si <b>no existe Stock</b> para el animal que deseamos comprar
	 */
	public static final String EXCEPTION_NO_STOCK = "No disponemos de Stock para el animal deseado";

	public VentaException(String mensaje) {
		super(mensaje);
	}

}
