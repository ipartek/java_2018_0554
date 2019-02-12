package com.ipartek.formacion.modelo.pojo;

public class Especie {
	private int id;
	private String nombre;
	
	public Especie() {
		super();
		this.id = -1;
		this.nombre = "";
	}
	
	public Especie(int id, String nombre) {
		super();
		setId(id);
		setNombre(nombre);
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
		return "Especie [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
