package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.ipartek.formacion.modelo.pojos.Libro;

@WebServlet("/mantenimiento")
public class Mantenimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ValidatorFactory factory;
	private Validator validator;
	int pagina = 0;
	String errorStr = null;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");
		String paginaStr = request.getParameter("pagina");
		switch (accion) {
		case "insertar":
		case "editar":
			if ("editar".equals(accion)) {
				String texto = request.getParameter("texto");
				request.setAttribute("texto", texto);
				pagina = Integer.parseInt(paginaStr);
				request.setAttribute("pagina", pagina);
			}
			request.getRequestDispatcher("mantenimiento.jsp").forward(request, response);
			break;
		case "borrar":
			ServletContext context = request.getSession().getServletContext();
			ArrayList<Libro> libro = (ArrayList<Libro>) context.getAttribute("arrayPaginas");
			pagina = Integer.parseInt(paginaStr);
			libro.remove(pagina);
			response.sendRedirect("libro?pagina=0");
			break;
		default:
			response.sendRedirect("libro");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paginaStr = request.getParameter("pagina");
		ServletContext context = request.getSession().getServletContext();
		ArrayList<Libro> libro = (ArrayList<Libro>) context.getAttribute("arrayPaginas");
		String texto = request.getParameter("texto");
		String autor = request.getParameter("autor");
		
		boolean error = true;
		Libro l = new Libro(autor, texto);
		Set<ConstraintViolation<Libro>> violations = validator.validate(l);
		
		if (violations.isEmpty()) {
			error = false;
		} else {
			errorStr = "Por favor rellena el autor y texto";
			request.setAttribute("error", errorStr);
		}
		if (!"".equals(paginaStr)) {
			if (!error) {
				int pagina = Integer.parseInt(paginaStr);
				libro.set(pagina, new Libro(autor, texto));
			}
		} else {
			if (!error) {
				libro.add(new Libro(autor, texto));
			}
		}
		if (error) {
			// TODO Cambiar sendRedirect por RequestDispatcher
			response.sendRedirect("libro?errorStr");
		}
		else {
			response.sendRedirect("libro");
		}
	}
}
