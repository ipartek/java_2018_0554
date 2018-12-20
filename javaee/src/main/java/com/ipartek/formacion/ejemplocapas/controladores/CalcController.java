package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op1 = request.getParameter("op1");
		String op2 = request.getParameter("op2");
		
		try {
			int num1 = Integer.parseInt(op1);
			int num2 = Integer.parseInt(op2);
			
			request.setAttribute("suma", num1 + num2);
			
			request.getRequestDispatcher("resultado.jsp").forward(request, response);
			
		}catch(Exception e) {
			
			request.setAttribute("message", "Los numeros introducidos no son válidos");
			
			request.getRequestDispatcher("calculadora.jsp").forward(request, response);
		}

		
		

	}

}
