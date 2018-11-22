package com.ipartek.formacion.poo.clasesabstractas;

public class ClasesAbstractas {

	public static void main(String[] args) {
		Number[] numeros = new Number[2];
		
		Integer entero = new Integer(5);
		Double doble = new Double(6.7);
		
		numeros[0] = entero;
		numeros[1] = doble;
		
		for(Number numero: numeros) {
			System.out.println(numero.doubleValue());
		}
	}
}
