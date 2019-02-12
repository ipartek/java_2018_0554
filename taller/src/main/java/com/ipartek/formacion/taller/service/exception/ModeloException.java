package com.ipartek.formacion.taller.service.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;

public class ModeloException extends ServiceException  {

	

	private static final long serialVersionUID = 1L;

	public static final String EXCEPTION_EXIST = "El nombre del Modelo ya existe";

	public static final String EXCEPTION_CONSTRAINT = "No se puede eliminar si existe un Vehiculo con este Modelo asociado";

	public static final String EXCEPTION_VIOLATIONS = "No cumple las condiciones de Validación";

	
	public ModeloException(String message, Set<ConstraintViolation> violations) {
		super(message, violations);
	}

}