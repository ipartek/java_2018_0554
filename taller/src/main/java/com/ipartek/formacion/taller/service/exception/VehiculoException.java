package com.ipartek.formacion.taller.service.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;

public class VehiculoException extends ServiceException {

	
	private static final long serialVersionUID = 1L;

	public static final String EXCEPTION_INTEGRITY = "El propietario, modelo o combustible no es correcto";

	public VehiculoException(String message, Set<ConstraintViolation> violations) {
		super(message, violations);		
	}

	
}
