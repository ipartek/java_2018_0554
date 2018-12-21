package com.ipartek.formacion.libroCompartido.modelo.pojo;

import java.util.HashMap;

public class Libro {

	private Long id;
	private int paginaActual;
	private int totalPaginas;
	private HashMap<Long, Pagina> paginas;

	public Libro() {
		super();
	}

	public Libro(Long id, int paginaActual, HashMap<Long, Pagina> paginas,int totalPaginas) {
		this();
		setId(id);
		setPaginaActual(paginaActual);
		setPaginas(paginas);
		setTotalPaginas(totalPaginas);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPaginaActual() {
		return paginaActual;
	}

	public void setPaginaActual(int paginaActual) {
		this.paginaActual = paginaActual;
	}

	public HashMap<Long, Pagina> getPaginas() {
		return paginas;
	}

	public void setPaginas(HashMap<Long, Pagina> paginas) {
		this.paginas = paginas;
	}

	public int getTotalPaginas() {
		return totalPaginas;
	}

	public void setTotalPaginas(int totalPaginas) {
		this.totalPaginas = totalPaginas;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", paginaActual=" + paginaActual + ", totalPaginas=" + totalPaginas + ", paginas="
				+ paginas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + paginaActual;
		result = prime * result + ((paginas == null) ? 0 : paginas.hashCode());
		result = prime * result + totalPaginas;
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
		Libro other = (Libro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (paginaActual != other.paginaActual)
			return false;
		if (paginas == null) {
			if (other.paginas != null)
				return false;
		} else if (!paginas.equals(other.paginas))
			return false;
		if (totalPaginas != other.totalPaginas)
			return false;
		return true;
	}



}
