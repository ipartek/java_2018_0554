package com.ipartek.formacion.modelos.pojos;

public class Pagina {
	private int id;
	private String autor;
	private String contenido;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Pagina(int id, String autor, String contenido) {
		this();
		setId(id);
		setAutor(autor);
		setContenido(contenido);
	}

	public Pagina() {
		super();
	}

	@Override
	public String toString() {
		return "Pagina [id=" + id + ", autor=" + autor + ", contenido=" + contenido + "]";
	}

}
