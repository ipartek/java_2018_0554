package com.ipartek.formacion.modelo.pojos;

public class VideoJuego {
	
	private long id;
	private String nombre;
	private String compania;
	private String imagen;
	
	
	public VideoJuego() {
		super();
		this.id = -1;
		this.nombre = "";
		this.compania = "";
		this.imagen = "";
	}


	public VideoJuego(long id, String nombre, String compania, String imagen) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.compania = compania;
		this.imagen = imagen;
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


	public String getCompania() {
		return compania;
	}


	public void setCompania(String compania) {
		this.compania = compania;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	@Override
	public String toString() {
		return "VideoJuego [id=" + id + ", nombre=" + nombre + ", compania=" + compania + ", imagen=" + imagen + "]";
	}
	
	
	
	

}
