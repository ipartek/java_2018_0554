package com.ipartek.formacion.taller.modelo.pojo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.ipartek.formacion.taller.modelo.pojo.validactions.VehiculoCompleteCheck;
import com.ipartek.formacion.taller.modelo.pojo.validactions.VehiculosPostCheck;

public class Vehiculo {

	private int id;
	
	@NotEmpty(groups = {VehiculosPostCheck.class, VehiculoCompleteCheck.class})
	@Size(min = 17, max = 17, groups = {VehiculosPostCheck.class, VehiculoCompleteCheck.class})
	private String numeroBastidor;

	@NotEmpty(groups = {VehiculosPostCheck.class, VehiculoCompleteCheck.class})
	@Size(min = 8, max = 10, groups = {VehiculosPostCheck.class, VehiculoCompleteCheck.class})
	private String matricula;

	@Valid
	@NotNull
	private Combustible combustible;
	@Valid
	@NotNull
	private Modelo modelo;
	@Valid
	@NotNull
	private Persona propietario;


	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}

	public Vehiculo() {
		super();
		this.id = -1;
		this.numeroBastidor = "";
		this.matricula = "";
		this.combustible = new Combustible();
		this.modelo = new Modelo();
		this.propietario = new Persona();
	}

	public Vehiculo(int id, String numeroBastidor, String matricula, Combustible combustible, Modelo modelo,Persona propietario) {
		this();
		setId(id);
		setNumeroBastidor(numeroBastidor);
		setMatricula(matricula);
		setCombustible(combustible);
		setModelo(modelo);
		setPropietario(propietario);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Combustible getCombustible() {
		return combustible;
	}

	public void setCombustible(Combustible combustible) {
		this.combustible = combustible;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", numeroBastidor=" + numeroBastidor + ", matricula=" + matricula
				+ ", combustible=" + combustible + ", modelo=" + modelo + ", propietario=" + propietario + "]";
	}

}
