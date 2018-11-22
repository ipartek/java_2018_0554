package com.ipartek.formacion.poo.interfaces;

public class Interfaces {
	public static void main(String[] args) {
		Rodable[] rodables = new Rodable[2];
		
		rodables[0] = new Naranja();
		rodables[1] = new Balon();
		
		for(Rodable rodable: rodables) {
			rodable.rodar();
			
			if(rodable instanceof Comestible) {
				Comestible comestible = (Comestible)rodable;
				comestible.comer();
			}
		}
	}
}
