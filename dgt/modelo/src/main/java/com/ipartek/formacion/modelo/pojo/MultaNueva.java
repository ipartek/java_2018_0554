package com.ipartek.formacion.modelo.pojo;

public class MultaNueva {
	
	private String concepto;	
	private Double importe;
	private Long id_coche;
	private Long id_agente;
	
	
	
	public MultaNueva() {
		super();
		
		this.concepto="";
		this.importe=0.0;		
		this.id_coche= -1L;
		this.id_agente= -1L;
	}
	
	
	public MultaNueva(String concepto, Double importe, Long id_coche, Long id_agente) {
		this();
		this.concepto = concepto;
		this.importe = importe;
		this.id_coche = id_coche;
		this.id_agente = id_agente;
	}


	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	public Long getId_coche() {
		return id_coche;
	}
	public void setId_coche(Long id_coche) {
		this.id_coche = id_coche;
	}
	public Long getId_agente() {
		return id_agente;
	}
	public void setId_agente(Long id_agente) {
		this.id_agente = id_agente;
	}

}
