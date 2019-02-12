package com.ipartek.formacion.taller.service.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;

public class PersonaException extends ServiceException {


	

	private static final long serialVersionUID = 1L;
	
	public static final String EXCEPTION_EXISTS = "La Persona ya existe";
	
	public static final String EXCEPTION_COSTRAINT = "No se sepuede eliminar ya que esta persona esta asiciada a algun rol";

	public PersonaException(String message, Set<ConstraintViolation> violations) {
		super(message, violations);		
	}
	
}
