package com.ipartek.formacion.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Pagina {

	@NotEmpty
	@Size(min=50, max=255)
	private String texto;
	
	@NotEmpty
	@Size(min=2, max=50)
	private String autor;
	
//CONSTRUCTOR
	public Pagina()  {
		super();
		this.autor = "Cervantes";
		this.texto = "En un lugar de la Mancha...";
	}
		
	public Pagina(String autor, String texto) {
		this();
		setAutor(autor);
		setTexto(texto);
	}




//GET Y SET
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
///

	@Override
	public String toString() {
		return "Pagina [autor=" + autor + ", texto=" + texto + "]";
	}
	
}
