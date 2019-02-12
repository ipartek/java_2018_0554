package com.ipartek.formacion.animales.service.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.ipartek.formacion.animales.modelo.pojo.Animal;

public class AnimalException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final String EXCEPTION_EXIST = "El nombre de la Animal ya existe";

	public static final String EXCEPTION_CONSTRAINT = "No cumple las restricciones de la base de datos";

	public static final String EXCEPTION_VIOLATIONS = "No cumple las condiciones de Validación";

	private Set<ConstraintViolation<Animal>> violations;

	public AnimalException(String message) {
		super(message);
		this.violations = null;
	}

	public AnimalException(String message, Set<ConstraintViolation<Animal>> violations) {
		this(message);
		this.setViolations(violations);
	}

	public Set<ConstraintViolation<Animal>> getViolations() {
		return violations;
	}

	public void setViolations(Set<ConstraintViolation<Animal>> violations) {
		this.violations = violations;
	}

}

