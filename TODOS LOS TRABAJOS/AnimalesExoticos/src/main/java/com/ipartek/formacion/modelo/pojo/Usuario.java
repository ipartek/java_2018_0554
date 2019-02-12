package com.ipartek.formacion.modelo.pojo;

public class Usuario {
	private long id;
	private String nombre;
	private String apellidos;
	private String dni;
	private String telefono;
	private String email;
	
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.apellidos = "";
		this.dni = "";
		this.telefono = "";
		this.email = "";
	}
	
	public Usuario(long id, String nombre, String apellidos, String dni, String telefono, String email) {
		super();
		setId(id);
		setNombre(nombre);
		setApellidos(apellidos);
		setDni(dni);
		setTelefono(telefono);
		setEmail(email);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", telefono="
				+ telefono + ", email=" + email + "]";
	}
	
}
