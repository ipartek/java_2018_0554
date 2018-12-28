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
@WebServlet("/saludar")
public class SaludarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaludarController() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		try {
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			
			request.setAttribute("mensaje", "wellcome " + nombre + " " + apellidos);
			request.getRequestDispatcher("privado/welcome.jsp").forward(request, response);
			}catch(Exception e) {
				request.setAttribute("mensaje", "Introduce tu nombre y apellidos");
				request.getRequestDispatcher("privado/saludar.jsp").forward(request, response);
				
			}
	}

}
