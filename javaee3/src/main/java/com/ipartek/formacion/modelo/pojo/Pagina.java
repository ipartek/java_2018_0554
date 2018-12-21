package com.ipartek.formacion.modelo.pojo;

public class Pagina {
	
	private String texto;
	private String autor;
	
	public Pagina() {
		super();
		this.autor = "";
		this.texto = "";
	}
	
	public Pagina(String texto, String autor) {
		this();
		this.autor = autor;
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
}
