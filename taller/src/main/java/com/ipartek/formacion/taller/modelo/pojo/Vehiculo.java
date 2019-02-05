package com.ipartek.formacion.taller.modelo.pojo;

public class Vehiculo {

	private int id;

	private String numero_bastidor;

	private String matricula;

	private String combustible;

	private String modelo;

	public Vehiculo() {
		super();
		this.id = -1;
		this.numero_bastidor = "";
		this.matricula = "";
		this.combustible = "";
		this.modelo = "";
	}

	public Vehiculo(int id, String numero_bastidor, String matricula, String combustible, String modelo) {
		this();
		setId(id);
		setNumero_bastidor(numero_bastidor);
		setMatricula(matricula);
		setCombustible(combustible);
		setModelo(modelo);
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

}
