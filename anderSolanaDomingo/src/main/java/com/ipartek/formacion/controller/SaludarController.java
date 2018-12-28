package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SaludarController
 */
@WebServlet("/privada/saludar")
public class SaludarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		
		HttpSession session = request.getSession();
		session.setAttribute("nombre_saludo", nombre);
		session.setAttribute("apellido_saludo", apellido);
		
		request.getRequestDispatcher("/privada/saludar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		
		HttpSession session = request.getSession();
		session.setAttribute("nombre_saludo", nombre);
		session.setAttribute("apellido_saludo", apellido);
		
		request.getRequestDispatcher("/privada/saludar.jsp").forward(request, response);
	}

}
