package com.ipartek.formacion.taller.modelo.pojo;

import java.util.ArrayList;

public class Vehiculo {
private int id;
private String numero_bastidor;
private String matricula;

private ArrayList<Persona> personas;
private ArrayList<Modelo> modelo;
private ArrayList<Combustible> conbustible;


public Vehiculo() {
	
	this.id=-1;
	this.numero_bastidor="";
	this.matricula="";
	
	
	
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


public ArrayList<Persona> getPersonas() {
	return personas;
}


public void setPersonas(ArrayList<Persona> personas) {
	this.personas = personas;
}


public ArrayList<Modelo> getModelo() {
	return modelo;
}


public void setModelo(ArrayList<Modelo> modelo) {
	this.modelo = modelo;
}


public ArrayList<Combustible> getConbustible() {
	return conbustible;
}


public void setConbustible(ArrayList<Combustible> conbustible) {
	this.conbustible = conbustible;
}


@Override
public String toString() {
	return "Vehiculo [id=" + id + ", numero_bastidor=" + numero_bastidor + ", matricula=" + matricula + ", personas="
			+ personas + ", modelo=" + modelo + ", conbustible=" + conbustible + "]";
}
}
