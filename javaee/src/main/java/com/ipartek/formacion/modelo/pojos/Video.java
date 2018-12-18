package com.ipartek.formacion.modelo.pojos;

public class Video {
	//ATRIBUTOS
	private long id;
	private String nombre;
	private String url;
	
	//CONSTRUCTORES
	public Video(){
		super();
		this.id=-1;
		this.nombre = "Video Promocional";
		this.url = "https://www.youtube.com/watch?v=yUPeEbgDNK0";
	}
	
	public Video(Long id,String nombre, String url) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", nombre=" + nombre + ", url=" + url + "]";
	}
	
}
