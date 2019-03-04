package com.ipartek.formacion.modelo.pojo;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Multa {
	private Long id;
	@NotNull
	@Digits(fraction = 2, integer = 5)
	private Double importe;
	@NotNull
	@Size(min = 10, max = 255)
	private String concepto;
	private Date fechaAlta;
	private Date fechaModificacion;
	private Date fechaBaja;
	private Agente agente;
	private Coche coche;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getImporte() {
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

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public Coche getCoche() {
		return coche;
	}

	public void setCoche(Coche coche) {
		this.coche = coche;
	}

	public Multa(Long id, Double importe, String concepto, Date fechaAlta, Date fechaModificacion, Date fechaBaja,
			Agente agente, Coche coche) {
		this();
		setId(id);
		setImporte(importe);
		setConcepto(concepto);
		setFechaAlta(fechaAlta);
		setFechaModificacion(fechaModificacion);
		setFechaBaja(fechaBaja);
		setAgente(agente);
		setCoche(coche);
	}

	public Multa() {
		super();
		this.id = -1l;
		this.importe = 0.0;
		this.concepto = "";
		this.fechaAlta = null;
		this.fechaModificacion = null;
		this.fechaBaja = null;
		this.agente = new Agente();
		this.coche = new Coche();
	}

	@Override
	public String toString() {
		return "Multa [id=" + id + ", importe=" + importe + ", concepto=" + concepto + ", fechaAlta=" + fechaAlta
				+ ", agente=" + agente + ", coche=" + coche + "]";
	}

}
