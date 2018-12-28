package com.ipartek.formacion.modelo.pojo;

public class Chip {
	Long id;
	String anyo;
	
	public Chip() {
		super();
		this.id = (long)-1;
		this.anyo ="";
	
	}

	public Chip(Long id, String anyo) {
		this();
		setId(id);
		setAnyo(anyo);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnyo() {
		return anyo;
	}

	public void setAnyo(String anyo) {
		this.anyo = anyo;
	}
	
	@Override
	public String toString() {
		return "Chip [id=" + id + ", anyo=" + anyo + "]";
	}
}
