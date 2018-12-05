package com.ipartek.formacion.repaso;

import java.math.BigDecimal;

//La clase se ve obligada a ser abstracta al tener un método abstracto
//Por ello no se puede instanciar (new Empleado no funciona)
public abstract class Empleado extends Persona {
	private String numeroSeguridadSocial;
	private String dni;
	
	public Empleado(Long id, String nombre, String apellidos, String numeroSeguridadSocial, String dni) {
		super(id, nombre, apellidos); //Llama al constructor del padre: Persona
		
		this.numeroSeguridadSocial = numeroSeguridadSocial;
		this.dni = dni;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Empleado [numeroSeguridadSocial=" + numeroSeguridadSocial + ", dni=" + dni + "]";
	}
	
	//Este método es abstracto, porque es una obligación de todo empleado ser capaz
	//de devolver un sueldo mensual, pero el cómo se resuelve el problema depende del
	//tipo de empleado
	public abstract BigDecimal getSueldoMensual();
	
}
