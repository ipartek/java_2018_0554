package com.ipartek.formacion.tienda.modelo.pojo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Venta {

	private int id;

	@NotNull
	@Valid
	private Persona persona;

	@NotNull
	@Valid
	private Animal animal;

	public Venta() {
		super();
		this.setId(-1);
		this.setPersona(null);
		this.setAnimal(null);
	}

	public Venta(int id, Persona persona, Animal animal) {
		this();
		this.setId(id);
		this.setPersona(persona);
		this.setAnimal(animal);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", persona=" + persona + ", animal=" + animal + "]";
	}

}
