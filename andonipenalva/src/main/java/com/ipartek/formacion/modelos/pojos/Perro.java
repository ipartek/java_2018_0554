package com.ipartek.formacion.modelos.pojos;

public class Perro {
	private String chip;
	private String nombre;
	private int edad;
	private String raza;
	private int peso;
	private boolean apadrinado;
	
	//Chip arraylist DD-DDDD, latitud y longitud
	
	
	public Perro() {
		this.setChip("01-0001-1989");
		this.nombre="Loki";
		this.edad=0;
		this.raza="peke";
		this.peso=1;
		this.apadrinado=true;
		
		
	}
	
	public Perro(String chip,String nombre, int edad, String raza, int peso, boolean apadrinado) {
		super();
		this.chip=chip;
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.peso = peso;
		this.apadrinado = apadrinado;
	}



	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
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



	public int getPeso() {
		return peso;
	}



	public void setPeso(int peso) {
		this.peso = peso;
	}



	public boolean isApadrinado() {
		return apadrinado;
	}



	public void setApadrinado(boolean apadrinado) {
		this.apadrinado = apadrinado;
	}



	@Override
	public String toString() {
		return "Perro [chip="+ chip +",nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + ", peso=" + peso + ", apadrinado="
				+ apadrinado + "]";
	}
	


}
