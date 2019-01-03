package com.ipartek.formacion.modelo.pojos;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Pagina {
	
	@NotEmpty
	@Size(min=50, max=255)
	private String texto;
	
	@NotEmpty
	@Size(min=2, max=50)
	private String autor;
	
	
	public Pagina() {
		super();
		this.texto = " ";
		this.autor = " ";
		
	}
	
	public Pagina(String texto, String autor) {
		this();
		setTexto(texto);
		setAutor(autor);
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
	
	@Override
	public String toString() {
		return "Pagina [texto=" + texto + ", autor=" + autor + "]";
	}
	
	
	
}
