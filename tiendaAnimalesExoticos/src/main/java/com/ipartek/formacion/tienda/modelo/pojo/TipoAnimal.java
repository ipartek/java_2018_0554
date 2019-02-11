package com.ipartek.formacion.tienda.modelo.pojo;

public class TipoAnimal {

	private int id;
	private String nombre;

	public TipoAnimal() {
		super();
		this.id =-1;
		this.nombre = "";
	}
	public TipoAnimal(int id, String nombre) {
		this();
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
		return "TipoAnimal [id=" + id + ", nombre=" + nombre + "]";
	}

}
