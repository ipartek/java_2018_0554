package com.ipartek.formacion.cervezas.modelo.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Cerveza {

	private int id;

	@NotEmpty
	@Size(min = 1, max = 45)
	private String nombre;
	
	@NotNull
	private float precio;

	// @Valid 
	private Tipo tipo;

	public Cerveza() {
		super();
		this.id = -1;
		this.nombre = "";
		this.precio = 0;
		this.tipo = new Tipo();
	}

	public Cerveza(int id, String nombre, float precio,  Tipo tipo) {
		this();
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setTipo(tipo);
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}	

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Cerveza [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ",  tipo=" + tipo + "]";
	}



	

}
