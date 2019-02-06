package com.ipartek.formacion.taller.service.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.ipartek.formacion.taller.modelo.pojo.Combustible;

public class CombustibleException extends Exception {
	private static final long serialVersionIUD = 1L;
	public static final String EXCEPTION_EXIST = "El nombre del combustible ya existe";

	public static final String EXCEPTION_CONSTRAINT = "No se puede eliminar si existe un vehiculo que tenga esas propiedades";

	// NUEVO!
	public static final String EXCEPTION_VIOLATIONS = "No cumple las condiciones de Validación";

	private Set<ConstraintViolation<Combustible>> violations;

	public CombustibleException(String message) {
		super(); // con herencias no hace falta escribir lo de abajo

		// new Exception(message);

		this.violations = null;
	}

	public CombustibleException(String message, Set<ConstraintViolation<Combustible>> violations) {
		this(message);
		this.setViolations(violations);

	}

	public Set<ConstraintViolation<Combustible>> getViolations() {
		return violations;
	}

	public void setViolations(Set<ConstraintViolation<Combustible>> violations) {
		this.violations = violations;
	}

}
