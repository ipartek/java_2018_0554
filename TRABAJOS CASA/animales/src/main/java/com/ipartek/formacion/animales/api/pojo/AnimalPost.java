package com.ipartek.formacion.animales.api.pojo;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class AnimalPost {

	@NotEmpty
	@Size(min = 1, max = 45)
	private String nombre;

	@NotNull
	private float peso;

	@NotNull
	private float precio;

	@NotNull
	private boolean listoVenta;
	
	@NotEmpty
	private int idTipo;

	@NotEmpty
	private int idDieta;

	public AnimalPost() {
		super();

		this.nombre = "";
		this.peso = 0;
		this.precio = 0;
		this.listoVenta = false;
		this.idDieta = -1;
		this.idTipo = -1;

	}

	public AnimalPost(String nombre, float peso, float precio, boolean listoVenta, int idTipo, int idDieta) {
		super();
		setNombre(nombre);
		setPeso(peso);
		setPrecio(precio);
		setListoVenta(listoVenta);
		setIdDieta(idDieta);
		setIdTipo(idTipo);

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
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

	public int getIdDieta() {
		return idDieta;
	}

	public void setIdDieta(int idDieta) {
		this.idDieta = idDieta;
	}

	public boolean isListoVenta() {
		return listoVenta;
	}

	public void setListoVenta(boolean listoVenta) {
		this.listoVenta = listoVenta;
	}

	@Override
	public String toString() {
		return "AnimalPost [nombre=" + nombre + ", peso=" + peso + ", precio=" + precio + ", listoVenta=" + listoVenta
				+ ", idTipo=" + idTipo + ", idDieta=" + idDieta + "]";
	}

}
