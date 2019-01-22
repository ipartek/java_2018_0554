package com.ipartek.personas.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.personas.modelo.dao.PersonaDao;
import com.ipartek.personas.modelo.pojo.Persona;

/**
 * Servlet implementation class indexController
 */
@WebServlet("/principal")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private	String csvFile="/Users/curso/Desktop/personas.txt";
	private  BufferedReader br = null;
    private   String line = "";
    private  String cvsSplitBy = ",";
    private  Integer personasIncompletas = 0;
    private  Integer lineasLeidas=0;
    private Integer menoresEdad=0;
    private  Integer personasInsertadas=0;
    private ArrayList<Persona> personasInsertar = new ArrayList<>();
	private PersonaDao dao = null;
       
	@Override
	public void init(ServletConfig config) throws ServletException {
		dao = PersonaDao.getInstance();
		super.init(config);
	}
	
	@Override
	public void destroy() {
		super.destroy();
		dao = null;
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    try {
			br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] personas = line.split(cvsSplitBy);

              // System.out.println(personas[0] + personas[1] + personas[2] + personas[3] + personas[4] + personas[5] + personas[6]);
               
               if(personas.length == 7) {
            	   if(Integer.parseInt(personas[3])<18) {
            		   menoresEdad++;
            	   }else {
            		  //dao.insert(personas[0], personas[1], personas[2], Integer.parseInt(personas[3]), personas[4], personas[5]);
            		  Persona p = new Persona(personas[0], personas[1], personas[2], Integer.parseInt(personas[3]), personas[4], personas[5]);
            		  personasInsertar.add(p);
            		  
            		  personasInsertadas++;
            	   }
               }else {
            	   personasIncompletas++;
               }
              
               //Increnmento de las lineas que se han leido, una por cada vuelta
               lineasLeidas++;
            }
            
            //Insertamos todo el array
            dao.insertArray(personasInsertar);
            
            mostrarResumen(response);

		} catch (FileNotFoundException  e) {
			e.printStackTrace();
		}catch (IOException  e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		
		
	}

	private void mostrarResumen(HttpServletResponse response) throws IOException {
		
		System.out.println("");
		response.getWriter().println("-------  RESUMEN --------------------");
		response.getWriter().println("Número de líneas que no tienen 7 campos: " + personasIncompletas);
		response.getWriter().println("Número de líneas leidas: " + lineasLeidas);
		response.getWriter().println("Número de menores de edad: " + menoresEdad);
		response.getWriter().println("Número de personas que se han insertado: " + personasInsertadas);
		response.getWriter().println("-------  FIN RESUMEN --------------------");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
