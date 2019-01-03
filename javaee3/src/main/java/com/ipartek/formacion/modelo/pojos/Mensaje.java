package com.ipartek.formacion.modelo.pojos;

public class Mensaje {
	public static final String MENSAJE_SUCCESS = "success";
	public static final String MENSAJE_INFO = "info";
	public static final String MENSAJE_WARNING = "warning";
	public static final String MENSAJE_DANGER = "danger";
	
	String tipo;
	String texto;
	
	public Mensaje(String tipo, String texto) {
		setTipo(tipo);
		setTexto(texto);
	}
	
	public Mensaje() {}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	@Override
	public String toString() {
		return "Mensaje [tipo=" + tipo + ", texto=" + texto + "]";
	}
}
