package com.ipartek.formacion.modelo.pojos;

public class UsuarioNoValido {
	private Long id;
	private String email;
	private String password;
	private String gitHub;
	
	public UsuarioNoValido(Long id, String email, String password, String gitHub) {
		setId(id);
		setEmail(email);
		setPassword(password);
		setGitHub(gitHub);
	}

	public UsuarioNoValido() {
		
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
		/*if(email == null || email.trim().length() == 0) {
			throw new PojoException("No se admiten emails vacíos");
		}
		
		//if(!email.matches("\\w[a-zA-Z0-9\\._]*@\\w[a-zA-Z0-9\\.]*\\.\\w+")) {
		if(!email.matches(Constantes.REGEX_EMAIL)) {
			throw new PojoException("El formato del email no es correcto");
		}*/
		
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		/*if(password == null || password.trim().length() == 0) {
			throw new PojoException("No se admiten contraseñas vacías");
		}
		
		if(!password.matches(Constantes.REGEX_PASSWORD)) {
			throw new PojoException("This regular expression match can be used for validating strong password. It expects at least 1 small-case letter, 1 Capital letter, 1 digit, 1 special character and the length should be at least 6 characters. The sequence of the characters is not important. This expression follows the above 4 norms specified by microsoft for a strong password.");
		}*/
		this.password = password;
	}
	
	

	public String getGitHub() {
		return gitHub;
	}

	public void setGitHub(String gitHub) {
		this.gitHub = gitHub;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
}
