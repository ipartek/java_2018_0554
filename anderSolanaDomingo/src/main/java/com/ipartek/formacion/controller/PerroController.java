package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.pojo.Perro;

/**
 * Servlet implementation class PerroController
 */
@WebServlet("/privada/perro")
public class PerroController extends HttpServlet {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");

		for (Perro perro : perros) {
			if (nombre.equals(perro.getNombre())) {
				request.setAttribute("perro", perro);
				break;
			}
		}
		
		request.getRequestDispatcher("/privada/perro.jsp").forward(request, response);
	}

}
