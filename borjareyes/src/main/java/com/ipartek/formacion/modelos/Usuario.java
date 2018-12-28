package com.ipartek.formacion.modelos;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Usuario {
	private Integer id;

	@NotEmpty
	@Size(min = 2, max = 25)
	private String usuario;
	
	@NotEmpty
	@Size(min = 6, max = 25)
	private String password;
	

	public Usuario(String usuario, String password) {
		this();
		setId(-1);
		setUsuario(usuario);
		setPassword(password);
	}

	public Usuario(int id, String usuario, String password) {
		this();
		setId(id);
		setUsuario(usuario);
		setPassword(password);
	}

	public Usuario() {
		super();
		this.id=0;
		this.usuario="scooby";
		this.password="galletas";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return "Usuario [id=" + id + ", email=" + usuario + ", password=" + password + "]";
	}
}
