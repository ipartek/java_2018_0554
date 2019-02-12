package com.ipartek.formacion.pojo;

import java.sql.Date;

public class Bolo {
	private Long id;
	private Date fecha;
	private String lugar;
	private String banda1;
	private String banda2;
	private String banda3;
	private Long idCrew;
	private String info;

	public Bolo() {

		super();
		this.id = -1L;
		this.fecha = null;
		this.lugar = "";
		this.banda1 = "";
		this.banda2 = "";
		this.banda3 = "";
		this.idCrew = 1L;
		this.info = "";
	}

	
	// constructor con parametros
	public Bolo(Long id, Date fecha, String lugar, String banda1, String banda2, String banda3, Long idCrew) {
		this();
		setId(id);
		setFecha(fecha);
		setLugar(lugar);
		setBanda1(banda1);
		setBanda2(banda2);
		setBanda3(banda3);
		setIdCrew(idCrew);

	}
	
	// constructor con parametros mas parametro  informacion
	public Bolo(Long id, Date fecha, String lugar, String banda1, String banda2, String banda3, Long idCrew, String info) {
		this();
		setId(id);
		setFecha(fecha);
		setLugar(lugar);
		setBanda1(banda1);
		setBanda2(banda2);
		setBanda3(banda3);
		setIdCrew(idCrew);
		setInfo(info);

	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
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

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getBanda1() {
		return banda1;
	}

	public void setBanda1(String banda1) {
		this.banda1 = banda1;
	}

	public String getBanda2() {
		return banda2;
	}

	public void setBanda2(String banda2) {
		this.banda2 = banda2;
	}

	public String getBanda3() {
		return banda3;
	}

	public void setBanda3(String banda3) {
		this.banda3 = banda3;
	}

	public Long getIdCrew() {
		return idCrew;
	}

	public void setIdCrew(Long idCrew) {
		this.idCrew = idCrew;
	}

	@Override
	public String toString() {
		return "Bolo [id=" + id + ", fecha=" + fecha + ", lugar=" + lugar + ", banda1=" + banda1 + ", banda2=" + banda2
				+ ", banda3=" + banda3 + ", idCrew=" + idCrew + ", info=" + info + "]";
	}

	
}