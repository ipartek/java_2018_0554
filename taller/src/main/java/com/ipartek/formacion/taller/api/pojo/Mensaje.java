package com.ipartek.formacion.taller.api.pojo;

public class Mensaje {

	private String mensaje;

	public Mensaje() {
		super();
		this.mensaje = "";
	}

	public Mensaje(String mensaje) {
		this();
		setMensaje(mensaje);
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "Mensaje [mensaje=" + mensaje + "]";
	}

}
