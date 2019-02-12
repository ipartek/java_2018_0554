package com.ipartek.formacion.animales.modelo.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Empleado {

	private int id;

	@NotEmpty
	@Size(min = 1, max = 45)
	private String nombre;

	@NotEmpty
	@Size(min = 1, max = 145)
	private String apellidos;

	@NotEmpty
	@Size(min = 1, max = 10)
	private String dni;

	@NotEmpty
	@Size(min = 1, max = 10)
	private String telefono;

	@NotEmpty
	@Size(min = 1, max = 145)
	private String email;

	@NotNull
	private int idDepartamento;

	public Empleado() {
		super();
		this.id = -1;
		this.nombre = "";
		this.apellidos = "";
		this.dni = "";
		this.telefono = "";
		this.email = "";
		this.idDepartamento = -1;
	}

	public Empleado(int id, String nombre, String apellidos, String dni, String telefono, String email,
			String idDepartamento) {
		this();
		this.setId(id);
		this.setNombre(nombre);
		this.setNombre(apellidos);
		this.setNombre(dni);
		this.setNombre(telefono);
		this.setNombre(idDepartamento);

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

	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", telefono="
				+ telefono + ", email=" + email + ", idDepartamento=" + idDepartamento + "]";
	}

}
