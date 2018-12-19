package com.ipartek.formacion.modelo.pojos;

public class Videos {

	// Atributos
	private long id;
	private String titulo;
	private String url;

	// Constructores

	public Videos() {
		super();
		this.id = -1;
		this.titulo = "Surf Search Spot 2 0 video promo";
		this.url = "https://www.youtube.com/watch?v=LPDhuthFD98";
	}
	
	public Videos(String Titulo) {
		
	
		this.titulo = "Surf Search Spot 2 0 video promo";
	
	}
	

	// Getters y Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	// Otros metodos => toString

	@Override
	public String toString() {
		return "Video [id=" + id + ", titulo=" + titulo + ", url=" + url + "]";
	}

}