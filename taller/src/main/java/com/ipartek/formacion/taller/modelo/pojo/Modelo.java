package com.ipartek.formacion.taller.modelo.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Modelo {
	
	private int id;
	
	@NotEmpty
	@Size(min = 1, max = 100)
	private String nombre;
	 
	 
	public Modelo() {
		super();
		 this.id = -1;
		 this.nombre = "";
	}


	public Modelo(int id, String nombre) {
		super();
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
		return "Modelo [id=" + id + ", nombre=" + nombre + "]";
	}
	 
	 

}
