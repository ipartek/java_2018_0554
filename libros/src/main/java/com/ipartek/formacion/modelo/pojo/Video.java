package com.ipartek.formacion.modelo.pojo;

public class Video {

	// Atributos
	private long id;
	private String nombre;
	private String url;

	// Constructores

	public Video() {
		super();
		this.id = -1;
		this.nombre = "Surf Search Spot 2 0 video promo";
		this.url = "https://www.youtube.com/watch?v=LPDhuthFD98";
	}
	
	public Video(String nombre) {
		this();
		this.nombre = nombre;
	}
	

	// Getters y Setters

	public Video(Long id, String nombre, String url) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.url = url;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	// Otros metodos => toString

	@Override
	public String toString() {
		return "Video [id=" + id + ", nombre=" + nombre + ", url=" + url + "]";
	}

}
