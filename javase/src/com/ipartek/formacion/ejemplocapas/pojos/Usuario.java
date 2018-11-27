package com.ipartek.formacion.ejemplocapas.pojos;

public class Usuario {
	private Long id;
	private String email, password;
	
	public Usuario(Long id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
}
