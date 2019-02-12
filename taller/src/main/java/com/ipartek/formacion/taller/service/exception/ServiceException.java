package com.ipartek.formacion.taller.service.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;

public class ServiceException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public static final String EXCEPTION_GENERIC = "Soy una Tetera en MySQL";
	
	private Set<ConstraintViolation> violations;
	
	public ServiceException(String message) {
		super(message);				
		this.violations = null;
	}


	public ServiceException(String message, Set<ConstraintViolation> violations) {
		this(message);
		this.setViolations(violations);
	}


	public Set<ConstraintViolation> getViolations() {
		return violations;
	}


	public void setViolations(Set<ConstraintViolation> violations) {
		this.violations = violations;
	}

}
