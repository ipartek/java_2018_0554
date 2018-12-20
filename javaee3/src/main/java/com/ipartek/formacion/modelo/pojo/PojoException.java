package com.ipartek.formacion.modelo.pojo;

public class PojoException extends RuntimeException {

	private static final long serialVersionUID = 6476469723528702472L;

	public static final String EXCEPTION_EMAIL_VACIO = "No se admiten emails vac�os";
	public static final String EXCEPTION_EMAIL_NO_VALIDO = "El formato del email no es correcto";
	public static final String EXCEPTION_PASSWORD_VACIO = "No se admiten contrase�as vac�as";
	public static final String EXCEPTION_PASSWORD_NO_VALIDO = "Minimo 6 caracteres con al menos: 1 mayuscula, 1 minuscula, 1 digito y 1 simbolo especial";

	public PojoException() {

	}

	public PojoException(String message) {
		super(message);

	}

	public PojoException(Throwable cause) {
		super(cause);

	}

	public PojoException(String message, Throwable cause) {
		super(message, cause);

	}

	public PojoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
