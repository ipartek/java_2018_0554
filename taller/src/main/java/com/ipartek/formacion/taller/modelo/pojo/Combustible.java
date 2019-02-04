package com.ipartek.formacion.taller.modelo.pojo;

public class Combustible {
	
	private int id;
	private String nombre;
	
	
	public Combustible() {
		super();
		 this.id = -1;
		 this.nombre = "";
	}


	public Combustible(int id, String nombre) {
		this();
		this.id = id;
		this.nombre = nombre;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Combustible [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
	

}

