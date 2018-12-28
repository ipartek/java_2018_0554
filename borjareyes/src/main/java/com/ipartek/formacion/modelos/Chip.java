package com.ipartek.formacion.modelos;

public class Chip {
	private String numero;
private String ubicacion;
public String getNumero() {
	return numero;
}
public void setNumero(String numero) {
	this.numero = numero;
}
public String getUbicacion() {
	return ubicacion;
}
public void setUbicacion(String ubicacion) {
	this.ubicacion = ubicacion;
}
public Chip() {
	super();
}
public Chip(String numero, String ubicacion) {
	this();
	setNumero(numero);
	setUbicacion(ubicacion);
}
@Override
public String toString() {
	return "Chip [numero=" + numero + ", ubicacion=" + ubicacion + "]";
}




}
