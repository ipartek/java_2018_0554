package com.persona.controladores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Persona {

	public static void main(String[] args) {
		
		int contarLineas=0;
		int contarElementosArray=0; // de 0 a 7
		int contarAdultos=0;		// cuantos mayores de edad (campos[3]>=18)
		int menor = 0;
		int elementos=0;
		
		//leer linear, separar por comas y agrupar en un array
		
		final String SEPARADOR = ",";


		 
		 BufferedReader bufferLectura = null;
		 try {
			 // Abrir el .csv en buffer
			 bufferLectura = new BufferedReader(new FileReader("pocaspersonas.csv"));
		  
			 // Leer una linea del archivo
			 String linea = bufferLectura.readLine();
		  
			 while (linea != null) {
				 
				 // Sepapar la linea leída con el separador definido previamente
				 String[] campos = linea.split(SEPARADOR); 
				 String edad=campos[3]; // asignamos el campo de indice 3 (edad) en la variable edad
				 
				  menor=Integer.parseInt(edad);
				  elementos=campos.length;
				  if(menor>18) {
					  contarAdultos++;
					  
				  }
				  
				  if(elementos<6) {
					  
					  contarElementosArray++;
					  
				  }
				 //añadida la condicion, hará su función en el momento de mostrarse la lista
		   System.out.println(Arrays.toString(campos));
		   
		   		// Volver a leer otra línea
		   	linea = bufferLectura.readLine();
		   	
		   	contarLineas++; //se suma cada fila que se inserta
		  }
			 
		 } 
		 catch (IOException e) {
		  e.printStackTrace();
		 }
		 finally {  //TODO esto de cerrar todo despues de hacer el asunto resumirlo porque esta obsoleto
		  // Cierro el buffer de lectura
			 
		  if (bufferLectura != null) {
		   try {
		    bufferLectura.close();
		   } 
		   catch (IOException e) {
		    e.printStackTrace();
		   }
		  }
		 
		  System.out.println("Numero de lineas leidas: "+contarLineas);
		  System.out.println("Adultos en la lista: "+contarAdultos);
		  System.out.println("Registros con todos los valores: "+contarElementosArray);
		 }
		 
		 //Insertar lineas, pero evitar las de campos[3]<18
		 
//		 while {
//			 
//			 if (campos[3]<18) {
//				 
//			 }
//		 }
		 
		}
	}


