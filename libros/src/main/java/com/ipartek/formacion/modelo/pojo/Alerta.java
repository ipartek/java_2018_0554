package com.ipartek.formacion.modelo.pojo;

public class Alerta {
	
private String tipo;
private String texto;



public Alerta(String tipo, String texto) {
	this();
	this.tipo = tipo;
	this.texto = texto;
}

public Alerta() {
	super();
	this.tipo = "Error inesperado";
	this.texto = "danger";
}

public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public String getTexto() {
	return texto;
}
public void setTexto(String texto) {
	this.texto = texto;
}



}
