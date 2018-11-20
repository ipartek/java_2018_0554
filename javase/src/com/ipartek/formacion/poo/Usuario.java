package com.ipartek.formacion.poo;

public class Usuario {
	//Constantes
	private static final String EMAIL_POR_DEFECTO = "desconocido@desconocido.es";
	private static final String PASSWORD_POR_DEFECTO = "";
	
	//Variables de instancia
	private String email, password;

	//Constructores
	public Usuario(String email, String password) {
		setEmail(email); setPassword(password);
		System.out.println("Se ha creado un usuario");
	}
	
	public Usuario(String email) {
		this(email, PASSWORD_POR_DEFECTO);
	}
	
	public Usuario() {
		this(EMAIL_POR_DEFECTO, PASSWORD_POR_DEFECTO);
	}
	
	//Métodos de acceso (getters y setters)
	public void setEmail(String email) {
		if(email.indexOf('@') == -1 ) {
			throw new RuntimeException("No se admiten emails sin @");
		}
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	//Métodos
	public void cambiarPassword(String password) {
		if(this.password.equals(password)) {
			throw new RuntimeException("No has cambiado la password. Son iguales");
		}
		
		setPassword(password);
	}
	
	public String datosCompletos() {
		return email + ", " + password;
	}
	
	//Método sobrecargado
	public String datosCompletos(String formato) {
		switch(formato) {
		case "coma": return datosCompletos();
		case "corchetes": return "[email: " + email + ", password: " + password + "]";
		default: throw new RuntimeException("Formato no reconocido");
		}
	}
}
