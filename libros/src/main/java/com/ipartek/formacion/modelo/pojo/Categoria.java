package com.ipartek.formacion.modelo.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Categoria {

	// Atributos
	
	private long id;
	
	@NotEmpty
	@Size(min=5, max=100)
	private String nombre;
	


	public Categoria() {
		super();
		this.id = -1;
		this.nombre = "";

	}
	
	public Categoria(String nombre) {
		this();
		this.nombre = nombre;
	}
	

	// Getters y Setters

	public Categoria(Long id, String nombre) {
		this();
		this.id = id;
		this.nombre = nombre;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	// Otros metodos => toString
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + "]";
	}


}
