package com.ipartek.formacion.modelo.pojo;

public class Alerta {
	
	public static final String TIPO_PRIMARY = "primary";
	public static final String TIPO_SUCCESS = "success";
	public static final String TIPO_DANGER = "danger";
	public static final String TIPO_WARNING = "warning";
	
	private String texto;
	private String tipo;
	
	public Alerta() {
		super();
		this.texto = "Error Inexperado";
		this.tipo = TIPO_DANGER;
	}

	public Alerta(String tipo, String texto) {
		this();
		this.texto = texto;
		this.tipo = tipo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Alerta [texto=" + texto + ", tipo=" + tipo + "]";
	}
	
}
