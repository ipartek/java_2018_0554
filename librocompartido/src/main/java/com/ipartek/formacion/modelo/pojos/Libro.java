package com.ipartek.formacion.modelo.pojos;

public class Libro {

	private String autor;
	private String texto;
	
	

	public Libro(String autor, String texto) {
		super();
		setAutor(autor);
		setTexto(texto);
		
	}

	public Libro() {
		super();
		this.autor = "";
		this.texto = "";
		
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Libro [autor=" + autor + ", texto=" + texto + "]";
	}

}