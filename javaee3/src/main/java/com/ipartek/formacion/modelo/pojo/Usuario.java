package com.ipartek.formacion.modelo.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;


public class Usuario {
	

	private Long id;
	
	
	@NotNull
	@Size(min=10, max=50)
	private String email;
	
	@NotNull
	@Size(min=10, max=50)
	private String password;
	
	public Usuario(Long id, String email, String password) throws PojoException  {
		this();
		setId(id);
		setEmail(email);
		setPassword(password);
	}

	public Usuario() throws PojoException {
		super();
		this.id = (long)-1;
		this.email = "";
		this.password = "";
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

	public void setEmail(String email) throws PojoException  {
		
		if(email == null || email.trim().length() == 0) {
			throw new PojoException(PojoException.EXCEPTION_EMAIL_VACIO);
		}
		
		
		if(!email.matches(Constantes.REGEX_EMAIL)) {
			throw new PojoException(PojoException.EXCEPTION_EMAIL_NO_VALIDO);
		}
		
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws PojoException {
		
		if(password == null || password.trim().length() == 0) {
			throw new PojoException(PojoException.EXCEPTION_PASSWORD_VACIO);
		}
		
		if(!password.matches(Constantes.REGEX_PASSWORD)) {
			throw new PojoException(PojoException.EXCEPTION_PASSWORD_NO_VALIDO);
		}
		
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
}
