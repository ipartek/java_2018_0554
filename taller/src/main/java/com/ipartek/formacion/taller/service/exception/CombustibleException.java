package com.ipartek.formacion.taller.service.exception;

public class CombustibleException extends Exception {
	private static final long serialVersionIUD = 1L;
	public static final String EXCEPTION_EXIST = "El nombre del combustible ya existe";
	
	public static final String EXCEPTION_CONSTRAINT = "No se puede eliminar si existe un vehiculo que tenga esas propiedades";
	
	public CombustibleException(String message) {
		super(); //con herencias no hace falta escribir lo de abajo
		
		//new Exception(message);
	}
}
