package com.ipartek.formacion.dgt.api.model;

public class MultaPOST {
	
	private float importe;
	private String concepto;
	private int idCoche;
	private int idAgente;
	
	public MultaPOST() {
		super();
		this.importe = 0;
		this.concepto = "";
		this.idCoche = -1;
		this.idAgente = -1;
	}
	
	public MultaPOST(float importe, String concepto, int idCoche, int idAgente) {
		this();
		setImporte(importe);
		setConcepto(concepto);
		setIdCoche(idCoche);
		setIdAgente(idAgente);
	}

	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public int getIdCoche() {
		return idCoche;
	}
	public void setIdCoche(int idCoche) {
		this.idCoche = idCoche;
	}
	public int getIdAgente() {
		return idAgente;
	}
	public void setIdAgente(int idAgente) {
		this.idAgente = idAgente;
	}
	@Override
	public String toString() {
		return "MultaPOST [importe=" + importe + ", concepto=" + concepto + ", idCoche=" + idCoche + ", idAgente="
				+ idAgente + "]";
	}
	
}
