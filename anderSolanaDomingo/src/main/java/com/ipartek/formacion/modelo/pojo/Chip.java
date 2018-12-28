package com.ipartek.formacion.modelo.pojo;

public class Chip {
	
	private Long id;
	private String latitud;
	private String longitud;
	
	public Chip() {
		super();
		this.id = (long) -1;
		this.latitud  = "";
		this.longitud = "";
	}
	
	public Chip(Long id, String latitud, String longitud) {
		this();
		setId(id);
		setLatitud(latitud);
		setLongitud(longitud);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	public String toString() {
		return "Chip [id=" + id + ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}
	
}
