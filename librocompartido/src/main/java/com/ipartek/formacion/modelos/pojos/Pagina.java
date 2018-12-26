package com.ipartek.formacion.modelos.pojos;

import org.hibernate.validator.constraints.NotEmpty;

public class Pagina {
	
	@NotEmpty
	private String autor;
	
	@NotEmpty
	private String contenido;

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

	public Pagina(String autor, String contenido) {
		this();
		setAutor(autor);
		setContenido(contenido);
	}

	public Pagina() {
		super();
	}

	@Override
	public String toString() {
		return "Pagina [autor=" + autor + ", contenido=" + contenido + "]";
	}

}
