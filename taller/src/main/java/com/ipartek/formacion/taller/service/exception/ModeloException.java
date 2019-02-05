package com.ipartek.formacion.taller.service.exception;

public class ModeloException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public static final String EXCEPTION_EXIST = "El nombre del modelo ya existe";
	
	public static final String EXCEPTION_CONSTRAINT = "No se puede eliminar si existe un Vehiculo con este modelo asociado";

	
	public ModeloException(String message) {
		super(message);				
	}

}
