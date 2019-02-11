package com.ipartek.formacion.tienda.modelo.pojo;

public class Animal {

	private int id;

	private String nombre;

	private double peso;

	private double precio;

	private TipoAnimal tipoAnimal;

	private Dieta dieta;
	
	public Animal() {
		super();
		this.id = -1;
		this.nombre = "";
		this.peso = -1;
		this.precio = -1;
		this.tipoAnimal = new TipoAnimal();
		this.dieta = new Dieta();
	}
	
	public Animal(int id, String nombre, double peso, double precio, TipoAnimal tipoAnimal, Dieta dieta) {
		this();
		setId(id);
		setNombre(nombre);
		setPeso(peso);
		setPrecio(precio);
		setTipoAnimal(tipoAnimal);
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

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public TipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public Dieta getDieta() {
		return dieta;
	}

	public void setDieta(Dieta dieta) {
		this.dieta = dieta;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nombre=" + nombre + ", peso=" + peso + ", precio=" + precio + ", tipoAnimal="
				+ tipoAnimal + ", dieta=" + dieta + "]";
	}

}
