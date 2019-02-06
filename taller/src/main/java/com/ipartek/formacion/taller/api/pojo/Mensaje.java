package com.ipartek.formacion.taller.api.pojo;

import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.ipartek.formacion.taller.modelo.pojo.Combustible;

public class Mensaje {

	private String mensaje;
	private ArrayList<ErrorMensaje> errores;

	public Mensaje() {
		super();
		this.mensaje = "";
		this.errores = null;
	}

	public Mensaje(String mensaje) {
		this();
		this.setMensaje(mensaje);
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public ArrayList<ErrorMensaje> getErrores() {
		return errores;
	}

	public void setErrores(ArrayList<ErrorMensaje> errores) {
		this.errores = errores;
	}

	@Override
	public String toString() {
		return "Mensaje [mensaje=" + mensaje + ", errores=" + errores + "]";
	}

	/* clase Interna */

	class ErrorMensaje {

		private String campo;
		private String violacion;

		ErrorMensaje() {
			super();
			this.campo = "";
			this.violacion = "";
		}

		public ErrorMensaje(String campo, String violacion) {
			this();
			this.campo = campo;
			this.violacion = violacion;
		}

		public String getCampo() {
			return campo;
		}

		public void setCampo(String campo) {
			this.campo = campo;
		}

		public String getViolacion() {
			return violacion;
		}

		public void setViolacion(String violacion) {
			this.violacion = violacion;
		}

	}

	public void addViolations(Set<ConstraintViolation<Combustible>> violations) {
		
		if ( violations != null ) {
			this.errores = new ArrayList<ErrorMensaje>();			
			for( ConstraintViolation<Combustible> v : violations ) {			
				ErrorMensaje errorMensaje = new ErrorMensaje( v.getPropertyPath().toString() , v.getMessage() );
				this.errores.add(errorMensaje);				
			}				
		}		
	}

}
