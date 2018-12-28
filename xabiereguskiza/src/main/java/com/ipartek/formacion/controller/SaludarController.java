package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaludarController
 */
@WebServlet("/saludarpost")
public class SaludarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		
		try {
			
			request.setAttribute("nombre", nombre);
			request.setAttribute("apellido", apellido);
			request.getRequestDispatcher("privado/respuesta.jsp").forward(request, response);
			
		}catch (Exception e) {
			if (nombre == "" && apellido != "") { 
				
				request.setAttribute("mensaje", "No has rellenado el nombre"); 																					

				request.getRequestDispatcher("privado/saludarpost.jsp").forward(request, response); 
																							
			} else if (nombre != "" && apellido == "") {
				request.setAttribute("mensaje", "No has rellenado el apellido");

				request.getRequestDispatcher("privado/saludarpost.jsp").forward(request, response);
		}else if (nombre == "" && apellido == "") {
			request.setAttribute("mensaje", "No has rellenado ningun campo");

			request.getRequestDispatcher("privado/saludarpost.jsp").forward(request, response);}
	}

}
	
}
