package com.ipartek.appMultas.modelo.pojo;

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
	@Size(min=10, max=255)
	private String concepto;
	private Date fecha;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	public Multa(Long id, Double importe, String concepto, Date fecha, Date fechaModificacion, Date fechaBaja, Agente agente, Coche coche) {
		this();
		setId(id);
		setImporte(importe);
		setConcepto(concepto);
		setFecha(fecha);
		setFechaModificacion(fechaModificacion);
		setFechaBaja(fechaBaja);
		setAgente(agente);
		setCoche(coche);
	}
	public Multa() {
		super();
		this.id=-1l;
		this.importe=0.0;
		this.concepto="";
		this.fecha=null;
		this.fechaModificacion=null; 
		this.fechaBaja=null; 
		this.agente=new Agente();
		this.coche=new Coche();
	}
	@Override
	public String toString() {
		return "Multa [id=" + id + ", importe=" + importe + ", concepto=" + concepto + ", fecha=" + fecha + ", agente="
				+ agente + ", coche=" + coche + "]";
	}
	
	
//
//	private Long id;
//	@NotNull
//	@Min(value = 1, message = "El importe no debe ser menor que 1")
//	private Double importe;
//	@NotEmpty
//	@Size(min = 10, max = 255)
//	private String concepto;
//	private Timestamp fecha;
//	private Timestamp fecha_baja;
//	private Coche coche;
//
//	public Multa() {
//		super();
//	}
//
//	public Multa(Long id, Double importe, String concepto, Timestamp fecha, Coche coche) {
//		this();
//		setId(id);
//		setImporte(importe);
//		setConcepto(concepto);
//		setFecha(fecha);
//		setCoche(coche);
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Double getImporte() {
//		return importe;
//	}
//
//	public void setImporte(Double importe) {
//		this.importe = importe;
//	}
//
//	public String getConcepto() {
//		return concepto;
//	}
//
//	public void setConcepto(String concepto) {
//		this.concepto = concepto;
//	}
//
//	public Timestamp getFecha() {
//		return fecha;
//	}
//
//	public void setFecha(Timestamp fecha) {
//
//		this.fecha = fecha;
//	}
//
//	public Coche getCoche() {
//		return coche;
//	}
//
//	public void setCoche(Coche coche) {
//		this.coche = coche;
//	}
//
//	public Timestamp getFecha_baja() {
//		return fecha_baja;
//	}
//
//	public void setFecha_baja(Timestamp fecha_baja) {
//		this.fecha_baja = fecha_baja;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((coche == null) ? 0 : coche.hashCode());
//		result = prime * result + ((concepto == null) ? 0 : concepto.hashCode());
//		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((importe == null) ? 0 : importe.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Multa other = (Multa) obj;
//		if (coche == null) {
//			if (other.coche != null)
//				return false;
//		} else if (!coche.equals(other.coche))
//			return false;
//		if (concepto == null) {
//			if (other.concepto != null)
//				return false;
//		} else if (!concepto.equals(other.concepto))
//			return false;
//		if (fecha == null) {
//			if (other.fecha != null)
//				return false;
//		} else if (!fecha.equals(other.fecha))
//			return false;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		if (importe == null) {
//			if (other.importe != null)
//				return false;
//		} else if (!importe.equals(other.importe))
//			return false;
//		return true;
//	}
//
//	@Override
//	public String toString() {
//		return "Multa [id=" + id + ", importe=" + importe + ", concepto=" + concepto + ", fecha=" + fecha
//				+ ", fecha_baja=" + fecha_baja + ", coche=" + coche + "]";
//	}

}
