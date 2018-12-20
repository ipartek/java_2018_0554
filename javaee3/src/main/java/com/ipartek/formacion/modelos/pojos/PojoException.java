package com.ipartek.formacion.modelos.pojos;

public class PojoException extends RuntimeException {
	
	public static final String MAIL_VACIO="No se permiten emails vacios";
	public static final String MAIL_NO_VALIDO="Formato de correo no valido";
	public static final String PASS_VACIO="No se admiten contraseñas vacias";
	public static final String PASS_NO_VALIDO="Formato de contraseña no valido (min 6 caracteres con al menos 1 mayus, 1minu,1 num y 1 simbolo";

	private static final long serialVersionUID = 6476469723528702472L;

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
