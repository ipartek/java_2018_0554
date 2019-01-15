package com.ipartek.formacion.modelo.pojo;

import org.hibernate.validator.constraints.NotEmpty;

public class Categoria {
	private Long id;
	
	@NotEmpty
	private String nombre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categoria(Long id, String nombre) {
		this();
		setId(id);
		setNombre(nombre);
	}

	public Categoria() {
		super();
		this.id=-1l;
		this.nombre="Sin categoria";
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + "]";
	}
	

}
