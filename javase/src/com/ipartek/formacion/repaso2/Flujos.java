package com.ipartek.formacion.repaso2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Flujos {

	private static final boolean AUTO_FLUSH = true;
	private static final boolean APPEND = true;

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.print("Dime tu nombre: ");
		
		String nombre = br.readLine();
		
		System.out.println("Hola " + nombre);
		
		FileWriter fw = new FileWriter("prueba.txt", APPEND);
		PrintWriter pw = new PrintWriter(fw, AUTO_FLUSH);
		
		pw.println("El nombre es " + nombre);
		
		pw.close();
		fw.close();
		
		FileReader fr = new FileReader("pruebas.txt");
		BufferedReader brf = new BufferedReader(fr);
		
		String linea;
		
		while( ( linea = brf.readLine()) != null) {
			System.out.println("LINEA DEL FICHERO: " + linea);
		}
		
		brf.close();
		fr.close();
	}

}
