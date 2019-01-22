package com.ipartek.insercionUsuarios.pojo;

public class Persona {

	String nombre;
	String ap1;
	String ap2;
	int edad;
	String email;
	String dni;
	
	public Persona() {
		super();
	}
	
	public Persona(String nombre, String ap1, String ap2, int edad, String email, String dni) {
		this();
		setNombre(nombre);
		setAp1(ap1);
		setAp2(ap2);
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

	public String getAp1() {
		return ap1;
	}

	public void setAp1(String ap1) {
		this.ap1 = ap1;
	}

	public String getAp2() {
		return ap2;
	}

	public void setAp2(String ap2) {
		this.ap2 = ap2;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
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
