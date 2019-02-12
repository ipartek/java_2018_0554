package com.ipartek.formacion.cervezas.service.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;


import com.ipartek.formacion.cervezas.modelo.pojo.Compra;

public class CompraException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final String EXCEPTION_EXIST = "El nombre del Cerveza ya existe";

	public static final String EXCEPTION_CONSTRAINT = "No cumple las restricciones de la base de datos";

	public static final String EXCEPTION_VIOLATIONS = "No cumple las condiciones de Validación";

	private Set<ConstraintViolation<Compra>> violations;

	public CompraException(String message) {
		super(message);
		this.violations = null;
	}

	public CompraException(String message, Set<ConstraintViolation<Compra>> violations) {
		this(message);
		this.setViolations(violations);
	}

	public Set<ConstraintViolation<Compra>> getViolations() {
		return violations;
	}

	public void setViolations(Set<ConstraintViolation<Compra>> violations) {
		this.violations = violations;
	}

}

