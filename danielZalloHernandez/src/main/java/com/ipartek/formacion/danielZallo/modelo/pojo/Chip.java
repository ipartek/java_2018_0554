package com.ipartek.formacion.danielZallo.modelo.pojo;

public class Chip {
	private String num_identifiacion;
	private String latitud;
	private String longitud;
	
	public Chip() {
		super();
	}
	
	public Chip(String num_identifiacion, String latitud, String longitud) {
		this();
		setNum_identifiacion(num_identifiacion);
		setLatitud(latitud);
		setLongitud(longitud);
	}


	public String getNum_identifiacion() {
		return num_identifiacion;
	}
	public void setNum_identifiacion(String num_identifiacion) {
		this.num_identifiacion = num_identifiacion;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((latitud == null) ? 0 : latitud.hashCode());
		result = prime * result + ((longitud == null) ? 0 : longitud.hashCode());
		result = prime * result + ((num_identifiacion == null) ? 0 : num_identifiacion.hashCode());
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
		Chip other = (Chip) obj;
		if (latitud == null) {
			if (other.latitud != null)
				return false;
		} else if (!latitud.equals(other.latitud))
			return false;
		if (longitud == null) {
			if (other.longitud != null)
				return false;
		} else if (!longitud.equals(other.longitud))
			return false;
		if (num_identifiacion == null) {
			if (other.num_identifiacion != null)
				return false;
		} else if (!num_identifiacion.equals(other.num_identifiacion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Chip [num_identifiacion=" + num_identifiacion + ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}
	
	
	
	
}
