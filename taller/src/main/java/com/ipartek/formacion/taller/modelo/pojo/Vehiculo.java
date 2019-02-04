package com.ipartek.formacion.taller.modelo.pojo;

import java.util.ArrayList;

public class Vehiculo {
	
	private int id;
	private String numero_bastidor;
	private String matricula;
	
	private ArrayList<Modelo> modelos;
	private ArrayList<Persona> personas;
	private ArrayList<Combustible> combustibles;
	
	
	public Vehiculo() {
		super();
		this.id = -1;
		this.numero_bastidor = "";
		this.matricula = "";
		this.modelos = new ArrayList<Modelo>();;
		this.personas = new ArrayList<Persona>();;
		this.combustibles = new ArrayList<Combustible>();;
		
	}


	public Vehiculo(int id, String numero_bastidor, String matricula, ArrayList<Modelo> modelos,
			ArrayList<Persona> personas, ArrayList<Combustible> combustibles) {
		this();
		this.id = id;
		this.numero_bastidor = numero_bastidor;
		this.matricula = matricula;
		this.modelos = modelos;
		this.personas = personas;
		this.combustibles = combustibles;
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


	public ArrayList<Modelo> getModelos() {
		return modelos;
	}


	public void setModelos(ArrayList<Modelo> modelos) {
		this.modelos = modelos;
	}


	public ArrayList<Persona> getPersonas() {
		return personas;
	}


	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}


	public ArrayList<Combustible> getCombustibles() {
		return combustibles;
	}


	public void setCombustibles(ArrayList<Combustible> combustibles) {
		this.combustibles = combustibles;
	}


	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", numero_bastidor=" + numero_bastidor + ", matricula=" + matricula + ", modelos="
				+ modelos + ", personas=" + personas + ", combustibles=" + combustibles + "]";
	}
	
	

}
