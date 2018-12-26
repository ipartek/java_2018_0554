package com.ipartek.formacion.modelo.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Pagina {
	
	private Long id; 
	
	@NotEmpty
	@Size(min=2, max=50)
	private String autor;
	
	@NotEmpty
	@Size(min=50, max=255)
	private String texto;
	
	public Pagina() {
		super();
	}

	
	public Pagina(Long id, String autor, String texto) {
		this();
		setId(id);
		setAutor(autor);
		setTexto(texto);
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
}
