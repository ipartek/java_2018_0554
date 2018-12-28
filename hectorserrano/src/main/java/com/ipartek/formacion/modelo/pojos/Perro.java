package com.ipartek.formacion.modelo.pojos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class Perro {
	@NotEmpty
	@Pattern(regexp = "[0-9]{2}-[0-9]{4}-[0-9]{4}", message = "Formato incorrecto. Debe tener este formato: DD-DDDD-AAAA")
	private String chip;
	@NotEmpty
	private String coordenadas = "0 x 0";
	@NotEmpty
	private String nombre;
	@NotNull
	private int edad = 0;
	@NotEmpty
	private String raza;
	
	public Perro(String chip, String coordenadas, String nombre, int edad, String raza) {
		setChip(chip);
		setCoordenadas(coordenadas);
		setNombre(nombre);
		setEdad(edad);
		setRaza(raza);
	}
	
	public Perro(String chip, String nombre, String raza) {
		setChip(chip);
		setNombre(nombre);
		setRaza(raza);
	}

	public Perro() {
		// TODO Auto-generated constructor stub
	}

	public String getChip() {
		return chip;
	}
	public void setChip(String chip) {
		this.chip = chip;
	}
	public String getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
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
	@Override
	public String toString() {
		return "Perro [chip=" + chip + ", coordenadas=" + coordenadas + ", nombre=" + nombre + ", edad=" + edad + ", raza="
				+ raza + "]";
	}
	
}
