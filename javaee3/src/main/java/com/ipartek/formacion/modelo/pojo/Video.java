package com.ipartek.formacion.modelo.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Video {
	
	private Long id;
	@NotEmpty
	@Size(min=5, max=150)
	private String nombre;
	@NotEmpty
	@Size(min=11, max=11)
	private String codigo;
	
	private Usuario usuario;
	
	public Video() {
		super();
		this.id= (long) -1;
		this.nombre="";
		this.codigo="";
		this.usuario = new Usuario();
	}
	
	public Video(Long id, String nombre, String codigo, Usuario usuario) {
		this();
		setId(id);
		setNombre(nombre);
		setCodigo(codigo);
		setUsuario(usuario);
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", usuario=" + usuario + "]";
	}

}
