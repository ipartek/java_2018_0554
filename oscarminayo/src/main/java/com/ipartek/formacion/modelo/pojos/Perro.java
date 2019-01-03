package com.ipartek.formacion.modelo.pojos;

public class Perro {
	
	// Atributos
	
		private String nombre;
		private int edad;
		private String raza;
		private int peso;
		private boolean apadrinado;
		private String chip;
		private int latitud;
		private int longitud;
		
		public Perro() {
			super();			
			this.nombre = "Rex";
			this.edad = 6;
			this.raza = "Pastor Aleman";
			this.peso = 22;
			this.apadrinado = false;
			this.chip = "77-1234-2012";
			this.latitud = 56;
			this.longitud = 73;
		}
		
		public Perro(String nombre, String raza, String chip){
			this();
			setNombre(nombre);
			setRaza(raza);
			setChip(chip);
		}
		
		
		
		
		//Getters and setters
		

		public String getNombre() {
			return nombre;
		}
		
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public int getEdad() {
			return edad;
		}
		public void setEdad(int edad) {
			this.edad = edad;
		}
		public String getRaza() {
			return raza;
		}
		public void setRaza(String raza) {
			this.raza = raza;
		}
		public int getPeso() {
			return peso;
		}
		public void setPeso(int peso) {
			this.peso = peso;
		}
		public boolean isApadrinado() {
			return apadrinado;
		}
		public void setApadrinado(boolean apadrinado) {
			this.apadrinado = apadrinado;
		}
		public String getChip() {
			return chip;
		}
		public void setChip(String chip) {
			this.chip = chip;
		}
		public int getLatitud() {
			return latitud;
		}
		public void setLatitud(int latitud) {
			this.latitud = latitud;
		}
		public int getLongitud() {
			return longitud;
		}
		public void setLongitud(int longitud) {
			this.longitud = longitud;
		}
		
		//toString
		@Override
		public String toString() {
			return "Perro [nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + ", peso=" + peso + ", apadrinado="
					+ apadrinado + ", chip=" + chip + ", latitud=" + latitud + ", longitud=" + longitud + "]";
		}
}
