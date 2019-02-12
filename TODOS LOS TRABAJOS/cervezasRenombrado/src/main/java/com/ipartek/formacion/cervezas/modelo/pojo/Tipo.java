package com.ipartek.formacion.cervezas.modelo.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Tipo {

	private int id;

	@NotEmpty
	@Size(min = 1, max = 45)
	private String nombre;

	public Tipo() {
		super();
		this.id = -1;
		this.nombre = "";
	}

	public Tipo(int id, String nombre) {
		this();
		this.setId(id);
		this.setNombre(nombre);
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
		return "Tipo [id=" + id + ", nombre=" + nombre + "]";
	}

}
