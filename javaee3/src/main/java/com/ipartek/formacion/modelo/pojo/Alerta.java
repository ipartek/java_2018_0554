package com.ipartek.formacion.modelo.pojo;

public class Alerta {
	public static final String OK = "success";
	public static final String KO = "danger";
	
	private String mensaje;
	private String tipo;
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	public Alerta() {
		super();
		this.mensaje=mensaje;
		this.tipo=tipo;
	}
	public Alerta(String mensaje, String tipo) {
		this();
		setMensaje(mensaje);
		setTipo(tipo);
	}
	@Override
	public String toString() {
		return "Alerta [mensaje=" + mensaje + ", tipo=" + tipo + "]";
	}
	
	

}
