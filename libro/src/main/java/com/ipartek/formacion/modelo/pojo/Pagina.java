package com.ipartek.formacion.modelo.pojo;

public class Pagina {
	
	private Long id;
	private String autor;
	private String texto;
	
	//Constructores
		public Pagina() {
			super();
			this.id = (long) -1;
			this.autor ="";
			this.texto ="";
		}
		

		public Pagina(Long id,String autor, String texto) {
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


		@Override
		public String toString() {
			return "Pagina [id=" + id + ", autor=" + autor + ", texto=" + texto + "]";
		}
		

}
