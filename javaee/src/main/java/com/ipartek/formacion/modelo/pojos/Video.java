package com.ipartek.formacion.modelo.pojos;

public class Video {
	
	private Long id;
	private String nombre;
	private String url;
	
	public Video() {
		super();
		this.id= (long) -1;
		this.nombre="";
		this.url="";
	}
	
	public Video(Long id, String nombre, String url) {
		this();
		setId(id);
		setNombre(nombre);
		setUrl(url);
	}
	
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

	@Override
	public String toString() {
		return "Video [id=" + id + ", nombre=" + nombre + ", url=" + url + "]";
	}
	
}
