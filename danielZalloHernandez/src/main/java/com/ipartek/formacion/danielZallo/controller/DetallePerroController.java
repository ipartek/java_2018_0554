package com.ipartek.formacion.danielZallo.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.danielZallo.modelo.pojo.Perro;

/**
 * Servlet implementation class DetallePerroController
 */
@WebServlet("/privado/verPerro")
public class DetallePerroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idS= request.getParameter("id");
		
		Long id = Long.parseLong(idS);
		
		HashMap<Long, Perro> perros = (HashMap<Long, Perro>) request.getServletContext().getAttribute("perros");
		
		Perro pSeleccionado = perros.get(id);
		
		request.setAttribute("perro", pSeleccionado);
		request.getRequestDispatcher("verPerro.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
