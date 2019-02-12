package com.ipartek.formacion.animales.modelo.pojo;

import java.sql.Date;

public class Compra {

	private int id;

	private Date fecha;

	private Stock stock;

	private Empleado empleado;

	private Cliente cliente;

	public Compra() {
		super();
		this.id = -1;
		this.fecha = null;
		this.stock = new Stock();
		this.empleado = new Empleado();
		this.cliente = new Cliente();
	}

	public Compra(int id, Date fecha, Stock stock, Empleado empleado, Cliente cliente) {
		this();
		this.setId(id);
		this.setFecha(fecha);
		this.setStock(stock);
		this.setEmpleado(empleado);
		this.setCliente(cliente);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", fecha=" + fecha + ", cliente=" + cliente + "]";
	}

}
