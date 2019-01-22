package com.ipartek.personas.modelo.pojo;

public class Persona {
	private String nombre;
	private String apellido1;
	private String apellido2;
	private Integer edad;
	private String email;
	private String dni;
	

	
	public Persona() {
		super();
	}
	public Persona(String nombre, String apellido1, String apellido2, Integer edad, String email, String dni) {
		this();
		setNombre(nombre);
		setApellido1(apellido1);
		setApellido2(apellido2);
		setEdad(edad);
		setEmail(email);
		setDni(dni);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
	
	
	
}
