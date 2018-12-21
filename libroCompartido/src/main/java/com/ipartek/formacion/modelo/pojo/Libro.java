package com.ipartek.formacion.modelo.pojo;

import java.util.HashMap;

public class Libro {
	
	private HashMap<Long, Pagina> paginas;
	private Long paginaActual;
	
	
	public Libro() {
		super();
	}
	
	
	public Libro(HashMap<Long, Pagina> paginas, Long paginaActual) {
		this();
		this.paginas = paginas;
		this.paginaActual = paginaActual;
	}
	
	public Long getPaginaActual() {
		return paginaActual;
	}
	public void setPaginaActual(Long paginaActual) {
		this.paginaActual = paginaActual;
	}

	public HashMap<Long, Pagina> getPaginas() {
		return paginas;
	}


	public void setPaginas(HashMap<Long, Pagina> paginas) {
		this.paginas = paginas;
	}

	@Override
	public String toString() {
		return "Libro [paginas=" + paginas + ", paginaActual=" + paginaActual + "]";
	}
	
	

}
