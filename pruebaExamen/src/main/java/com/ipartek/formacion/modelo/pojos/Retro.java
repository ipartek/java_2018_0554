package com.ipartek.formacion.modelo.pojos;

public class Retro {

	private long id;
	private String titulo;
	private String plataforma;
	private String lanzamiento;
	private String imagen;

	

	public Retro() {
		super();
		this.id = -1;
		this.titulo = "Last Armageddon";
		this.plataforma = "PC";
		this.lanzamiento = "1990";
		this.imagen = "imagen.jpg";

	}

	public Retro(long id, String titulo, String artista, String portada, String year) {
		this();
		this.id = id;
		this.titulo = titulo;
		this.plataforma = artista;
		this.lanzamiento = portada;
		this.imagen = year;
	}

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

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getLanzamiento() {
		return lanzamiento;
	}

	public void setLanzamiento(String lanzamiento) {
		this.lanzamiento = lanzamiento;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Retro [id=" + id + ", titulo=" + titulo + ", plataforma=" + plataforma + ", lanzamiento=" + lanzamiento
				+ ", imagen=" + imagen + "]";
	}
	
	
}
