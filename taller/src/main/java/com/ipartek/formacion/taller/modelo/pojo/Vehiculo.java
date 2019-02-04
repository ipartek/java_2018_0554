package com.ipartek.formacion.taller.modelo.pojo;

public class Vehiculo {

	private int id;

	private String matricula;
	
	private String bastidor;
	
	private String combustible;
	
	private String modelo;

	public Vehiculo() {
		super();
		this.id = -1;
		this.matricula = "";
		this.combustible="";
		this.modelo="";
		this.bastidor="";
	}

	public String getBastidor() {
		return bastidor;
	}

	public void setBastidor(String bastidor) {
		this.bastidor = bastidor;
	}

	public String getCombustible() {
		return combustible;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
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
		return "Vehiculo [id=" + id + ", matricula=" + matricula + ", bastidor=" + bastidor + ", combustible="
				+ combustible + ", modelo=" + modelo + "]";
	}

}
