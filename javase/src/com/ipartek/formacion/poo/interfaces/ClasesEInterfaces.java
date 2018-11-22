package com.ipartek.formacion.poo.interfaces;

class Fruto {}
class ObjetoDeporte {}

interface Rodable {
	void rodar();
}

interface Comestible {
	void comer();
}

class Naranja extends Fruto implements Comestible, Rodable {

	@Override
	public void rodar() {
		System.out.println("Naranja rodando");
	}

	@Override
	public void comer() {
		System.out.println("Ñam, que rica");
	}
}

class Balon extends ObjetoDeporte implements Rodable {

	@Override
	public void rodar() {
		System.out.println("Balón rodando");
	}
}

