package com.ipartek.formacion.modelo.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;




public class Usuario {
	
	private Long id;
		
	@NotNull
	@Size(min=5, max=50)
	private String email;
	
	@NotNull
	@Size(min=5, max=50)
	private String password;

	public Usuario() {
		super();
		this.id = (long) -1;
		this.email = "";
		this.password = "";
	}

	public Usuario(Long id, String email, String password) {
		this();
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
}
