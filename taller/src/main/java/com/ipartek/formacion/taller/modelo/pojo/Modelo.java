

package com.ipartek.formacion.taller.modelo.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.ipartek.formacion.taller.modelo.pojo.validactions.VehiculoCompleteCheck;

public class Modelo {

	private int id;

	@NotEmpty
	@Size(min = 1, max = 45, groups = {VehiculoCompleteCheck.class})
	private String nombre;

	public Modelo() {
		super();
		this.id = -1;
		this.nombre = "";
	}

	public Modelo(int id, String nombre) {
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
		return "Modelo [id=" + id + ", nombre=" + nombre + "]";
	}

}