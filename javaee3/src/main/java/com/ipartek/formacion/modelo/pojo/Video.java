package com.ipartek.formacion.modelo.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Video {

	private long id;
	
	@NotEmpty
	@Size(min=4, max=150)
	private String nombre;
	
	@NotEmpty
	@Size(min=11,max=11)
	private String codigo;

	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Video() {
		super();
		this.id = -1;
		this.nombre = "Surf Search Spot 2 0 video promo";
		this.codigo = "LPDhuthFD98";
		this.usuario=new Usuario();
	}
	
	public Video(String nombre) {
		this();
		setNombre( nombre);
	}
	
	public Video(Long id,String nombre, String codigo) {
		this();
		setId(id);
		setNombre( nombre);
		setCodigo( codigo);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Video [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + "]";
	}
	



}
