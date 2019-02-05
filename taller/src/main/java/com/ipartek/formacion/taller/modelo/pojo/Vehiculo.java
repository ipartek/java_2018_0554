package com.ipartek.formacion.taller.modelo.pojo;

public class Vehiculo {

	private int id;

	private String matricula;

	public Vehiculo() {
		super();
		this.id = -1;
		this.matricula = "";

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", matricula=" + matricula + "]";
	}

}
