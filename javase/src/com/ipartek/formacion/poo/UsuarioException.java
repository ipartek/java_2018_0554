package com.ipartek.formacion.poo;

public class UsuarioException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9154974936848168060L;

	public UsuarioException() {
		
	}

	public UsuarioException(String message) {
		super(message);
		
	}

	public UsuarioException(Throwable cause) {
		super(cause);
		
	}

	public UsuarioException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UsuarioException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
