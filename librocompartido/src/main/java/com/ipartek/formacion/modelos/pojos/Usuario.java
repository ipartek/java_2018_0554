package com.ipartek.formacion.modelos.pojos;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Usuario {
	private Integer id;

	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@Size(min = 8, max = 25)
	private String password;
	
	@NotEmpty
	private String nombre;

	public Usuario(String email, String password,String nombre) {
		setId(-1);
		setEmail(email);
		setPassword(password);
		setNombre(nombre);
	}

	public Usuario(int id, String email, String password, String nombre) {
		setId(id);
		setEmail(email);
		setPassword(password);
		setNombre(nombre);
	}

	public Usuario() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", password=" + password +", nombre=" + nombre + "]";
	}
}
