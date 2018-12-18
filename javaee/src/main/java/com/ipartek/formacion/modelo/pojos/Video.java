package com.ipartek.formacion.modelo.pojos;

public class Video {

//	Atributos
	private Long id;
	private String nombre;
	private String url;

//	Constructores
	public Video() {
		super();
		this.id = -1L;
		this.nombre = "https://www.youtube.com/watch?v=aavV58NxIf8";
		this.url = "Best Songs Of Linkin Park";
	}

//  Getters y setters

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

//	Otros metodos ->toString
	@Override
	public String toString() {
		return "Video [id=" + id + ", nombre=" + nombre + ", url=" + url + "]";
	}
}
