package com.ipartek.formacion.taller.modelo.pojo;

public class Vehiculo {

	private int id;

	private String numero_bastidor;

	private String matricula;

	private String combustible;

	private String modelo;

	public Vehiculo() {
		super();
		this.setId(-1);
		this.setNumero_bastidor("");
		this.setMatricula("");
		this.setCombustible("");
		this.setModelo("");
	}

	public Vehiculo(int id, String numero_bastidor, String matricula, String combustible, String modelo) {
		super();
		this.setId(id);
		this.setNumero_bastidor(numero_bastidor);
		this.setMatricula(matricula);
		this.setCombustible(combustible);
		this.setModelo(modelo);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero_bastidor() {
		return numero_bastidor;
	}

	public void setNumero_bastidor(String numero_bastidor) {
		this.numero_bastidor = numero_bastidor;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", numero_bastidor=" + numero_bastidor + ", matricula=" + matricula
				+ ", combustible=" + combustible + ", modelo=" + modelo + "]";
	}

}
