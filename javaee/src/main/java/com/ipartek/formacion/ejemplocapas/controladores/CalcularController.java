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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/*
		String p1 = request.getParameter("p1");
		String p2 = request.getParameter("p2");
		
		try {
			
			String operacion = request.getParameter("operacion");
			
			
			
			if(p1 != "" && p2 != "") {
				double i1 = Double.parseDouble(p1);
				double i2 = Double.parseDouble(p2);
				//TODO switch(+ - * /)
				if(sumar != null && restar == null && multiplicar == null && dividir == null) {
			request.setAttribute("resultado", i1 + i2 );
			
			
			}else if(sumar == null && restar != null && multiplicar == null && dividir == null) {
				request.setAttribute("resultado", i1 - i2 );
			}else if(sumar == null && restar == null && multiplicar != null && dividir == null) {
				request.setAttribute("resultado", i1 * i2 );
			}else if(sumar == null && restar == null && multiplicar == null && dividir != null) {
				request.setAttribute("resultado", i1 / i2 );
			}
				}
			request.getRequestDispatcher("resultado.jsp").forward(request, response);
		}catch (Exception e) {
			if (p1 == "" && p2 != "") {	 													// utilizo "" en vez de null para indicar el campo vacio (en el que no se han introducido datos) porque Op1 ES UN STRING. NO ES ENTERO
				request.setAttribute("error", "No has rellenado el primer numero" );  			// envio parametro error con valor string menssaje
		
				request.getRequestDispatcher("calculadora.jsp").forward(request, response);			// ENVIO LA RESPUESTA A ERRORES.JSP
			}
			else if (p1 !="" && p2 == "") {
				request.setAttribute("error", "No has rellenado el segundo numero");  			
			
				request.getRequestDispatcher("calculadora.jsp").forward(request, response);
			}
			else if (p1 == "" && p2 == "") {
				request.setAttribute("error", "No has rellenado ningun numero" );  				
			
				request.getRequestDispatcher("calculadora.jsp").forward(request, response);
			}
		
		}	*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		doGet(request, response);
	}

}
