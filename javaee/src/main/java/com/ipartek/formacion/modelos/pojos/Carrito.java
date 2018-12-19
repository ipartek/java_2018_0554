package com.ipartek.formacion.modelos.pojos;

public class Carrito {
	private int id;
	private Perro perro;
	private int cantidad;
	
	
	
	
	public Carrito(int id, Perro perro, int cantidad) {
		super();
		setId(id);
		setPerro(null);
		setCantidad(cantidad);
	}


	public Carrito() {
		super();
		this.id=-1;
		this.perro=null;
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


	public Perro getPerro() {
		return perro;
	}


	public void setPerro(Perro perro) {
			this.perro=null;

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
