package com.ipartek.formacion.pojo;

import java.sql.Date;

public class Tecnico {
	private Long id;
	private Date fecha;
	private String nombre;
	private String puesto;

	private Long Sueldo;
	private Long idCrew;

	public Tecnico() {

		super();
		this.id = -1L;
		this.fecha = null;
		this.nombre = "";
		this.puesto = "";
		this.Sueldo = null;
		this.idCrew = -1L;
	}

	public Tecnico(Long id, Date fecha, String nombre, String puesto, Long sueldo, String banda3, Long idCrew) {
		this();
		setId(id);
		setFecha(fecha);
		setNombre(nombre);
		setPuesto(puesto);
		setSueldo(sueldo);

		setIdCrew(idCrew);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getsetPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Long getIdCrew() {
		return idCrew;
	}

	public void setIdCrew(Long idCrew) {
		this.idCrew = idCrew;
	}

	public Long getSueldo() {
		return Sueldo;
	}

	public void setSueldo(Long sueldo) {
		Sueldo = sueldo;
	}

	public String getPuesto() {
		return puesto;
	}

	@Override
	public String toString() {
		return "Tecnico [id=" + id + ", fecha=" + fecha + ", nombre=" + nombre + ", puesto=" + puesto + ", Sueldo="
				+ Sueldo + ", idCrew=" + idCrew + "]";
	}

}
