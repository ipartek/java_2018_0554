package com.ipartek.formacion.tienda.modelo.pojo;

public class Stock {
	private int id;

	private String vendido;

	private boolean preparado;

	private Animal animalComprado;
	
	public Stock() {
		super();
		this.id = -1;
		this.vendido = "";
		this.preparado = false;
		this.animalComprado = new Animal();
	}
	
	public Stock(int id, String vendido, boolean preparado, Animal animalComprado) {
		super();
		setId(id);
		setVendido(vendido);
		setPreparado(preparado);
		setAnimalComprado(animalComprado);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVendido() {
		return vendido;
	}

	public void setVendido(String vendido) {
		this.vendido = vendido;
	}

	public boolean isPreparado() {
		return preparado;
	}

	public void setPreparado(boolean preparado) {
		this.preparado = preparado;
	}

	public Animal getAnimalComprado() {
		return animalComprado;
	}

	public void setAnimalComprado(Animal animalComprado) {
		this.animalComprado = animalComprado;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", vendido=" + vendido + ", preparado=" + preparado + ", animalComprado="
				+ animalComprado + "]";
	}

}
