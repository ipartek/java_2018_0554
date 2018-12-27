package com.ipartek.formacion.modelo.pojo;

public class Gato {
	
	private Long id;
	private String raza; 
	private String color;
	private String nombre;
	private Double peso;
	private String imagen;
	
	public Gato() {
		super();
		this.id = (long) -1;
		this.raza = "";
		this.color = "";
		this.nombre = "";
		this.peso = 0.0;
		this.imagen = "";
	}
	
	

	public Gato(Long id, String raza, String color, String nombre, Double peso, String imagen) {
		this();
		setId(id);
		setRaza(raza);
		setColor(color);
		setNombre(nombre);
		setPeso(peso);
		setImagen(imagen);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}



	@Override
	public String toString() {
		return "Gato [id=" + id + ", raza=" + raza + ", color=" + color + ", nombre=" + nombre + ", peso=" + peso
				+ ", imagen=" + imagen + "]";
	}

	
}
