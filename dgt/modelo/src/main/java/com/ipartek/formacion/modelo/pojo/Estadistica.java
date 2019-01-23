package com.ipartek.formacion.modelo.pojo;

import java.math.BigDecimal;

public class Estadistica {
	private int mes;
	private Float importe = 0F;
	private String nombremes;

	BigDecimal bd;

	public Estadistica(int mes, Float importe,String nombremes) {
		this();
		setMes(mes);
		setImporte(importe);
		setNombremes(nombremes);
	}
	
	public Estadistica() {
		super();
		this.mes=-1;
		this.importe=0F;
	}


	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public Float getImporte() {
		return importe;
	}

	public String getNombremes() {
		return nombremes;
	}

	public void setNombremes(String nombremes) {
		this.nombremes = nombremes;
	}
	
	public void setImporte(Float importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "Estadisticas [mes=" + mes + ", importe=" + importe + ", Nombre Mes=" + nombremes +"]";
	}
}