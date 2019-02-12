package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/saludo")
public class saludoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public saludoController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	doPost (request,response);  // Para trabajar 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	try {
		// RECOJO PARÁMETROS
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2= request.getParameter("apellido2");
					
		
		//GENERO RESPUESTA
		request.setAttribute("nombre", nombre );
		request.setAttribute("apellido1", apellido1 ); 
		request.setAttribute("apellido2", apellido2 ); 
	
	}catch (Exception e) {
		e.printStackTrace();
	
	}finally {
		//ENVIO RESPUESTA
		request.getRequestDispatcher("principal.jsp").forward(request, response);	
		}
		
	}

}
