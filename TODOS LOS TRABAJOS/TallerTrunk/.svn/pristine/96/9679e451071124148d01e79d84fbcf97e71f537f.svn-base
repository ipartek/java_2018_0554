package com.ipartek.formacion.taller.api.controller.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class VehiculoPost {

	@NotEmpty
	@Size(min = 17, max = 17)
	private String numeroBastidor;

	@NotEmpty
	@Size(min = 8, max = 10)
	private String matricula;

	@NotNull
	private int idPropietario;

	@NotNull
	private int idCombustible;

	@NotNull
	private int idModelo;

	public VehiculoPost() {
		super();
		this.matricula = "";
		this.numeroBastidor = "";
		this.idCombustible = -1;
		this.idModelo = -1;
		this.idPropietario = -1;
	}

	public String getNumeroBastidor() {
		return numeroBastidor;
	}

	public void setNumeroBastidor(String numeroBastidor) {
		this.numeroBastidor = numeroBastidor;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getIdPropietario() {
		return idPropietario;
	}

	public void setIdPropietario(int idPropietario) {
		this.idPropietario = idPropietario;
	}

	public int getIdCombustible() {
		return idCombustible;
	}

	public void setIdCombustible(int idCombustible) {
		this.idCombustible = idCombustible;
	}

	public int getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}

	@Override
	public String toString() {
		return "VehiculoPost [numeroBastidor=" + numeroBastidor + ", matricula=" + matricula + ", idPropietario="
				+ idPropietario + ", idCombustible=" + idCombustible + ", idModelo=" + idModelo + "]";
	}

}
