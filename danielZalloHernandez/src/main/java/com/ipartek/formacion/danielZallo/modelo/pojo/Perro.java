package com.ipartek.formacion.danielZallo.modelo.pojo;

public class Perro {
	private Long id;
	private String nombre;
	private Long edad;
	private String raza; //Si no se especifica sera --> milrazas
	private Double peso;
	private String apadrinado; //Este sera si o no
	//Tiene un objeto chip
	private Chip chipAsignado;
	
	
	public Perro() {
		super();
		
	}

	public Perro(Long id, String nombre, Long edad, String raza, Double peso, String apadrinado, Chip chipAsignado) {
		super();
		setId(id);
		setNombre(nombre);
		setEdad(edad);
		setRaza(raza);
		setPeso(peso);
		setApadrinado(apadrinado);
		setChipAsignado(chipAsignado);
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
	public Long getEdad() {
		return edad;
	}
	public void setEdad(Long edad) {
		this.edad = edad;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		if(raza.equals("")) {
			raza="milrazas";
		}
		
		this.raza = raza;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public String getApadrinado() {
		return apadrinado;
	}
	public void setApadrinado(String apadrinado) {
		this.apadrinado = apadrinado;
	}
	public Chip getChipAsignado() {
		return chipAsignado;
	}
	public void setChipAsignado(Chip chipAsignado) {
		this.chipAsignado = chipAsignado;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apadrinado == null) ? 0 : apadrinado.hashCode());
		result = prime * result + ((chipAsignado == null) ? 0 : chipAsignado.hashCode());
		result = prime * result + ((edad == null) ? 0 : edad.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
		result = prime * result + ((raza == null) ? 0 : raza.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perro other = (Perro) obj;
		if (apadrinado == null) {
			if (other.apadrinado != null)
				return false;
		} else if (!apadrinado.equals(other.apadrinado))
			return false;
		if (chipAsignado == null) {
			if (other.chipAsignado != null)
				return false;
		} else if (!chipAsignado.equals(other.chipAsignado))
			return false;
		if (edad == null) {
			if (other.edad != null)
				return false;
		} else if (!edad.equals(other.edad))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		if (raza == null) {
			if (other.raza != null)
				return false;
		} else if (!raza.equals(other.raza))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Perro [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + ", peso=" + peso
				+ ", apadrinado=" + apadrinado + ", chipAsignado=" + chipAsignado + "]";
	}
	
	
	
	
	
	
}
