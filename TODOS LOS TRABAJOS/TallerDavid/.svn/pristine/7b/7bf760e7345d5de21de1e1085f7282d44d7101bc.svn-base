package com.ipartek.formacion.taller.service.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.ipartek.formacion.taller.modelo.pojo.Modelo;

public class ModeloException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final String EXCEPTION_EXIST = "El nombre del Modelo ya existe";

	public static final String EXCEPTION_CONSTRAINT = "No se puede eliminar si existe un Vehiculo con este Modelo asociado";

	public static final String EXCEPTION_VIOLATIONS = "No cumple las condiciones de Validación";

	private Set<ConstraintViolation<Modelo>> violations;

	public ModeloException(String message) {
		super(message);
		this.violations = null;
	}

	public ModeloException(String message, Set<ConstraintViolation<Modelo>> violations) {
		this(message);
		this.setViolations(violations);
	}

	public Set<ConstraintViolation<Modelo>> getViolations() {
		return violations;
	}

	public void setViolations(Set<ConstraintViolation<Modelo>> violations) {
		this.violations = violations;
	}

}