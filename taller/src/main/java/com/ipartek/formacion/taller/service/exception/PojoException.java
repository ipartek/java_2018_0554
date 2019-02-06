package com.ipartek.formacion.taller.service.exception;

public class PojoException extends Exception {

	

	private static final long serialVersionUID = 1L;
	
	public static final String EXCEPTION_EXIST = "El nombre  ya existe";
	
	public static final String EXCEPTION_CONSTRAINT = "No se puede eliminar si existen  asociado";

	public PojoException(String mensaje) {
		super(mensaje);
	}
}
