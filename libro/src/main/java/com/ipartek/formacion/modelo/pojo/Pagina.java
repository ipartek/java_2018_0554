package com.ipartek.formacion.modelo.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Pagina {
	
	@NotEmpty
	@Size(min=2, max=50)
	private String autor;
	
	@NotEmpty
	@Size(min=10, max=55)
	private String texto;
	
	//Constructores
		public Pagina() {
			super();
			this.autor ="";
			this.texto ="";
		}
		

		public Pagina(String autor, String texto) {
			this();
			setAutor(autor);
			setTexto(texto);
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
			return "Pagina [autor=" + autor + ", texto=" + texto + "]";
		}


	
		

}
