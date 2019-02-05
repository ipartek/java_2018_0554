package com.ipartek.formacion.taller.modelo.pojo;

public class Rol {
	private int id;
	private String nombre;
	
	public Rol(){
		super();
	this.id	=-1;
	this.nombre="";
	}

	public Rol(int id, String nombre) {
	this();
	this.setId(id);
	this.setNombre(nombre);
		
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	
	
	
}
