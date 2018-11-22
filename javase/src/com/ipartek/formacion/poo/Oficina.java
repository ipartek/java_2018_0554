package com.ipartek.formacion.poo;

import java.util.ArrayList;

public class Oficina {
	private String nombre;
	
	private ArrayList<Usuario> usuarios = new ArrayList<>();

	public Oficina(String nombre) {
		setNombre(nombre);
	}
	
	public void nuevoUsuario(Usuario usuario) {
		if(usuario == null) {
			throw new RuntimeException("No se admite el valor null para añadir un nuevo usuario");
		}
		
		usuarios.add(usuario);
	}
	
	public void eliminarUsuario(Usuario usuario) {
		if(usuario == null) {
			throw new RuntimeException("No se admite el valor null para añadir un nuevo usuario");
		}
		
		usuarios.remove(usuario);
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
