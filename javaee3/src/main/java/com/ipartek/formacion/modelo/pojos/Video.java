package com.ipartek.formacion.modelo.pojos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Video {

	// Atributos
	private long id; // (PK) Not Null, AI
	@NotNull
	@Size(min=1, max=150)
	private String nombre; // Not Null
	@NotNull
	@Size(min=11, max=11)
	private String codigo; // Not Null, Unique

	// Constructores

	public Video() {
		super();
		setId(-1);
		setNombre(nombre);
		setCodigo(codigo);
	}
	
	// Getters y Setters

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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String url) {
		this.codigo = url;
	}

	// Otros metodos => toString

	@Override
	public String toString() {
		return "Video [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + "]";
	}

}
