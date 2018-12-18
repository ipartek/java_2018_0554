package com.ipartek.formacion.modelo.pojos;

public class Coche {
// Atributos
	private Long id;
	private String marca;
	private String modelo;
	private String imagen;

								//	Constructores
	public Coche() {
		super();
		this.id = -1L;
		this.marca = "";
		this.modelo = "";
		this.imagen = "";
	}

	public Coche(Long id, String marca, String modelo, String imagen) {
		this();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.imagen = imagen;
	}

	// Get Set
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

//	Otros

	@Override
	public String toString() {
		return "Coche [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", imagen=" + imagen + "]";
	}
}
