package com.ipartek.formacion.modelo.pojo;

import java.util.Date;

public class Perro {
	
	String nombre, peso, raza;
	int edad;
	boolean apadrinado;
	
	public Perro() {
		super();
		this.nombre ="";
		this.peso ="";
		this.raza ="";
		this.edad = 15;
		this.apadrinado=true;
	
	}
	
	public Perro(String nombre, String peso, String raza, int edad, boolean apadrinado) {
		this();
		setNombre(nombre);
		setPeso(peso);
		setRaza(raza);
		setEdad(edad);
		setApadrinado(apadrinado);
		
	}
	
	public Perro(String nombre,String raza) {
		this();
		setNombre(nombre);
		setRaza(raza);
	
		
	}

	public boolean isApadrinado() {
		return apadrinado;
	}

	public void setApadrinado(boolean apadrinado) {
		this.apadrinado = apadrinado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", peso=" + peso + ", raza=" + raza + ", edad=" + edad + "]";
	}


	
	
}
