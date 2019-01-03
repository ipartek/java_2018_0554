package com.ipartek.formacion.modelo.pojo;

public class Video {

	// Atributos
	private long id;
	private String nombre;
	private String codigo;

	// Constructores

	public Video() {
		super();
		this.id = -1;
		this.nombre = "Surf Search Spot 2 0 video promo";
		this.codigo = "LPDhuthFD98";
	}
	
	public Video(String nombre) {
		this();
		this.nombre = nombre;
	}
	

	// Getters y Setters

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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String Codigo) {
		this.codigo = codigo;
	}

	// Otros metodos => toString

	@Override
	public String toString() {
		return "Video [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + "]";
	}

}
