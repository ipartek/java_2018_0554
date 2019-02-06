package com.ipartek.formacion.taller.modelo.pojo; //

public class Vehiculo {

	private int id;
	private String bastidor;
	private String matricula;
	private int idPropietario;
	private int idCombustible;
	private int idModelo;

	public Vehiculo() {
		super();
		this.id = -1;
		this.bastidor = "";
		this.matricula = "";
		this.idPropietario = -1;
		this.idCombustible = -1;
		this.idModelo = -1;
	}

	public Vehiculo(int id, String bastidor, String matricula, int idPropietario, int idCombustible, int idModelo) {
		this();
		this.setId(id);
		this.setBastidor(bastidor);
		this.setMatricula(matricula);
		this.setIdPropietario(idPropietario);
		this.setIdCombustible(idCombustible);
		this.setIdModelo(idModelo);

	}

	public String getBastidor() {
		return bastidor;
	}

	public void setBastidor(String bastidor) {
		this.bastidor = bastidor;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", bastidor=" + bastidor + ", matricula=" + matricula + ", idPropietario="
				+ idPropietario + ", idCombustible=" + idCombustible + ", idModelo=" + idModelo + "]";
	}

}
