package com.ipartek.formacion.modelo.pojo;

public class Mensaje {
	public static final String TIPO_PRIMARY ="primary";
	public static final String TIPO_SUCCESS ="success";
	public static final String TIPO_DANGER ="danger";
	public static final String TIPO_WARNING ="warning";
	
	private String texto;
	private String tipo;
	
	public Mensaje() {
		super();
;
	}
	
	public Mensaje(String tipo,String texto) {
		this();
		setTexto(texto);
		setTipo(tipo);
		
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensaje other = (Mensaje) obj;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mensaje [texto=" + texto + ", tipo=" + tipo + "]";
	}
	
	
}