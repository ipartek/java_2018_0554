package com.ipartek.formacion.modelo.pojo;

public class Video {
	
	//Atributos
	private long id;
	private String nombre;
	private String url;
	
	//Constructores
	public Video() {
		super();
		this.id = -1;
		this.nombre ="";
		this.url ="";
	}
	

	public Video(String nombre) {
		this();
		this.nombre = nombre;
	
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

	@Override
	public String toString() {
		return "Video [id=" + id + ", nombre=" + nombre + ", url=" + url + "]";
	}
	
	
	
}
