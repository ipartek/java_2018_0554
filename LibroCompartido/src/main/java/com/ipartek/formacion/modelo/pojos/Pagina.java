package com.ipartek.formacion.modelo.pojos;

public class Pagina {

	String autor;
	int pagActual;
	int totalPag;
	String texto;

	public Pagina(String autor, int pagActual, int totalPag, String texto) {
		super();
		this.autor = autor;
		this.pagActual = pagActual;
		this.totalPag = totalPag;
		this.texto = texto;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPagActual() {
		return pagActual;
	}

	public void setPagActual(int pagActual) {
		this.pagActual = pagActual;
	}

	public int getTotalPag() {
		return totalPag;
	}

	public void setTotalPag(int totalPag) {
		this.totalPag = totalPag;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Pagina [autor=" + autor + ", pagActual=" + pagActual + ", totalPag=" + totalPag + ", texto=" + texto
				+ "]";
	}

}
