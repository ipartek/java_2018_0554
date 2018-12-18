package com.ipartek.formacion.modelo.pojos;

public class Video {
	private Long id;
	public Video(Long id, String nombre, String url) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.url = url;
	}
	private String nombre;
	private String url;
	
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
}
