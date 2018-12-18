package com.ipartek.formacion.modelos.pojos;

public class Perro {
	
	private int id;
	private String raza;
	private String imagen;
	
	
	public Perro() {
		super();
		this.id=-1;
		this.raza="desconocida";
		this.imagen="https://image.freepik.com/free-icon/interrogation-mark-in-a-circle_318-9651.jpg";
	}





	public Perro(Integer id, String raza, String imagen) {
		this();
		setId(id);
		setRaza(raza);
		setImagen(imagen);
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		if(id==null || id.toString().length()==0) {
			id=-1;
		}
		this.id = id;
	}


	public String getRaza() {
		return raza;
	}


	public void setRaza(String raza) {
		if(raza==null || raza.toString().length()==0) {
			raza="desconocido";
		}
		this.raza = raza;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		if(imagen==null || imagen.toString().length()==0) {
			imagen="https://image.freepik.com/free-icon/interrogation-mark-in-a-circle_318-9651.jpg";
		}
		this.imagen = imagen;
	}
	
	@Override
	public String toString() {
		return "Perro [id=" + id + ", raza=" + raza + ", imagen=" + imagen + "]";
	}

}
