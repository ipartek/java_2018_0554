package com.ipartek.appMultas.modelo.pojo;

import java.util.ArrayList;
import java.util.HashMap;

public class Agente {
	private Long id;
	private String nombre;
	private String placa;
	private Long id_departamento;
	private HashMap<Long, Multa> multas;
	private Objetivo anual;
	private Objetivo mensual;
	private ArrayList<Objetivo> objetivoMeses;

	public Agente() {
		super();
	}

	public Agente(Long id, String nombre, String placa, Long id_departamento, HashMap<Long, Multa> multas) {
		this();
		setId(id_departamento);
		setNombre(nombre);
		setPlaca(placa);
		setId_departamento(id_departamento);
		setMultas(multas);
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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Long getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(Long id_departamento) {
		this.id_departamento = id_departamento;
	}

	public HashMap<Long, Multa> getMultas() {
		return multas;
	}

	public void setMultas(HashMap<Long, Multa> multas) {
		this.multas = multas;
	}

	public Objetivo getAnual() {
		return anual;
	}

	public void setAnual(Objetivo anual) {
		this.anual = anual;
	}

	public Objetivo getMensual() {
		return mensual;
	}

	public void setMensual(Objetivo mensual) {
		this.mensual = mensual;
	}

	public ArrayList<Objetivo> getObjetivoMeses() {
		return objetivoMeses;
	}

	public void setObjetivoMeses(ArrayList<Objetivo> objetivoMeses) {
		this.objetivoMeses = objetivoMeses;
	}

	@Override
	public String toString() {
		return "Agente [id=" + id + ", nombre=" + nombre + ", placa=" + placa + ", id_departamento=" + id_departamento
				+ ", multas=" + multas + ", anual=" + anual + ", mensual=" + mensual + ", objetivoMeses="
				+ objetivoMeses + "]";
	}
}
