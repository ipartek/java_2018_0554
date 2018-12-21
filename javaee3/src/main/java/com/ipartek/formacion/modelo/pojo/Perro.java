package com.ipartek.formacion.modelo.pojo;

public class Perro {

	private Long id;
	private String nombre;
	private String raza;
	
	//Constructores
		public Perro() {
			super();
			this.id = (long) -1;
			this.nombre ="";
			this.raza ="";
		}
		

		public Perro(String nombre) {
			this();
			this.nombre = nombre;
		
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


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getRaza() {
			return raza;
		}


		public void setRaza(String raza) {
			this.raza = raza;
		}


		@Override
		public String toString() {
			return "Perro [id=" + id + ", nombre=" + nombre + ", raza=" + raza + "]";
		}
		
		
}
