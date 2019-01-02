package com.ipartek.formacion.modelo.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Perro {
	public static final String REGEX_CHIP = "d\\d-\\d\\d\\d\\d-\\d\\d\\d\\d";
	
	
	
// Atributos	
	@NotEmpty
	@Size(min=2, max=255)
	private String nombre;
	

	private Long edad;
	
	private String raza;
	

	private Long peso;
	
	private Boolean apadrinado;
	
	@NotEmpty
	@Size(min=2, max=255)
	private String chip;
	

	private String localizacion;

	
	
	
	
//	Getters y setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getEdad() {
		return edad;
	}

	public void setEdad(Long edad) {
		this.edad = edad;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public Long getPeso() {
		return peso;
	}

	public void setPeso(Long peso) {
		this.peso = peso;
	}

	public Boolean getApadrinado() {
		return apadrinado;
	}

	public void setApadrinado(Boolean apadrinado) {
		this.apadrinado = apadrinado;
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

	
	
	
	
//	Constructor vacio
	public Perro() {
		super();
		this.nombre = "";
		this.edad = null;
		this.raza = "milrazas";
		this.peso = null;
		this.apadrinado = false;
		this.chip = "";
		this.localizacion = "";
	}

	
	
	
	
//	Constructor con todos los valores
	public Perro(String nombre, Long edad, String raza, Long peso, Boolean apadrinado, String chip,
			String localizacion) {
		this();
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.peso = peso;
		this.apadrinado = apadrinado;
		this.chip = chip;
		this.localizacion = localizacion;
	}
	
	

	
//	Constructor para perros sin raza (milrazas)
	
	public Perro(String nombre, Long edad, Long peso, Boolean apadrinado, String chip,
			String localizacion) {
		this();
		this.nombre = nombre;
		this.edad = edad;
		this.raza = "milrazas";
		this.peso = peso;
		this.apadrinado = apadrinado;
		this.chip = chip;
		this.localizacion = localizacion;
	}

//	Constructor para perros sin mucho detalle
	
	public Perro(String nombre, String raza, String chip) {
		this();
		this.nombre = nombre;
		this.raza = raza;
		this.chip = chip;

	}
	
	
	
	
//	Constructor para perros sin mucho detalle y sin raza
	
	public Perro(String nombre, String chip) {
		this();
		this.nombre = nombre;
		this.raza = "milrazas";
		this.chip = chip;

	}
	
	
//	ToString
	
	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + ", peso=" + peso + ", apadrinado="
				+ apadrinado + ", chip=" + chip + ", localizacion=" + localizacion + "]";
	}
	



}
