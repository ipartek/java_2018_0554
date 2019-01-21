package com.ipartek.formacion.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.ipartek.formacion.pojo.Persona;

public class Test {
	
	private static String ruta="personas_pruebas.txt";
	private static Integer contadorLineasLeidas=0;
	private static ArrayList<Persona> personas = new ArrayList<>();
	
	 public static void leerFichero(BufferedReader br) throws Exception{
         String linea;
         linea=br.readLine();
         while(linea!=null){
             System.out.println(linea);
             linea=br.readLine();
             contadorLineasLeidas++;
         }
     }
	

     public static void mostrarFichero(){
         FileReader fr=null;
         try{
             File fichero = new File("personas_prueba.txt");
             fr= new FileReader(fichero);
             BufferedReader br= new BufferedReader(fr);
             leerFichero(br);
         }catch(Exception e){
             System.out.println(e.getMessage());
         }finally{
             if(fr!=null){
             try{
                 fr.close();
             }catch(Exception e){
                 System.out.println(e.getMessage());
             }
             }
         }
     }
     
     
	public static void main(String[] args) throws IOException {
		mostrarFichero();
		System.out.println("Total de lineas leidas"+contadorLineasLeidas);
	}

}
