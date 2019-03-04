package com.ipartek.formacion.modelo.pojo;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MultaCreada {

	private Long id;
	@NotNull
	@Digits(fraction = 2, integer = 5)
	private Float importe;
	@NotNull
	@Size(min = 10, max = 255)
	private String concepto;

	private Long idAgente;
	private Long idCoche;

	public MultaCreada() {
		super();
		this.id = -1L;
		this.importe = (float) 0.0;
		this.concepto = "";
		this.idAgente = -1L;
		this.idCoche = -1L;
	}

	public MultaCreada(Long id, Float importe, String concepto, Long idAgente, Long idCoche) {
		this();
		setId(id);
		setImporte(importe);
		setConcepto(concepto);
		setIdAgente(idAgente);
		setIdCoche(idCoche);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getImporte() {
		return importe;
	}

	public void setImporte(Float importe) {
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
		return "MultaCreada [id=" + id + ", importe=" + importe + ", concepto=" + concepto + ", idAgente=" + idAgente
				+ ", idCoche=" + idCoche + "]";
	}

}
