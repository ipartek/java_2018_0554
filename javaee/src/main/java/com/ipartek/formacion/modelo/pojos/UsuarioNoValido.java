package com.ipartek.formacion.modelo.pojos;

public class UsuarioNoValido {
	private Long id;
	private String email, password;
	
	public UsuarioNoValido(Long id, String email, String password) {
		super();
		setId(id);
		setEmail(email);
		setPassword(password);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
