package com.ipartek.formacion.modelo.pojo;

public class Venta {
	
	private int id;
	private int idUsuario;
	private int idAnimal;
	
	public Venta() {
		super();
		this.id = -1;
		this.idAnimal = -1;
		this.idUsuario = -1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", idUsuario=" + idUsuario + ", idAnimal=" + idAnimal + "]";
	}
	
	
}
