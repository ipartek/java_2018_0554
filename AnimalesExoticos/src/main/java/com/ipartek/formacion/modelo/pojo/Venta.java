package com.ipartek.formacion.modelo.pojo;

public class Venta {
	private long id;
	private Usuario usuario;
	private Stock stock;
	
	public Venta() {
		super();
		this.id = -1;
		this.usuario = new Usuario();
		this.stock = new Stock();
	}
	
	public Venta(long id, Usuario usuario, Stock stock) {
		super();
		setId(id);
		setUsuario(usuario);
		setStock(stock);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usario) {
		this.usuario = usario;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", usuario=" + usuario + ", stock=" + stock + "]";
	}
	
}
