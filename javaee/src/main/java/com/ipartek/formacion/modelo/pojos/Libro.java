package com.ipartek.formacion.modelo.pojos;

public class Libro {

	private long id;
	private String nombre;
	private String autor;
	private String imagen;

	public Libro() {
		super();
		this.id = -1;
		this.nombre = "desconocido";
		this.autor = "desconocido";
		this.imagen = "https://www.google.es/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwivgvH0h6nfAhXGPFAKHcxtCB4QjRx6BAgBEAU&url=https%3A%2F%2Fwww.walmart.com%2Fip%2FMr-Clean-Multi-Surfaces-Liq-w-Gain-Apple-Berry-Twist-40oz%2F17201601&psig=AOvVaw3iVVCXUwHNOPy0aZl5GayP&ust=1545211579368469";
	}

	public Libro(long id, String nombre, String autor, String imagen) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.imagen = imagen;
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", autor=" + autor + ", imagen=" + imagen + "]";
	}

}