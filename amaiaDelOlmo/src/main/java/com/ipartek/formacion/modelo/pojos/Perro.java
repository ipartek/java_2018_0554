package com.ipartek.formacion.modelo.pojos;

public class Perro {

	// Atributos
	private String nombre;
	private int edad;
	private String raza;
	private int peso;
	private String apadrinado;
	private String chip;
	private String localizacion;
	
	
	// Constructores
	
	public Perro() {
		super();
		this.nombre = "Tobi";
		this.edad = 10;
		this.raza = "Bulldog";
		this.peso = 20;
		this.apadrinado = "Sí";
		this.chip = "01-DDDD-2008";
		this.localizacion = "1800, 1550";
	}
	
	
	public Perro(String nombre, int edad, String raza, int peso, String apadrinado, String chip, String localizacion) {
		this();
		setNombre(nombre);
		setEdad(edad);
		setRaza(raza);
		setPeso(peso);
		setApadrinado(apadrinado);
		setChip(chip);
		setLocalizacion(localizacion);
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}


	public String getChip() {
		return chip;
	}


	public void setChip(String chip) {
		this.chip = chip;
	}


	public String getLocalizacion() {
		return localizacion;
	}


	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
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


	public int getPeso() {
		return peso;
	}


	public void setPeso(int peso) {
		this.peso = peso;
	}


	public String getApadrinado() {
		return apadrinado;
	}


	public void setApadrinado(String apadrinado) {
		this.apadrinado = apadrinado;
	}

	
	// Otros metodos => toString
	

	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + ", peso=" + peso + ", apadrinado="
				+ apadrinado + ", chip=" + chip + ", localizacion=" + localizacion + "]";
	}

	

}