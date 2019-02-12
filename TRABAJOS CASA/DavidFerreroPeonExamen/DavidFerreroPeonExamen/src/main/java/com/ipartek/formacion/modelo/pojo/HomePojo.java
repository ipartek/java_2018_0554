package com.ipartek.formacion.modelo.pojo;

import java.util.HashMap;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class HomePojo {

	private String raza;

	private String nombre;

	private String imagen;

	private int edad, peso;
	private int chip;

	public HomePojo() {
		super();

		this.nombre = nombre;
		this.raza = raza;
		this.imagen = imagen;
		this.edad = edad;
		this.peso = peso;
		this.chip = chip;

	}

	public HomePojo(String nombre, String raza, String imagen) {
		this();
		setNombre(nombre);
		setRaza(raza);
		setImagen(imagen);

	}
	public HomePojo(String nombre, String raza, int chip) {
		this();
		setNombre(nombre);
		setRaza(raza);
		setChip(chip);

	}

	public HomePojo(String nombre, String raza, String imagen, int edad, int peso, int chip) {
		this();
		setNombre(nombre);
		setRaza(raza);
		setImagen(imagen);
		setEdad(edad);
		setPeso(peso);
		setChip(chip);

	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getChip() {
		return chip;
	}

	public void setChip(int chip) {
		this.chip = chip;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Pagina [ nombre=" + nombre + ", raza=" + raza + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((raza == null) ? 0 : raza.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HomePojo other = (HomePojo) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (raza == null) {
			if (other.raza != null)
				return false;
		} else if (!raza.equals(other.raza))
			return false;

		return true;
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

}
