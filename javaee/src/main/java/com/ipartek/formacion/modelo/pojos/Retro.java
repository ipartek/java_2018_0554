package com.ipartek.formacion.modelo.pojos;

public class Retro {
	int id;
	String titulo;
	String plataforma;
	int decada;
	String desarollador;
	String imagen;
	
	
	public Retro(int id, String titulo, String plataforma, int decada, String desarollador, String imagen) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.plataforma = plataforma;
		this.decada = decada;
		this.desarollador = desarollador;
		this.imagen = imagen;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
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


	public int getDecada() {
		return decada;
	}


	public void setDecada(int decada) {
		this.decada = decada;
	}


	public String getDesarollador() {
		return desarollador;
	}


	public void setDesarollador(String desarollador) {
		this.desarollador = desarollador;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	@Override
	public String toString() {
		return "Retro [id=" + id + ", titulo=" + titulo + ", plataforma=" + plataforma + ", decada=" + decada
				+ ", desarollador=" + desarollador + ", imagen=" + imagen + "]";
	}

}
