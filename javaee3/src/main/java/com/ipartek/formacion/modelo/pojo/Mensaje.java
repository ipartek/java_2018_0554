package com.ipartek.formacion.modelo.pojo;

public class Mensaje {

	private String alerta;
	private String tipo;

	public Mensaje() {
		super();
		alerta = "";
		tipo = "success";
	}

	public Mensaje(String alerta, String tipo) {
		this();
		setAlerta(alerta);
		setTipo(tipo);
	}

	public String getAlerta() {
		return alerta;
	}

	public void setAlerta(String alerta) {
		this.alerta = alerta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Mensaje [alerta=" + alerta + ", tipo=" + tipo + "]";
	}

}
