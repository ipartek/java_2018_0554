package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaludarSrvLt
 */
@WebServlet("/saludars")
public class SaludarSrvLt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String nombre=request.getParameter("nombre");
		String apellidos=request.getParameter("apellidos");
		String metodo=request.getParameter("met");
		
		
		
		if (metodo!=null) {
			
			request.setAttribute("metodo", metodo);
			
			request.getRequestDispatcher("/privado/formsaludo.jsp").forward(request, response);
		}else {

			request.setAttribute("nombre", nombre);
			request.setAttribute("apellidos", apellidos);
			request.setAttribute("metodo", "get");
			
			request.getRequestDispatcher("/privado/saludar.jsp").forward(request, response);
			
		}
		
	
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=request.getParameter("nombre");
		String apellidos=request.getParameter("apellidos");
		
		request.setAttribute("nombre", nombre);
		request.setAttribute("apellidos", apellidos);
		request.setAttribute("metodo", "post");
		
		request.getRequestDispatcher("/privado/saludar.jsp").forward(request, response);
		
	}

}
