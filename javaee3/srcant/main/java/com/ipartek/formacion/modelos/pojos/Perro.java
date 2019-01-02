package com.ipartek.formacion.modelos.pojos;

public class Perro {
	
	private int id;
	private String raza;
	private String imagen;
	private Double precio;
	
	
	public Perro() {
		super();
		this.id=-1;
		this.raza="desconocida";
		this.imagen="https://image.freepik.com/free-icon/interrogation-mark-in-a-circle_318-9651.jpg";
		this.precio=0.0;
	}





	public Perro(Integer id, String raza, String imagen, Double precio) {
		this();
		setId(id);
		setRaza(raza);
		setImagen(imagen);
		setPrecio(precio);
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		if(id==null || id.toString().trim().length()==0) {
			id=-1;
		}
		this.id = id;
	}


	public String getRaza() {
		return raza;
	}


	public void setRaza(String raza) {
		if(raza==null || raza.trim().length()==0) {
			raza="desconocido";
		}
		this.raza = raza;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		if(imagen==null || imagen.trim().length()==0) {
			imagen="https://image.freepik.com/free-icon/interrogation-mark-in-a-circle_318-9651.jpg";
		}
		this.imagen = imagen;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		if(precio==null || precio.toString().trim().length()==0) {
			precio=-1.0;
		}
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Perro [id=" + id + ", raza=" + raza + ", imagen=" + imagen + "]";
	}

}
