package com.ipartek.formacion.taller.modelo.pojo;

import java.util.ArrayList;

public class Persona {

	private int id;

	private String nombre;

	private String apellidos;

	private String dni;

	private String telefono;

	private ArrayList<Rol> roles;
	
	
	public Persona() {
		super();
			this.id=-1;
			this.nombre="";
			this.apellidos="";
			this.dni="";
			this.telefono="";
			this.roles = new ArrayList<Rol>();
	}
	

	public Persona(int id, String nombre, String apellidos, String dni, String telefono, ArrayList<Rol> roles) {
		this();
			setId(id);
			setNombre(nombre);
			setApellidos(apellidos);
			setDni(dni);
			setTelefono(telefono);
			setRoles(roles);
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

	public ArrayList<Rol> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<Rol> roles) {
		this.roles = roles;
	}

}
