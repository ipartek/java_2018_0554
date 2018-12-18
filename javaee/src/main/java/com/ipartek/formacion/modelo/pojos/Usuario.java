package com.ipartek.formacion.modelo.pojos;

public class Usuario {

	public static final String REGEX_EMAIL = "^\\w+[\\w-\\.]*\\@\\w+((-\\w+)|(\\w*))\\.[a-z]{2,3}$";
	public static final String REGEX_PASSWORD = "(?=^.{6,}$)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&amp;*()_+}{&quot;:;'?\\/&gt;.&lt;,])(?!.*\\s).*$";

	private Long id;
	private String email;
	private String password;

	public Usuario() throws PojoException {
		super();
		this.id = (long) -1;
		this.email = "";
		this.password = "";
	}

	public Usuario(Long id, String email, String password) throws PojoException {
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

	public void setEmail(String email) throws PojoException {

		if (email == null || email.trim().length() == 0) {
			throw new PojoException(PojoException.EXCEPTION_EMAIL_VACIO);
		}

		if (!email.matches(REGEX_EMAIL)) {
			throw new PojoException(PojoException.EXCEPTION_EMAIL_NO_VALIDO);
		}

		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws PojoException {

		if (password == null || password.trim().length() == 0) {
			throw new PojoException(PojoException.EXCEPTION_PASSWORD_VACIO);
		}

		if (!password.matches(REGEX_PASSWORD)) {
			throw new PojoException(PojoException.EXCEPTION_PASSWORD_NO_VALIDO);
		}

		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
}