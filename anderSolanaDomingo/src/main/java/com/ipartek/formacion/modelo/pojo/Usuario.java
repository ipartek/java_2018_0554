package com.ipartek.formacion.modelo.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Usuario {
	
	private Long id;
	
	// TODO mirar por que no funciona @Email
	
	@NotEmpty
	private String nombre;
	
	@NotNull
	@Size(min=6, max=50)
	private String password;
	
	public Usuario(){
		super();
		this.id = (long) -1;
		this.nombre  = "";
		this.password = "";
	}
	
	public Usuario(Long id, String nombre, String password){
		this();
		setId(id);
		setNombre(nombre);
		setPassword(password);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {		
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", password=" + password + "]";
	}
}

