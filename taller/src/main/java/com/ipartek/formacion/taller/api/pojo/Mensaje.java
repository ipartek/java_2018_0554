package com.ipartek.formacion.taller.api.pojo;

public class Mensaje {

	private String mensaje;
	
	public Mensaje() {
		super();
		this.mensaje = mensaje;
	}
	
	public Mensaje(String mensaje) {
		this();
		setMensaje(mensaje);
	}


	@Override
	public String toString() {
		return "Mensaje [mensaje=" + mensaje + "]";
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	
	
	
}
