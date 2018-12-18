package com.ipartek.formacion.modelos.pojos;



public class Usuario {
	
	public static final String REGEX_EMAIL = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
	public static final String REGEX_PASSWORD = "(?=^.{6,}$)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&amp;*()_+}{&quot;:;'?/&gt;.&lt;,])(?!.*\\s).*$";
	
	private Integer id;
	private String email, password;
	
	public Usuario(Integer id, String email, String password) {
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
		if(email == null || email.trim().length() == 0) {
			throw new PojoException(PojoException.MAIL_VACIO);
		}
		
		//if(!email.matches("\\w[a-zA-Z0-9\\._]*@\\w[a-zA-Z0-9\\.]*\\.\\w+")) {
		if(!email.matches(REGEX_EMAIL)) {
			throw new PojoException(PojoException.MAIL_NO_VALIDO);
		}
		
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(password == null || password.trim().length() == 0) {
			throw new PojoException(PojoException.PASS_VACIO);
		}
		
		if(!password.matches(REGEX_PASSWORD)) {
			throw new PojoException(PojoException.PASS_NO_VALIDO);
		}
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
}
