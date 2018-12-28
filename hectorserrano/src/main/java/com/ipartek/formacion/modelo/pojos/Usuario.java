package com.ipartek.formacion.modelo.pojos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Usuario {
	
	@NotEmpty
	private String usuario;
	@NotNull
	@Size(min = 5, max = 45)
	private String password;

	public Usuario() {
		super();
		this.usuario = "";
		this.password = "";
	}

	public Usuario(String usuario, String password) {
		this();
		setUsuario(usuario);
		setPassword(password);
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", password=" + password + "]";
	}
}