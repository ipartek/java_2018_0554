package com.ipartek.formacion.tienda.modelo.pojo;

import java.sql.Date;

public class Pedido {

	private int id;

	private Date fecha_compra;

	private Cliente comprador;

	private Stock compra;

	public Pedido() {
		super();
		this.id = -1;
		//TODO revisar el date
		this.fecha_compra =  new Date(119,2,11);
		this.comprador = new Cliente();
		this.compra = new Stock();
	}

	public Pedido(int id, Date fecha_compra, Cliente comprador, Stock compra) {
		super();
		setId(id);
		setFecha_compra(fecha_compra);
		setComprador(comprador);
		setCompra(compra);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha_compra() {
		return fecha_compra;
	}

	public void setFecha_compra(Date fecha_compra) {
		this.fecha_compra = fecha_compra;
	}

	public Cliente getComprador() {
		return comprador;
	}

	public void setComprador(Cliente comprador) {
		this.comprador = comprador;
	}

	public Stock getCompra() {
		return compra;
	}

	public void setCompra(Stock compra) {
		this.compra = compra;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fecha_compra=" + fecha_compra + ", comprador=" + comprador + ", compra=" + compra
				+ "]";
	}

}
