package com.ipartek.formacion.modelo.pojos;

public class Retro {

	private long id;
	public String nombre;
	public String plataforma;
	public String url;

	public Retro(long id, String nombre, String plataforma, String url) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.plataforma = plataforma;
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

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Retro [id=" + id + ", nombre=" + nombre + ", plataforma=" + plataforma + ", url=" + url + "]";
	}

}
