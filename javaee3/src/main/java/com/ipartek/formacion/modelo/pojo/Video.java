package com.ipartek.formacion.modelo.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Video {
	//ATRIBUTOS
	private long id;
	
	@NotEmpty
	@Size(min = 5, max=150)
	private String titulo;
	
	@NotEmpty
	@Size(min = 11, max=11)
	private String codigo;
	
	private Usuario usuario;
	
	//CONSTRUCTORES
	public Video(){
		super();
		this.id=-1;
		this.titulo = "";
		this.codigo = "";
		this.usuario= new Usuario();
	}
	public Video(String nombre){
		super();
		this.titulo=nombre;
		
		
	}
	
	public Video(Long id,String nombre, String url, Usuario u) {
		super();
		setTitulo(nombre);
		setCodigo(url);
		setUsuario(u);
	}
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
		return "Video [id=" + id + ", titulo=" + titulo + ", codigo=" + codigo + ", usuario=" + usuario + "]";
	}
	
	
	
	
	

}
