package com.ipartek.formacion.migracion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class App {

	// nombre fichero a leer
	static final String FILE_PERSONAS = "C:\\0554\\workspace\\java_2018_0554\\migracion\\src\\main\\resources\\personas.min.txt";

	// contadores
	static int contLineasLeidas = 0;
	static int contInsert = 0;
	static int cont7Campos = 0; // contador lineas <> 7 campos
	static int contEdad = 0; // contador lienas edad < 18

	static final int NUMERO_CAMPOS_LINEA = 7;
	static final int CAMPO_NOMBRE = 0;
	static final int CAMPO_APELLIDO1 = 1;
	static final int CAMPO_APELLIDO2 = 2;
	static final int CAMPO_EDAD = 3;
	static final int CAMPO_EMAIL = 4;
	static final int CAMPO_DNI = 5;
	// static final int CAMPO_PUESTO = 6;

	public static void main(String[] args) {
		System.out.println("Comezamos migracion....");

	

		try ( BufferedReader br = new BufferedReader( new FileReader( new File( FILE_PERSONAS ) )) ){
			
			// Lectura del fichero linea a linea
			String linea;
			while ((linea = br.readLine()) != null) {
				
				contLineasLeidas++;				
				System.out.println(linea);
				
				String[] aCampos = linea.split(",");
				if ( aCampos.length == NUMERO_CAMPOS_LINEA ) {
					
		
					try {
						int edad = Integer.parseInt(aCampos[CAMPO_EDAD]);
						if( edad >= 18 ) {            
							
		  // insert en bbdd
							contInsert++;
		
							
		 // menor edad					
						}else {
							contEdad++;
						}						
					}catch (Exception e) {						
						contEdad++;
					}	
		 // No tenemos 7 campos	
				}else {                                           
					cont7Campos++;
				}
				

				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mostrarResumen();

	}

	private static void mostrarResumen() {

		System.out.println("");
		System.out.println("-------  RESUMEN --------------------");
		System.out.println("");
		System.out.println(" Lineas Leidas: " + contLineasLeidas);
		System.out.println(" Lineas Insertadas: " + contInsert);
		System.out.println(" Lineas que no tienen 7 campos: " + cont7Campos);
		System.out.println(" Lineas meores edad: " + contEdad);
		System.out.println("-----------------------------------------");

	}

}
