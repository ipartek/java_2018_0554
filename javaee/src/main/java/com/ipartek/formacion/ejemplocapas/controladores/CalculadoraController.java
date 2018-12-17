package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculadoraController
 */
public class CalculadoraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("calculadora.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String p1 = request.getParameter("p1");
		String p2 = request.getParameter("p2");
		
		try {
			int i1 = Integer.parseInt(p1);
			int i2 = Integer.parseInt(p2);
		
			request.setAttribute("suma", i1 + i2 );
			request.getRequestDispatcher("resultado.jsp").forward(request, response);
			
		}catch (Exception e) {
			
			request.setAttribute("mensaje", "Por favor rellena los campos con numeros");
			request.getRequestDispatcher("calculadora.jsp").forward(request, response);
		}	
		
		
	}

}
