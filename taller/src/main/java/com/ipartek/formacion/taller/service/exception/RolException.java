package com.ipartek.formacion.taller.service.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.ipartek.formacion.taller.modelo.pojo.Rol;

public class RolException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public static final String EXCEPTION_EXIST = "El nombre del rol ya existe";
	
	public static final String EXCEPTION_CONSTRAINT = "No se puede eliminar si existe una Persona con este rol asociado";

	public static final String EXCEPTION_VIOLATIONS = "No cumple las condiciones de Validación";
	
	private Set<ConstraintViolation<Rol>> violations;
	
	public RolException(String message) {
		super(message);				
		this.violations = null;				
	}
	
	public RolException(String message, Set<ConstraintViolation<Rol>> violations) {
		this(message);
		this.setViolations(violations);
	}
	
	public Set<ConstraintViolation<Rol>> getViolations() {
		return violations;
	}


	public void setViolations(Set<ConstraintViolation<Rol>> violations) {
		this.violations = violations;
	}

}
