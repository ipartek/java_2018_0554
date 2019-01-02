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
@WebServlet(name = "/saludar", urlPatterns = { "/saludar" })

public class SaludarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String nombreGet = request.getParameter("nombreGet");
		String apellidoGet = request.getParameter("apellidoGet");
		
		request.setAttribute("nombreGet", nombreGet);
		request.setAttribute("apellidoGet", apellidoGet);
		
		request.getRequestDispatcher("privado/saludar.jsp").forward(request, response);
//		response.sendRedirect("privado/saludar.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		
		request.setAttribute("nombre", nombre);
		request.setAttribute("apellido", apellido);
		
		request.getRequestDispatcher("privado/saludar.jsp").forward(request, response);

	}

}
