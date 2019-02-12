package com.ipartek.formacion.taller.service.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.ipartek.formacion.taller.modelo.pojo.Combustible;

public class VehiculoException extends Exception {

	private static final long serialVersionUID = 1L;

	// TODO poner algo mas correcto
	public static final String EXCEPTION_INTEGRITY = "Soy una Tetera en MySQL";
	
	private Set<ConstraintViolation<Combustible>> violations;
	
	public VehiculoException(String message) {
		super(message);				
		this.violations = null;
	}


	public VehiculoException(String message, Set<ConstraintViolation<Combustible>> violations) {
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
