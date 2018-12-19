package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculadoraController
 */
public class CalcularController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String p1 = request.getParameter("p1");
		String p2 = request.getParameter("p2");

		try {

			String operacion = request.getParameter("operacion");

			double i1 = Double.parseDouble(p1);
			double i2 = Double.parseDouble(p2);

			switch (operacion) {
			case "suma":
				request.setAttribute("resultado", i1 + i2);
				break;
			case "resta":
				request.setAttribute("resultado", i1 - i2);
				break;
			case "multiplicacion":
				request.setAttribute("resultado", i1 * i2);
				break;
			case "division":
				request.setAttribute("resultado", i1 / i2);
				break;
			}

			request.getRequestDispatcher("resultado.jsp").forward(request, response);

		} catch (Exception e) {
			if (p1 == "" && p2 != "") { 
										
				request.setAttribute("error", "No has rellenado el primer numero"); 
																					

				request.getRequestDispatcher("calculadora.jsp").forward(request, response); 
																							
			} else if (p1 != "" && p2 == "") {
				request.setAttribute("error", "No has rellenado el segundo numero");

				request.getRequestDispatcher("calculadora.jsp").forward(request, response);
			} else if (p1 == "" && p2 == "") {
				request.setAttribute("error", "No has rellenado ningun numero");

				request.getRequestDispatcher("calculadora.jsp").forward(request, response);
			}

		}
	}
}
