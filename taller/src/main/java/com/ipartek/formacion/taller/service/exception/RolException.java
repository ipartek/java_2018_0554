package com.ipartek.formacion.taller.service.exception;

public class RolException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public static final String EXCEPTION_EXIST = "El nombre del rol ya existe";
	
	public static final String EXCEPTION_CONSTRAINT = "No se puede eliminar si existe una Persona con este rol asociado";

	
	public RolException(String message) {
		super(message);				
	}

}
