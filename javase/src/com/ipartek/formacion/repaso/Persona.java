package com.ipartek.formacion.repaso;

class Persona {//extends Object { //implícito
	//Variables de instancia: SIEMPRE PRIVADAS
	private Long id; //private solo da acceso a la propia clase en la que está definido el elemento
	private String nombre;
	private String apellidos;
	
	//Constructores (se ejecutan al hacer new y el tipo)
	public Persona(Long id, String nombre, String apellidos) {
		//super(); // es implícito en la creación de los constructores
		// super es una referencia al objeto padre del que estamos utilizando
		// En este caso, al no haber definido un extends es Object
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	//Métodos de acceso: getters y setters
	public Long getId() { //Obtener el valor del id que hay en el objeto
		return id;
	}

	public void setId(Long id) { //Cambiar el valor del id que hay en el objeto
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	//Método sobrecargado de la clase padre
	//Este método convierte el objeto en un String
	@Override //Java 5
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	//Método de instancia / función
	public String obtenerNombreCompleto() {
		return nombre + " " + apellidos;
	}
}
