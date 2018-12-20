package com.ipartek.formacion.pojo;

public class Video {
	
	//atributos
	private long id;
	private String nombre;
	private String url;
	
	//Constructores
	public Video() {
		this.id=-1;
		this.nombre="Parking at Church | Mr. Bean Official";
		this.url="https://www.youtube.com/watch?v=4jQfP0PLCEQ";
	}
	
	public Video(Long id, String nombre, String url) {
		this.id = id;
		this.nombre = nombre;
		this.url = url;
	}

	//Getters y setters
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	//Otros metodos -> toString
	@Override
	public String toString() {
		return "Video [id=" + id + ", nombre=" + nombre + ", url=" + url + "]";
	}
	
	
	
	
	
	
}
