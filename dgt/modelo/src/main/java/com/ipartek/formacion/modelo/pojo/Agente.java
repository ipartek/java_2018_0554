package com.ipartek.formacion.modelo.pojo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class Agente {
	private Long id;
	private String nombre;
	@NotEmpty(message = "No puede estar vacio")
	@Pattern(regexp = "\\d{6}", message = "Introduzca 6 numeros")
	private String placa;
	@NotEmpty(message = "No puede estar vacio")
	private String password;
	
	public Agente(Long id, String nombre, String placa, String password) {
		this();
		setId(id);
		setNombre(nombre);
		setPlaca(placa);
		setPassword(password);
		
	}

	

	public Agente() {
		super();
		this.id = -1l;
		this.nombre = "";
		this.placa = "";
		this.password = "";
		
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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	@Override
	public String toString() {
		return "Agente [id=" + id + ", nombre=" + nombre + ", placa=" + placa + ", password=" + password + "]";
	}

	
}