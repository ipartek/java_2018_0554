package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.ipartek.formacion.modelo.pojos.Perro;
import com.ipartek.formacion.modelo.pojos.Usuario;

@WebServlet("/privado/perro")
@SuppressWarnings("unchecked")
public class PerroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ValidatorFactory factory;
	private Validator validator;
	ArrayList<Perro> perro;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String chip = request.getParameter("chip");
		String nombre = request.getParameter("nombre");
		String raza = request.getParameter("raza");
		
		Perro p = new Perro(chip, nombre, raza);
		Set<ConstraintViolation<Perro>> violations = validator.validate(p);
		if (violations.size() > 0) { 

			String errores = "<ul class='list-unstyled'>";
			for (ConstraintViolation<Perro> violation : violations) {

				errores += "<li>" + violation.getPropertyPath() + ": " + violation.getMessage() + "</li>";

			}
			errores += "</ul>";
			request.setAttribute("error", errores);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else {
			HttpSession session = request.getSession();
			ArrayList<Perro> perro = (ArrayList<Perro>) session.getAttribute("arrayPerros");
			perro.add(p);
			response.sendRedirect("index.jsp");
		}
	}
}
