package com.ipartek.formacion.modelos.pojos;

public class Usuario {

//	public static final String REGEX_EMAIL = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
//	public static final String REGEX_PASSWORD = "(?=^.{6,}$)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&amp;*()_+}{&quot;:;'?/&gt;.&lt;,])(?!.*\\s).*$";

	private Long id;
	private String nombre;
	private String password;
	private String apellidos;

	public Usuario() throws PojoException {
		super();
		this.id = (long) -1;
		this.nombre = "";
		this.password = "";
		this.apellidos="";
	}

	public Usuario(Long id, String nombre, String password, String apellidos) throws PojoException {
		this();
		setId(id);
		setNombre(nombre);
		setPassword(password);
		setApellidos(apellidos);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws PojoException {

		if (nombre == null || nombre.trim().length() == 0) {
			throw new PojoException(PojoException.EXCEPTION_NOMBRE_VACIO);
		}

//		if (!nombre.matches(REGEX_EMAIL)) {
//			throw new PojoException(PojoException.EXCEPTION_EMAIL_NO_VALIDO);
//		}

		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws PojoException {

		if (password == null || password.trim().length() == 0) {
			throw new PojoException(PojoException.EXCEPTION_PASSWORD_VACIO);
		}

//		if (!password.matches(REGEX_PASSWORD)) {
//			throw new PojoException(PojoException.EXCEPTION_PASSWORD_NO_VALIDO);
//		}

		this.password = password;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", password=" + password + ",apellidos=" +apellidos +"]";

	}
}