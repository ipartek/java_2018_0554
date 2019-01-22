package com.personas.migracion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Persona {
	public static int countLineas = 0;
	public static int countMenores = 0;
	public static int countCampos = 0;
	private static String[] datos;
	
	
	
	
	public static void main(String[] args) throws IOException {
		String csvFile = "personas.csv";
		BufferedReader br = null;
		String line = "";
		//Se define separador ","
		String cvsSplitBy = ",";
		
		try {
			// TODO autoclosable buffered
		    br = new BufferedReader(new FileReader(csvFile));
		    while ((line = br.readLine()) != null) {  
		    			    	
		        String[] datos = line.split(cvsSplitBy);
		        
		        String edad = datos[3];
		    	int menor = Integer.parseInt(edad);
		        countLineas ++;
		        //Imprime datos.
		       System.out.println(datos[0] + ", " + datos[1] + ", " + datos[2] + ", " + datos[3] + ", " + datos[4] + ", " + datos[5] );
		       
		       
		       //condicion para sacar numero menores de edad
		       if(menor < 18) {
		    	   countMenores ++;
		    	   System.out.println(countMenores);
		       }
		       
		       //condicion para sacar los que tienen los 6 campos(solo hay uno que no --> Jean,Terradillos,37,JeanLMitton@mailinator.com,14075592Y,TRABAJADOR)
		       /*  int campos = datos.length;
		       if(campos <=7) {
		    	   countCampos ++;
		    	   
		       } */
		       
		       
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    if (br != null) {
		        try {
		            br.close();
		            System.out.println(countLineas);
		            System.out.println(countMenores);
		            //System.out.println(countCampos);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
	}

}
	
}
