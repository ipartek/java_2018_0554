package com.ipartek.formacion.modelo.pojos;

public class Video {
	
	// Atributos
	
	private long id;
	private String nombre;
	private String codigo;

	// Constructores
	
	public Video(){
		super();
		this.id = -1;
		this.nombre = "Cannibal Corpse - Hammer Smashed Face (HD)";
		this.codigo = "https://www.youtube.com/watch?v=BT0jvduweTQ";
	}

	

	public Video(int id, String nombre, String codigo) {
		this();
		setId(id);
		setNombre(nombre);
		setCodigo(codigo);
	}
	
	
	
	//Getters & Setters

	public long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	//Otros metodos 
	
	@Override
	public String toString() {
		return "Video [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + "]";
	}



}
