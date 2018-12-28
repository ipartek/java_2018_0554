package com.ipartek.formacion.modelos;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class Perro {
	@NotEmpty
	private String nombre;
	private int edad;
	@NotEmpty
	private String raza;
	private Double peso;
	private boolean padrino;
	@NotEmpty
	@Pattern(regexp="[0-9]{2}-[0-9]{4}-[0-9]{4}")
	private String chip;//luego sera un objeto para almacenar la localizacion
	
	public Perro() {
		super();
		this.nombre="xxxxx";
		this.edad=0;
		this.raza="MilRazas";
		this.peso=5.5;
		this.padrino=false;
		this.chip="00-0000-0000";
	}
	public Perro(String nombre, String raza, String chip) {
		this();
		setNombre(nombre);
		setEdad(0);
		setRaza(raza);
		setPeso(5.5);
		setPadrino(false);
		setChip(chip);
	}
	public Perro(String nombre, int edad, String raza, Double peso, boolean padrino, String chip) {
		this();
		setNombre(nombre);
		setEdad(edad);
		setRaza(raza);
		setPeso(peso);
		setPadrino(padrino);
		setChip(chip);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public boolean isPadrino() {
		return padrino;
	}
	public void setPadrino(boolean padrino) {
		this.padrino = padrino;
	}
	public String getChip() {
		return chip;
	}
	public void setChip(String chip) {
		this.chip = chip;
	}
	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + ", peso=" + peso + ", padrino="
				+ padrino + ", chip=" + chip + "]";
	}

	
	

}
