package com.ipartek.formacion.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Usuario {
	
	@NotEmpty
	@Size(min = 1, max = 45)
	private String nombre;
	
	@NotEmpty
	@Size(min = 6, max = 20)
	private String pass;
	private long id;
	
	public Usuario() {
		super();
		this.nombre ="desconocido";
		this.pass = "desconocido";
		this.id = -1;
	}

	public Usuario(long id, String nombre, String pass) {
		this();
		this.nombre = nombre;
		this.pass = pass;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", pass=" + pass + ", id=" + id + "]";
	}

}
