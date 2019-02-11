package com.ipartek.formacion.tienda.modelo.pojo;

public class Animal {

	private int id;

	private String nombre;

	private String tipo;

	private String dieta;

	private float peso;

	private float precio;

	public Animal() {
		super();
		this.setId(-1);
		this.setNombre("");
		this.setTipo("");
		this.setDieta("");
		this.setPeso(0);
		this.setPrecio(0);
	}

	public Animal(int id, String nombre, String tipo, String dieta, float peso, float precio) {
		this();
		this.setId(id);
		this.setNombre(nombre);
		this.setTipo(tipo);
		this.setDieta(dieta);
		this.setPeso(peso);
		this.setPrecio(precio);
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDieta() {
		return dieta;
	}

	public void setDieta(String dieta) {
		this.dieta = dieta;
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

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", dieta=" + dieta + ", peso=" + peso
				+ ", precio=" + precio + "]";
	}

}
