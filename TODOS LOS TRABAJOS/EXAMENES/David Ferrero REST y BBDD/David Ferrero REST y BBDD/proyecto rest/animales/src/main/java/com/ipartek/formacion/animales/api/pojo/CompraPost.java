package com.ipartek.formacion.animales.api.pojo;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class CompraPost {

	@NotEmpty
	private Date fecha;

	@NotEmpty
	private int idStock;

	@NotEmpty
	private int idEmpleado;

	@NotEmpty
	private int idCliente;

	public CompraPost() {
		super();
		this.fecha = null;
		this.idStock = -1;
		this.idEmpleado = -1;
		this.idCliente = -1;

	}

	public CompraPost(Date fecha, int idStock, int idEmpleado, int idCliente) {
		this();
		setFecha(fecha);
		setIdStock(idStock);
		setIdEmpleado(idEmpleado);
		setIdCliente(idCliente);
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdStock() {
		return idStock;
	}

	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "CompraPost [fecha=" + fecha + ", idStock=" + idStock + ", idEmpleado=" + idEmpleado + ", idCliente="
				+ idCliente + "]";
	}

}
