package com.ipartek.formacion.cervezas.modelo.pojo;

public class Compra {

	private int id;

	//@NotEmpty
	private int cantidad;

	// @Valid
	private Tipo tipo;

	private Cliente cliente;

	public Compra() {
		super();
		this.id = -1;
		this.cantidad = -1;
		this.tipo = new Tipo();
		this.cliente = new Cliente();
	}

	public Compra(int id, int cantidad, Tipo tipo, Cliente cliente) {
		this();
		this.setId(id);
		this.setCantidad(cantidad);
		this.setTipo(tipo);
		this.setCliente(cliente);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", cantidad=" + cantidad + ",  tipo=" + tipo + ", cliente=" + cliente + "]";
	}

}
