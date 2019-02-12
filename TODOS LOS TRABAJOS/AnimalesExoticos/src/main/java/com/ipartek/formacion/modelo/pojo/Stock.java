package com.ipartek.formacion.modelo.pojo;

public class Stock {
	private long id;
	private Animal animal;
	private float peso;
	
	public Stock() {
		this.id = -1;
		this.animal = new Animal();
		this.peso = 0;
	}
	
	public Stock(long id, Animal animal, float peso) {
		super();
		setId(id);
		setAnimal(animal);
		setPeso(peso);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", animal=" + animal + ", peso=" + peso + "]";
	}
	
	
}
