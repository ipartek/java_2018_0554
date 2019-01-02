package com.ipartek.formacion.modelos.pojos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Usuario {
	
	private Integer id;
	@NotNull
	@NotEmpty
	@Email
	private String email;
	@NotNull
	@NotEmpty
	@Size(min = 8, max = 25)
	private String password;
	
	public Usuario(String email, String password) {
		setId(-1);
		setEmail(email);
		setPassword(password);
	}
	public Usuario(int id,String email, String password) {
		setId(id);
		setEmail(email);
		setPassword(password);
	}

	public Usuario() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
