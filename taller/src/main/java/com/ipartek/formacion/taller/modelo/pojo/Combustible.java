package com.ipartek.formacion.taller.modelo.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Combustible {

	private int id;
	
	@NotEmpty
	@Size(min=1, max=45)
	private String nombreC;
	
	public Combustible() {
		super();
		this.id=-1;
		this.nombreC="";
	}
	
	public Combustible(int id, String nombreC) {
		this();
		setId(id);
		setNombreC(nombreC);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreC() {
		return nombreC;
	}
	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
	}
	
	
}
