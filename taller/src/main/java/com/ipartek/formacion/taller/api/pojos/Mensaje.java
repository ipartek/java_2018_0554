package com.ipartek.formacion.taller.api.pojos;

public class Mensaje {

	private String mensaje;

	public Mensaje() {
		super();
		this.mensaje = "";
	}

	public Mensaje(String mensaje) {
		this();
		this.setMensaje(mensaje);
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
