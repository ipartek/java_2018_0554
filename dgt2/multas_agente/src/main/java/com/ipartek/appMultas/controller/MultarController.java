package com.ipartek.appMultas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.appMultas.modelo.pojo.Coche;

/**
 * Servlet implementation class MultarController PARA DAR DE ALTA LA MULTA
 */
@WebServlet("/privado/multar")
public class MultarController extends HttpServlet {
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
		// Llama al controlador matricula para cargar matricula.jsp y hacer la
		// comprobación de la misma
		// Recibo los parametros
		Coche c = (Coche) request.getAttribute("coche");
		request.setAttribute("coche", c);
		request.getRequestDispatcher("formulario.jsp").forward(request, response);
	}

}
