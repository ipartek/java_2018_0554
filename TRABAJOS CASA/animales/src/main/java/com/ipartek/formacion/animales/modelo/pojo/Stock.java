package com.ipartek.formacion.animales.modelo.pojo;

import org.hibernate.validator.constraints.NotEmpty;

public class Stock {

	private int id;

	@NotEmpty
	private int unidades;
	
	@NotEmpty
	private int idAnimal;

	public Stock() {
		super();
		this.id = -1;
		this.unidades = -1;;
		this.idAnimal = -1;;
	}

	public Stock(int id, int unidades, int idAnimal) {
		this();
		this.setId(id);
		this.setUnidades(unidades);
		this.setIdAnimal(idAnimal);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public int getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", unidades=" + unidades + ", idAnimal=" + idAnimal + "]";
	}


}