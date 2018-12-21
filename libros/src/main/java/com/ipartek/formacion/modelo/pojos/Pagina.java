package com.ipartek.formacion.modelo.pojos;

public class Pagina {

	private String autor;
	private String texto;
	
	public Pagina() {
		super();
		this.autor = "Jorge Cervantes";
		this.texto = "lalalalaalalalalalal";
	}

	public Pagina(String autor, String texto) {
		super();
		this.autor = autor;
		this.texto = texto;
		// TODO Auto-generated constructor stub
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
		return "Pagina [ autor=" + autor + ", texto=" + texto + "]";
	}
}
