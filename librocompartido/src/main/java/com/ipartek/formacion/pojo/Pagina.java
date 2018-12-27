package com.ipartek.formacion.pojo;

public class Pagina {

	private String autor;
	private String texto;
	
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
