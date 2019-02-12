package com.ipartek.formacion.cervezas.api.pojo;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class CervezaPost {



	@NotEmpty
	@Size(min = 1, max = 45)
	private String nombre;
	
	@NotEmpty
	private int idTipo;

	@NotNull
	private float precio;

	

	public CervezaPost() {
		super();

		this.nombre = "";
		this.idTipo =-1;
		this.precio = 0;
		
	}

	public CervezaPost( String nombre,  int idTipo, float precio) {
		this();

		setNombre(nombre);
		setPrecio(precio);
		setIdTipo(idTipo);
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

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	@Override
	public String toString() {
		return "CervezaPost  [ nombre=" + nombre + ", idTipo=" + idTipo + ", precio=" + precio + "]";
	}	



	

}
