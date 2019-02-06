package com.ipartek.formacion.taller.modelo.pojo;

import java.util.ArrayList;

public class Persona {

	private int id;
	private String nombre;
	private String apellidos;
	private int telefono;
	private String dni;
	private ArrayList<Rol> roles;

	public Persona() {
		this.id = -1;
		this.nombre = "";
		this.apellidos = "";
		this.telefono = 0;
		this.dni = "";

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

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public ArrayList<Rol> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<Rol> roles) {
		this.roles = roles;
	}

}
