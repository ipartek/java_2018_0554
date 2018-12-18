package com.ipartek.formacion.modelo.pojos;

public class Video {
	@Override
	public String toString() {
		return "Video [nombre=" + nombre + ", url=" + url + "]";
	}
	private String nombre;
	private String url;
	
	public Video(){
		super();
		this.nombre = "";
		this.url = "";
	}
	
	public Video(String nombre, String url) {
		super();
		setNombre(nombre);
		setUrl(url);
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
