package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarritoController
 */
public class CarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

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
		
		//recibir parametros => id
		
		// buscar en base datos el Video por Id
		
		//recuperar carrito de session del usuario
		
		// añadimos el nuevo video
		
		// guardamos el carrito en session
		
		// redirect a => http://localhost:8080/javaee/videos
		
		
	}

}
