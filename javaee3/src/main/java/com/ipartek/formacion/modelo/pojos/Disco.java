package com.ipartek.formacion.modelo.pojos;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Disco {

	


	private long id;
	
	@NotEmpty
	@Size(min=5, max=150)
	private String titulo;
	
	@NotEmpty
	@Size(min=5, max=150)
	private String artista;
	
	@NotEmpty
	@Size(min=5, max=150)
	private String portada;
	
	@NotEmpty
	@Size(min=4, max=4)
	private String year;
	
	

	//Constructor
	
	public Disco() {
		super();
		this.id = -1;
		this.titulo = "Dystopia";
		this.artista = "Megadeth";
		this.portada = "PortadaDystopia";
		this.year = "2016";
		
		
			
	}
	
	public Disco(long id, String titulo, String artista, String portada, String year) {
		this();
		this.id = id;
		this.titulo = titulo;
		this.artista = artista;
		this.portada = portada;
		this.year = year;
	}
	//Getters y setters
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



	public String getArtista() {
		return artista;
	}



	public void setArtista(String artista) {
		this.artista = artista;
	}



	public String getPortada() {
		return portada;
	}



	public void setPortada(String portada) {
		this.portada = portada;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}
	

	//To string
	@Override
	public String toString() {
		return "Disco [id=" + id + ", titulo=" + titulo + ", artista=" + artista + ", portada=" + portada + ", year="
				+ year + "]";
	}
	
}