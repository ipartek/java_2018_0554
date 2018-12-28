package com.ipartek.formacion.modelo.pojo;

public class Perro {
	
	private String nombre;
	private int edad;
	private String raza;
	private Double peso;
	private Boolean apadrinado;
	private Chip chip;
	
	public Perro() {
		super();
		this.nombre = "SinNombre";
		this.edad = 0;
		this.raza = "milrazas";
		this.peso = 0.0;
		this.apadrinado = false;
		this.chip = new Chip();
	}
	
	public Perro(String nombre, int edad, String raza, Double peso, Boolean apadrinado, Chip chip) {
		this();
		setNombre(nombre);
		setEdad(edad);
		setRaza(raza);
		setPeso(peso);
		setApadrinado(apadrinado);
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

	public Boolean getApadrinado() {
		return apadrinado;
	}

	public void setApadrinado(Boolean apadrinado) {
		this.apadrinado = apadrinado;
	}

	public Chip getChip() {
		return chip;
	}

	public void setChip(Chip chip) {
		this.chip = chip;
	}

	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + ", peso=" + peso + ", apadrinado="
				+ apadrinado + ", chip=" + chip + "]";
	}

}
