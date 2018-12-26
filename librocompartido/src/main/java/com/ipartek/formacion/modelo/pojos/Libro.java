package com.ipartek.formacion.modelo.pojos;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Libro {
	@NotEmpty
	@Size(min=50, max=255)
	private String texto;
	
	@NotEmpty
	@Size(min=2, max=50)
	private String autor;
	private String placeholder;

	public Libro(String autor, String texto) {
		setAutor(autor);
		setTexto(texto);
	}

	public Libro(String autor) {
		setAutor("Anónimo");
	}
	
	public Libro() {
		setAutor("Anónimo");
		setTexto("");
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
		if("".equals(texto)) {
			setPlaceholder("Aquí se escribirá la página de tu libro. Dale a editar para escribirla. Si no ves el enlace para editarla inicia sesión");
		}
		else {
			this.texto = texto;
		}
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	
	public String getPlaceholder() {
		return placeholder;
	}

	@Override
	public String toString() {
		return "Libro [autor=" + autor + ", texto="
				+ texto + "]";
	}
}