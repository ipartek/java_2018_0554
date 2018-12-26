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
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.ipartek.formacion.modelo.pojos.Libro;

@WebServlet("/libro")
public class LibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Libro> libro;
	private int paginaActual = 0;
	String error = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		libro = new ArrayList<Libro>();
		libro.add(new Libro());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paginaStr = request.getParameter("pagina");
		try {
			if (paginaStr != null) {
				paginaActual = Integer.parseInt(paginaStr);
				if (paginaActual >= libro.size() || paginaActual < 0) {
					if (paginaActual < 0) {
						paginaActual = 0;
					}
					if (paginaActual > libro.size() - 1) {
						paginaActual = libro.size()-1;
					}
				}
			}
		error = (String) request.getAttribute("error");
		} catch (NumberFormatException e) {
			error = "Página NO disponible";
			paginaActual = 0;
		} finally {
			ServletContext context = request.getSession().getServletContext();
			context.setAttribute("arrayPaginas", libro); // ArrayList de libros recogidos en una variable de aplicación llamada
													// "paginas"
			request.setAttribute("pagina", libro.get(paginaActual)); // Al ArrayList "libro" se le pasa la página actual
																		// del getParameter para introducirla en el
																		// método get del ArryList y obtener el índice
																		// de la página actual en el atributo llamado
																		// "pagina"
			request.setAttribute("paginaActual", paginaActual); // La variable que contiene el número de la página
																// actual se pasa en el atributo llamado "paginaActual"
			request.setAttribute("paginasTotal", libro.size()); // La cantidad de objetos libro se obtiene con el método
																// size y se envia el atributo llamado "paginasTotal"
			
			request.setAttribute("error", error);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
