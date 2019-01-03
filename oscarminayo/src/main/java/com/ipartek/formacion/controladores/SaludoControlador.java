package com.ipartek.formacion.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaludoControlador
 */
@WebServlet("/privado/saludar")
public class SaludoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		
try {
			
			request.setAttribute("nombre", nombre);
			request.setAttribute("apellido", apellido);
			
			request.getRequestDispatcher("resultadoGet.jsp").forward(request, response);
			
		}catch (Exception e) {
			
			request.getRequestDispatcher("principal.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		
		try {
			
			request.setAttribute("nombre", nombre);
			request.setAttribute("apellido1", apellido1);
			request.setAttribute("apellido2", apellido2);
			request.getRequestDispatcher("resultadoPost.jsp").forward(request, response);
			
		}catch (Exception e) {
			
			request.getRequestDispatcher("principal.jsp").forward(request, response);
		}
		
	}
		
		
	}


