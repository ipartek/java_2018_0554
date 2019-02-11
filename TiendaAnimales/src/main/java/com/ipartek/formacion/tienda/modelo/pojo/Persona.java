package com.ipartek.formacion.tienda.modelo.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Persona {
	private int id;
	@NotEmpty
	@Size(min = 1, max = 100)
	private String nombre;
	@NotEmpty
	@Size(min = 1, max = 100)
	private String apellidos;
	@NotEmpty
	@Size(min = 9, max = 10)
	private String dni;
	@NotEmpty
	@Size(min = 10, max = 15)
	private String telefono;

	private String email;

	public Persona() {
		super();
		this.id = -1;
		this.nombre = "";
		this.apellidos = "";
		this.dni = "";
		this.telefono = "";
		this.email = "";
	}

	public Persona(int id, String nombre, String apellidos, String dni, String telefono, String email) {
		this();
		this.setId(id);
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setDni(dni);
		this.setTelefono(telefono);
		this.setEmail(email);
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", telefono="
				+ telefono + "]";
	}

}
