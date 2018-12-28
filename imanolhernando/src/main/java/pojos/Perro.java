package pojos;

public class Perro {
//	Un perro debe contener las siguientes características: 
//		nombre, edad, raza (en caso de no saber 'milrazas'), 
//		peso (kg), si esta apadrinado o no. 
//		Ademas todos tiene un chip con numero de identificación con
//		el siguiente formato DD-DDDD-AAAA ( D: numero del 0 al 9, AAAA año del chip ),
//		en el chip también se guarda la ultima localización del perro
//		( latitud y longitud ).
	
	private String nombre;
	private Integer edad;
	private String raza;
	private boolean apadrinado;
	Long chip;
	double latitud;
	double longitud;
	
	
	public Perro() {
		super();
		this.nombre = "Sin Nombre";
		this.edad = 0;
		this.raza ="milrazas";
		this.apadrinado = false;
		this.chip = -1L;
		this.latitud = 43.257;
		this.longitud = -2.92344;
	}


	public Perro(String nombre, Integer edad, String raza, boolean apadrinado, Long chip, double latitud,
			double longitud) {
		this();
		setNombre(nombre);
		setEdad( edad);
		setRaza(raza);
		setApadrinado(apadrinado);
		setChip(chip);
		setLatitud(latitud);
		setLongitud( longitud);
	}
	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public String getRaza() {
		return raza;
	}


	public void setRaza(String raza) {
		this.raza = raza;
	}


	public boolean isApadrinado() {
		return apadrinado;
	}


	public void setApadrinado(boolean apadrinado) {
		this.apadrinado = apadrinado;
	}


	public Long getChip() {
		return chip;
	}


	public void setChip(Long chip) {
		this.chip = chip;
	}


	public double getLatitud() {
		return latitud;
	}


	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}


	public double getLongitud() {
		return longitud;
	}


	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}


	@Override
	public String toString() {
		return "Perro [Nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + ", apadrinado=" + apadrinado
				+ ", chip=" + chip + ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}
	
	
	
	
	
}
