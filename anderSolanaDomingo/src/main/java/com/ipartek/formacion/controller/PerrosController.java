package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.pojo.Perro;

/**
 * Servlet implementation class PerrosController
 */
@WebServlet("/privada/perros")
public class PerrosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Perro> perros;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext appContext = config.getServletContext();
		perros = (ArrayList<Perro>) appContext.getAttribute("perros");
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (perros == null) {
			perros = new ArrayList<Perro>();
		}
		
		request.setAttribute("perros", perros);
		
		request.getRequestDispatcher("/privada/perros.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
