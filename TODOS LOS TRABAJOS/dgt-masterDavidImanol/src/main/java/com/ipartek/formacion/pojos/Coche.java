package com.ipartek.formacion.pojos;

public class Coche {

	private Long id;
	private String matricula;
	private String modelo;
	private Integer Km;

	public Coche() {
		super();
		this.id = -1L;
		this.matricula = "";
		this.modelo = "";
		this.Km = -1;
	}

	public Coche(Long id, String matricula, String modelo, Integer km) {
		this();
		setId(id);
		setMatricula(matricula);
		setModelo(modelo);
		setKm(km);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getKm() {
		return Km;
	}

	public void setKm(Integer km) {
		Km = km;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", matricula=" + matricula + ", modelo=" + modelo + ", Km=" + Km + "]";
	}

}
