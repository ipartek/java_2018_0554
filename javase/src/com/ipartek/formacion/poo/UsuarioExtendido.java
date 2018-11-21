package com.ipartek.formacion.poo;

public class UsuarioExtendido extends Usuario {
// Si no se pone se crea automáticamente este constructor:
	
//	public UsuarioExtendido() {
//		super();
//	}
	private String nombre;
	
	public UsuarioExtendido(String nombre, String email, String password) {
		super(email, password);
		setNombre(nombre);
	}
	
	public UsuarioExtendido(String nombre) {
		this(nombre, EMAIL_POR_DEFECTO, PASSWORD_POR_DEFECTO);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String datosCompletos() {
		return nombre + ", " + super.datosCompletos();
	}

	@Override
	public String datosCompletos(String formato) {
		String extra;
		
		switch(formato) {
		case FORMATO_CORCHETES: extra = "[nombre: " + nombre + "]"; break;
		case FORMATO_COMA: extra = nombre + ", "; break;
		default: throw new RuntimeException("No existe el formato " + formato);
		}
		return extra + super.datosCompletos(formato);
	}
	
	
}
