package com.ipartek.formacion.taller.modelo.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Combustible {

	private Integer id;

	@NotEmpty
	@Size(min = 1, max = 45)
	private String nombre;

	public Combustible() {
		super();
		this.id = -1;
		this.nombre = "";

	}

	public Combustible(Integer id, String nombre) {
		this();
		setId(id);
		setNombre(nombre);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
