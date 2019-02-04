package com.ipartek.formacion.taller.modelo.pojo;

public class Rol {

	private Integer id;

	private String nombre;

	public Rol() {
		super();
		this.id = -1;
		this.nombre = "";
	}

	public Rol(Integer id, String nombre) {
		this();
		;
		this.setId(id);
		this.setNombre(nombre);
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
		return "Rol [id=" + id + ", nombre=" + nombre + "]";
	}

}
