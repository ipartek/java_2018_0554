package com.ipartek.formacion.taller.service.exception;

public class PersonaException extends Exception {

	public PersonaException(String mensaje) {
		super(mensaje);
	}
	private static final long serialVersionUID = 1L;
	public static final String EXCEPTION_EXISTS = "La Persona ya existe";
	public static final String EXCEPTION_COSTRAINT = "No se sepuede eliminar ya que esta persona esta asiciada a algun rol";

}
