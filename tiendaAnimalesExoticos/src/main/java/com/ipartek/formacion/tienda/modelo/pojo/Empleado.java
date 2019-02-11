package com.ipartek.formacion.tienda.modelo.pojo;

public class Empleado {

	private int id;
	private String nombre;
	private String apellidos;
	private String dni;
	private String telefono;
	private String email;
	private Rol puesto;

	public Empleado() {
		super();

		this.id = -1;
		this.nombre = "";
		this.apellidos = "";
		this.dni = "";
		this.telefono = "";
		this.email = "";
		this.puesto = new Rol();
	}

	public Empleado(int id, String nombre, String apellidos, String dni, String telefono, String email, Rol puesto) {
		this();
		setId(id);
		setNombre(nombre);
		setApellidos(apellidos);
		setDni(dni);
		setTelefono(telefono);
		setEmail(email);
		setPuesto(puesto);
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

	public Rol getPuesto() {
		return puesto;
	}

	public void setPuesto(Rol puesto) {
		this.puesto = puesto;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", telefono="
				+ telefono + ", email=" + email + ", puesto=" + puesto + "]";
	}

}
