package com.ipartek.formacion.repaso2;

import com.ipartek.formacion.repaso.*;

public class Prueba2 {
	public static void main(String[] args) {
		//Empleado e; // No accesible debido al nivel de visibilidad de (paquete)
		
		int[] arr = new int[2];
		
		arr[0] = 5;
		arr[1] = 10;
		
		System.out.println(arr.length);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		int[] copia = arr.clone();
		
		copia[0] = 100;
		
		for(int dato : arr) { // Java5
			System.out.println(dato);
		}
		
		arr = copia;
		
		copia = null;
		
		for(int dato : arr) {
			System.out.println(dato);
		}
	}

}
