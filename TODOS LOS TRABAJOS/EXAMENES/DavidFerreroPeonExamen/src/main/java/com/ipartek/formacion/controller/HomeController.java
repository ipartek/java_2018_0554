package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


import com.ipartek.formacion.modelo.pojo.HomePojo;
import com.ipartek.formacion.modelo.pojo.LoginPojo;

/**
 * Servlet implementation class PaginaControllerB
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<HomePojo> perros; // declaro array list
	
	
// METODO INIT
	@Override
	public void init(ServletConfig config) throws ServletException {  // PREGUNTAR QUE METODO ES ESTE Y PORQUE METO EL ARRAYLIST AQUI.	
	super.init(config);

		perros = new ArrayList <HomePojo>(); //Creo array list
		
		perros.add(new HomePojo("Negu","PerroAguas","media/perroAguas.jpg",6,18,1133312018));
		perros.add( new HomePojo("Pluto ","Gran Danes","media/granDanes.jpg",3,9,1133322018));
		perros.add( new HomePojo("Rex","Pastor Aleman","media/pastoAleman.jpg",1,12,1133332018 ));
		perros.add( new HomePojo("Tolo","milrazas","media/sinRaza.jpg",8,35,1133342018 ));
		perros.add( new HomePojo("Laika","Pasto Belga","media/pastorBelga.jpg",11,45,1133352018));
		
	}
				

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Inizializo variables
		int paginaActual=0;// Inicializo variable
		boolean redirect = false;
		int paginaPedida = 0;
		int borrar = 0;
		String listado= null;
		int reciboChip= 0;
		int reciboEdad= 0;
		int reciboPeso= 0;
		

	
		try { 

		// RECOGER PARAMETROS
			
			
			
			// recojo parametro de autor nuevo en nuevaPagina.jsp
			String nuevoImagen= request.getParameter("imagen");
	
			// recojo parametro de texto nuevo en nuevaPagina.jsp
			String nuevoRaza = request.getParameter("raza");
			
			// recojo parametro de autor nuevo en nuevaPagina.jsp
			String nuevoNombre = request.getParameter("nombre");
			
			// recojo parametro de autor nuevo en nuevaPagina.jsp
			String nuevoEdad= request.getParameter("edad");
			
			// recojo parametro de autor nuevo en nuevaPagina.jsp
			String nuevoPeso= request.getParameter("peso");
			
			
			// recojo parametro de autor nuevo en nuevaPagina.jsp
			String nuevoChip= request.getParameter("chip");
		
	
		
			
			// recojo parametro para listadoPagina.jsp
			listado = request.getParameter("listado");
			
			// recojo parametro para usuario
			String usuarioEmail = request.getParameter("usuarioEmail");
			
	
//-------------------------------------LOGICA----------------------------			
		
			
			
		// LOGICA CREAR PERRO
			if (nuevoRaza!= null && nuevoNombre!=null && nuevoChip!=null) {  
				reciboChip = Integer.parseInt(nuevoChip); 
				HomePojo nuevoPerro = new HomePojo (nuevoNombre,nuevoRaza,reciboChip);	
	    
				// Creo nuevo objeto para añadir al hashmap 
				perros.add((perros.size() ),nuevoPerro);  // OJO UTILIZAR .PUT EN LUGAR DE .ADD CUANDO USE HASHMAP
				request.setAttribute("mensajeNewPerro", "Has incluido un nuevo Perro" ); 
			}
		
			// LOGICA PARA LISTADO	
			if (listado !=null) {			
				request.setAttribute("perros", perros ); 
				redirect=true;
			}
			
			// LOGICA PARA DETALLE DE PERRO
			if (nuevoNombre.equals("")==false ) {
			
				
				HomePojo detalle = new HomePojo();
				
				detalle.setImagen(nuevoImagen);
				detalle.setNombre(nuevoNombre);
				detalle.setRaza(nuevoRaza);
			
				
				request.setAttribute("detalleImagen", detalle.getImagen() ); 
				request.setAttribute("detalleNombre", detalle.getNombre()); 
				request.setAttribute("detalleRaza", detalle.getRaza()); 
			
		}
			
			
			// LOGICA LOGOUT
			if (usuarioEmail.equals("")== false) {
			request.setAttribute("usuarioEmail", usuarioEmail ); 	// respuesta para logout
			}
	
		}catch (Exception e){ 
			e.printStackTrace(); 
			
		}finally{
			if (redirect==true) {
				request.getRequestDispatcher("listado.jsp").forward(request, response);
				
				}else {
					request.setAttribute("libro", perros ); // para datos productos
					request.getRequestDispatcher("principal.jsp").forward(request, response);		
				}
		}
		
}
}

