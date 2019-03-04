package com.ipartek.formacion.modelo.pojo;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MultaCreada {

	
	@NotNull
	@Digits(fraction = 2, integer = 5)
	private Double importe;
	@NotNull
	@Size(min=10, max=255)
	private String concepto;
	
	private Long idAgente;
	private Long idCoche;
	
	
	public MultaCreada() {
		super();
		
		this.importe=0.0;
		this.concepto="";
		this.idAgente= -1L;
		this.idCoche= -1L;
	}


	public MultaCreada(Double importe, String concepto, Long idAgente, Long idCoche) {
		this();
		setImporte(importe);
		setConcepto(concepto);
		setIdAgente(idAgente);
		setIdCoche(idCoche);
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public Long getIdAgente() {
		return idAgente;
	}

	public void setIdAgente(Long idAgente) {
		this.idAgente = idAgente;
	}

	public Long getIdCoche() {
		return idCoche;
	}

	public void setIdCoche(Long idCoche) {
		this.idCoche = idCoche;
	}


	@Override
	public String toString() {
		return "MultaCreada [importe=" + importe + ", concepto=" + concepto + ", idAgente=" + idAgente + ", idCoche="
				+ idCoche + "]";
	}
	
	
	
}
