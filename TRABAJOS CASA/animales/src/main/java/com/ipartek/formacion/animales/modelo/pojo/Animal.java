package com.ipartek.formacion.animales.modelo.pojo;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Animal {

	private int id;

	@NotEmpty
	@Size(min = 1, max = 45)
	private String nombre;

	@NotNull
	private float peso;

	@NotNull
	private float precio;

	//@NotNull
	private Date fecha;
	
	//@NotNull
	private boolean listoVenta;


	// @Valid
	private Tipo tipo;

	// @Valid
	private Dieta dieta;

	public Animal() {
		super();
		this.id = -1;
		this.nombre = "";
		this.peso = 0;
		this.precio = 0;
		this.fecha = null;
		this.listoVenta = false;
		this.tipo = new Tipo();
		this.dieta = new Dieta();
	}

	public Animal(int id, String nombre, float peso, float precio, Date fecha, boolean listoVenta, Tipo tipo, Dieta dieta) {
		this();
		setId(id);
		setNombre(nombre);
		setPeso(peso);
		setPrecio(precio);
		setFecha(fecha);
		setListoVenta(listoVenta);
		setTipo(tipo);
		setDieta(dieta);

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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Dieta getDieta() {
		return dieta;
	}

	public void setDieta(Dieta dieta) {
		this.dieta = dieta;
	}

	public boolean isListoVenta() {
		return listoVenta;
	}

	public void setListoVenta(boolean listoVenta) {
		this.listoVenta = listoVenta;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nombre=" + nombre + ", peso=" + peso + ", precio=" + precio + ", fecha=" + fecha
				+ ", listoVenta=" + listoVenta + ", tipo=" + tipo + ", dieta=" + dieta + "]";
	}


}
