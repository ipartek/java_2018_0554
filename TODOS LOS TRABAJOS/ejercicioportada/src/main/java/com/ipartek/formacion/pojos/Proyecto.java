package com.ipartek.formacion.pojos;

public class Proyecto {
	private Long id;
	private String titulo;
	private String descripcion;
	
	public Proyecto(Long id, String titulo, String descripcion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + "]";
	}
}
