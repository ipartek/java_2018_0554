package com.ipartek.formacion.modelos.pojos;

public class Carrito {
	private int id;
	private int perro;
	private int cantidad;
	
	
	
	
	public Carrito(int id, int perro, int cantidad) {
		super();
		setId(id);
		setPerro(perro);
		setCantidad(cantidad);
	}


	public Carrito() {
		super();
		this.id=-1;
		this.perro=-1;
		this.cantidad=-1;
	}


	public int getId() {
		return id;
	}


	public void setId(Integer id) {
		if(id == null || id.toString().trim().length()==0) {
			id=-1;
		}
		this.id = id;
	}


	public int getPerro() {
		return perro;
	}


	public void setPerro(Integer perro) {
		if(perro == null || perro.toString().trim().length()==0) {
			perro=-1;
		}
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		if(cantidad == null || cantidad.toString().trim().length()==0) {
			cantidad=-1;
		}
		this.cantidad = cantidad;
	}


	@Override
	public String toString() {
		return "Carrito [id=" + id + ", perro=" + perro + ", cantidad=" + cantidad + "]";
	}
	
	
}
