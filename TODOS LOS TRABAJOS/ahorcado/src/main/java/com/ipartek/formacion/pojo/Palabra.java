package com.ipartek.formacion.pojo;

public class Palabra {
	private Long id;
	private String letra1;

	private String letra2;
	



	public Palabra() {
	
			super();
			this.id = -3L ;
			this.letra1 = "";
			this.letra2 = "";
		}

	

	public Palabra(Long id, String letra1, String letra2) {
		super();
		setId(id);
		setLetra1(letra1);
		setLetra2(letra2);
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLetra1() {
		return letra1;
	}


	public void setLetra1(String letra1) {
		this.letra1 = letra1;
	}


	public String getLetra2() {
		return letra2;
	}


	public void setLetra2(String letra2) {
		this.letra2 = letra2;
	}



	@Override
	public String toString() {
		return "Palabra [id=" + id + ", letra1=" + letra1 + ", letra2=" + letra2 + "]";
	}




	
	
	}

