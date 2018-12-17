package com.ipartek.formacion.ejemplocapas.pojos;

public class PojoException extends RuntimeException {

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
