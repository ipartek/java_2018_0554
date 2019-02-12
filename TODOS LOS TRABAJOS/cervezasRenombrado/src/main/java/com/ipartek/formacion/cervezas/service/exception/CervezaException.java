package com.ipartek.formacion.cervezas.service.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.ipartek.formacion.cervezas.modelo.pojo.Cerveza;

public class CervezaException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final String EXCEPTION_EXIST = "El nombre de la Cerveza ya existe";

	public static final String EXCEPTION_CONSTRAINT = "No cumple las restricciones de la base de datos";

	public static final String EXCEPTION_VIOLATIONS = "No cumple las condiciones de Validación";

	private Set<ConstraintViolation<Cerveza>> violations;

	public CervezaException(String message) {
		super(message);
		this.violations = null;
	}

	public CervezaException(String message, Set<ConstraintViolation<Cerveza>> violations) {
		this(message);
		this.setViolations(violations);
	}

	public Set<ConstraintViolation<Cerveza>> getViolations() {
		return violations;
	}

	public void setViolations(Set<ConstraintViolation<Cerveza>> violations) {
		this.violations = violations;
	}

}

