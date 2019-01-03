package com.ipartek.formacion.modelo.pojos;

public class Perro {
	// atributos
	private long id;
	private String nombre;
	private String raza;
	private long chip;

	// constructores
	public Perro() {
		super();
		this.id = -1;
		this.nombre = "";
		this.raza = "";
		this.chip = -1;
	}

	public Perro(long id, String nombre, String raza, long chip) {
		this();
		setId(id);
		setNombre(nombre);
		setRaza(raza);
		setChip(chip);

	}

	// getter && setter
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public long getChip() {
		return chip;
	}

	public void setChip(long chip) {
		this.chip = chip;
	}

	// otros metodos
	@Override
	public String toString() {
		return "Perro [id=" + id + ", nombre=" + nombre + ", raza=" + raza + ", chip=" + chip + "]";
	}

}
