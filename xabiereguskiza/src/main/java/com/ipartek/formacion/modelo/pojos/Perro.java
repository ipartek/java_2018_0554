package com.ipartek.formacion.modelo.pojos;

public class Perro {
	
	public static final String REGEX_CHIP ="(\\d{2}-\\d{4}-\\d{4})";
	
	private String nombre;
	private String edad;
	private String raza;
	private String peso;
	private boolean apadrinado;
	private String chip;
	private String longitud;
	private String latitud;
	
	
	public Perro() {
		super();
		this.nombre = "";
		this.edad = "";
		this.raza = "";
		this.peso = "";
		this.apadrinado = true;
		this.chip = "";
		this.longitud = "";
		this.latitud = "";
	}


	public Perro(String nombre, String edad, String raza, String peso, boolean apadrinado, String chip, String longitud,
			String latitud) {
		this();
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.peso = peso;
		this.apadrinado = apadrinado;
		this.chip = chip;
		this.longitud = longitud;
		this.latitud = latitud;
	}


	public Perro(String nombrep, String chipp, String razap) {
		// TODO Auto-generated constructor stub
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEdad() {
		return edad;
	}


	public void setEdad(String edad) {
		this.edad = edad;
	}


	public String getRaza() {
		return raza;
	}


	public void setRaza(String raza) {
		this.raza = raza;
	}


	public String getPeso() {
		return peso;
	}


	public void setPeso(String peso) {
		this.peso = peso;
	}


	public boolean isApadrinado() {
		return apadrinado;
	}


	public void setApadrinado(boolean apadrinado) {
		this.apadrinado = apadrinado;
	}


	public String getChip() {
		return chip;
	}


	public void setChip(String chip) {
		this.chip = chip;
	}


	public String getLongitud() {
		return longitud;
	}


	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}


	public String getLatitud() {
		return latitud;
	}


	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}


	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + ", peso=" + peso + ", apadrinado="
				+ apadrinado + ", chip=" + chip + ", longitud=" + longitud + ", latitud=" + latitud + "]";
	}


	
	
	
	
	

}
