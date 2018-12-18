package com.ipartek.formacion.calcular;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Calculator() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String op1 = request.getParameter("op1");
			String op2 = request.getParameter("op2");
			
			int op1Int=Integer.parseInt(op1);
			int op2Int=Integer.parseInt(op2);

			request.setAttribute("suma", op1Int+op2Int);

			request.getRequestDispatcher("resultado.jsp").forward(request, response);
			
		} catch (Exception e) {
			request.setAttribute("mensaje","por favor, rellena el campo con numeros");
			request.getRequestDispatcher("calculadora.jsp").forward(request, response);
		}

		// obtener variables de calculadora.jsp

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
