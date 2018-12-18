package com.ipartek.formacion.modelo.pojos;

public class Perro {

	// Atributos
	private long id;
	private String raza;
	private String img;
	
	
	// Constructores
	
	public Perro() {
		super();
		this.id = -1;
		this.raza = "Bulldog";
		this.img = "https://previews.123rf.com/images/adogslifephoto/adogslifephoto1508/adogslifephoto150800242/43621291-un-adorable-bulldog-ingl%C3%A9s-sentado-mientras-mira-a-la-c%C3%A1mara-.jpg";
	}
	
	
	public Perro(long id, String raza, String img) {
		this();
		setId(id);
		setRaza(raza);
		setImg(img);
	}


	// Getters y Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
	// Otros metodos => toString
	@Override
	public String toString() {
		return "Perro [id=" + id + ", raza=" + raza + ", img=" + img + "]";
	}
}