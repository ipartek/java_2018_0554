package com.ipartek.formacion.modelo.pojos;

import com.ipartek.formacion.modelo.pojos.Video;

public class Video {
	//Atributos
	private int id;
	private String nombre;
	private String url;

	public Video(int id, String nombre, String url) {
		setId(id);
		setNombre(nombre);
		setUrl(url);
	}

	public Video() {
		super();
		this.id = -1;
		this.nombre = "";
		this.url = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
