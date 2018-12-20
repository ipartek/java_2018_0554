package com.ipartek.formacion.modelo.pojos;

public class Video {
	
	// Atributos
	
	private long id;
	private String nombre;
	private String url;

	// Constructores
	
	public Video() throws PojoException {
		super();
		this.id = -1;
		this.nombre = "Cannibal Corpse - Hammer Smashed Face (HD)";
		this.url = "https://www.youtube.com/watch?v=BT0jvduweTQ";
	}

	

	public Video(int id, String nombre, String url) {
		this();
		setId(id);
		setNombre(nombre);
		setUrl(url);
	}
	
	
	
	//Getters & Setters

	public long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
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
	
	//Otros metodos 
	
	@Override
	public String toString() {
		return "Video [id=" + id + ", nombre=" + nombre + ", url=" + url + "]";
	}



}
