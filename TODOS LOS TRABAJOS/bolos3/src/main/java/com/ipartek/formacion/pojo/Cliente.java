package com.ipartek.formacion.pojo;

public class Cliente {
	private Long id;
	private String nombre;
	private Long telefono;
	private String correo;
	private Long idBolo;

	public Cliente() {

		super();
		this.id = -1L;
		this.nombre = "";
		this.telefono = null;		
		this.correo = "";
		this.idBolo = -1L;
	}

	
	
	
	public Cliente(Long id, String nombre, Long telefono, String correo, Long idBolo) {
		this();
		setId(id);
		setNombre(nombre);
		setTelefono(telefono);
		setCorreo(correo);

		setIdBolo(idBolo);
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public Long getTelefono() {
		return telefono;
	}




	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}




	public String getCorreo() {
		return correo;
	}




	public void setCorreo(String correo) {
		this.correo = correo;
	}




	public Long getIdBolo() {
		return idBolo;
	}




	public void setIdBolo(Long idBolo) {
		this.idBolo = idBolo;
	}




	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo
				+ ", idBolo=" + idBolo + "]";
	}




}