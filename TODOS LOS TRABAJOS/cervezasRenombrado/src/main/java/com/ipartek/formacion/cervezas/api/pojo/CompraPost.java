package com.ipartek.formacion.cervezas.api.pojo;



import org.hibernate.validator.constraints.NotEmpty;

public class CompraPost {



	@NotEmpty
	private int cantidad;
	
	@NotEmpty
	private int idTipo;
	@NotEmpty
	private int idCliente;

	

	public CompraPost() {
		super();

		this.cantidad = -1;
		this.idTipo =-1;
		this.idCliente = -1;
		
	}

	public CompraPost(int cantidad, int idTipo, int idCliente) {
		this();

		setCantidad(cantidad);
		
		setIdTipo(idTipo);	
		setIdCliente(idCliente);
	}



	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "CervezaPost [cantidad=" + cantidad + ", idTipo=" + idTipo + ", idCliente=" + idCliente
				+ "]";
	}


	


	

}
