package com.ipartek.formacion.danielZallo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaludarPostController
 */
@WebServlet("/privado/saludarPost")
public class SaludarPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("saludarPost.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		
		if(nombre.equals("") || apellido.equals("")) {
			request.setAttribute("alerta", "Tienes que introducir un nombre y un apellido");
			request.getRequestDispatcher("saludarPost.jsp").forward(request, response);
		}else {
			request.setAttribute("nombre", nombre);
			request.setAttribute("apellido", apellido);
			request.getRequestDispatcher("resultadoSaludar.jsp").forward(request, response);
		}
	}

}
