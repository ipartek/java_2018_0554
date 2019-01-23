package com.ipartek.appMultas.modelo.pojo;

public class Objetivo {

	private String mes;
	private Double anio;
	private Double importeTotal;

	public Objetivo() {
		super();
	}

	public Objetivo(String mes, Double anio, Double importeTotal) {
		this();

		setMes(mes);
		setAnio(anio);
		setImporteTotal(importeTotal);
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public Double getAnio() {
		return anio;
	}

	public void setAnio(Double anio) {
		this.anio = anio;
	}

	public Double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(Double importeTotal) {
		this.importeTotal = importeTotal;
	}

	@Override
	public String toString() {
		return "Objetivo [mes=" + mes + ", anio=" + anio + ", importeTotal=" + importeTotal + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anio == null) ? 0 : anio.hashCode());
		result = prime * result + ((importeTotal == null) ? 0 : importeTotal.hashCode());
		result = prime * result + ((mes == null) ? 0 : mes.hashCode());
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
		Objetivo other = (Objetivo) obj;
		if (anio == null) {
			if (other.anio != null)
				return false;
		} else if (!anio.equals(other.anio))
			return false;
		if (importeTotal == null) {
			if (other.importeTotal != null)
				return false;
		} else if (!importeTotal.equals(other.importeTotal))
			return false;
		if (mes == null) {
			if (other.mes != null)
				return false;
		} else if (!mes.equals(other.mes))
			return false;
		return true;
	}

}
