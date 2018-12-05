package com.ipartek.formacion.repaso;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EmpleadoIndefinido extends Empleado {
	private BigDecimal sueldoAnual;
	private int numeroDePagas;
	
	public EmpleadoIndefinido(Long id, String nombre, String apellidos, String numeroSeguridadSocial, String dni,
			BigDecimal sueldoAnual, int numeroDePagas) {
		super(id, nombre, apellidos, numeroSeguridadSocial, dni);
		this.sueldoAnual = sueldoAnual;
		this.numeroDePagas = numeroDePagas;
	}

	public BigDecimal getSueldoAnual() {
		return sueldoAnual;
	}

	public void setSueldoAnual(BigDecimal sueldoAnual) {
		this.sueldoAnual = sueldoAnual;
	}

	public int getNumeroDePagas() {
		return numeroDePagas;
	}

	public void setNumeroDePagas(int numeroDePagas) {
		this.numeroDePagas = numeroDePagas;
	}

	@Override
	public BigDecimal getSueldoMensual() {
		return sueldoAnual.divide(new BigDecimal(numeroDePagas), 2, RoundingMode.HALF_UP);
	}

	@Override
	public String toString() {
		return super.toString() + " EmpleadoIndefinido [sueldoAnual=" + sueldoAnual + ", numeroDePagas=" + numeroDePagas + "]";
	}
	
	
}
