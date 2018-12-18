package com.ipartek.formacion.modelo.pojos;

public class Disco {

	


	private long id;
	private String titulo;
	private String artista;
	private String portada;
	private String year;
	
	

	//Constructor
	
	public Disco() {
		super();
		this.id = -1;
		this.titulo = "Dystopia";
		this.artista = "Megadeth";
		this.portada = "https://www.google.com/url?sa=i&source=images&cd=&ved=2ahUKEwjnvc7Ci6nfAhXPGewKHWzDBLUQjRx6BAgBEAU&url=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FDystopia_(Megadeth_album)&psig=AOvVaw1TsDy6qhGagnfJbFjrD9P0&ust=1545212566099277";
		this.year = "2016";
	}
	//Getters y setters
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



	public String getArtista() {
		return artista;
	}



	public void setArtista(String artista) {
		this.artista = artista;
	}



	public String getPortada() {
		return portada;
	}



	public void setPortada(String portada) {
		this.portada = portada;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}
	

	//To string
	@Override
	public String toString() {
		return "Disco [id=" + id + ", titulo=" + titulo + ", artista=" + artista + ", portada=" + portada + ", year="
				+ year + "]";
	}
	
}
