package com.ipartek.formacion.modelo.pojo;

public class Animal {
	
	private long id;
	private Especie especie;
	private Dieta dieta;
	private String nombre;
	private float precio;

	public Animal() {
		super();
		this.id = -1;
		this.especie = new Especie();
		this.dieta = new Dieta();
		this.nombre = "";
		this.precio = 0;
	}

	public Animal(long id, Especie especie, Dieta dieta, String nombre, float precio) {
		super();
		setId(id);
		setEspecie(especie);
		setDieta(dieta);
		setNombre(nombre);
		setPrecio(precio);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public Dieta getDieta() {
		return dieta;
	}

	public void setDieta(Dieta dieta) {
		this.dieta = dieta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", especie=" + especie + ", dieta=" + dieta + ", nombre=" + nombre + ", precio="
				+ precio + "]";
	}
}
