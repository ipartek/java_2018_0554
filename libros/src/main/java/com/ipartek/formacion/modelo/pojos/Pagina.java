package com.ipartek.formacion.modelo.pojos;

public class Pagina {
	private Long id;
	private String autor;
	private String texto;
	
	public Pagina() {
		super();
		this.id = 1L;
		this.autor = "Jorge Cervantes";
		this.texto = "lalalalaalalalalalal";
	}

	public Pagina(Long id, String autor, String texto) {
		super();
		this.id = id;
		this.autor = autor;
		this.texto = texto;
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "Pagina [id=" + id + ", autor=" + autor + ", texto=" + texto + "]";
	}
}
