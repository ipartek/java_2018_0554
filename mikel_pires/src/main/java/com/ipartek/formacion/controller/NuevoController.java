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

import com.ipartek.formacion.modelo.pojo.Perro;

/**
 * Servlet implementation class NuevoController
 */
@WebServlet("/nuevo")
public class NuevoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ValidatorFactory factory;
	private Validator validator;

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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String raza = request.getParameter("raza");
		String chip = request.getParameter("chip");

		if (raza.equals("")) {
			raza = "milrazas";
		}
//		Recoger el array de perros de la sesion
		HttpSession session = request.getSession();
		ArrayList<Perro> perros = (ArrayList<Perro>) session.getAttribute("perros");

		Perro newPerro = new Perro();
		try {

			newPerro = new Perro(nombre, raza, chip);

			// validar
			Set<ConstraintViolation<Perro>> violations = validator.validate(newPerro);
			
				if (violations.isEmpty()) {
					if (!chip.matches("\\d\\d-\\d\\d\\d\\d-\\d\\d\\d\\d")) {
						request.setAttribute("mensaje", "El numero de chip no es correcto o es nulo");
						request.getRequestDispatcher("privado/nuevo.jsp").forward(request, response);
					}
					perros.add(newPerro);
					session.setAttribute("perros", perros);

				} else {

					request.setAttribute("mensaje", "Los campos de nombre y chip no pueden estar vacios");
					request.getRequestDispatcher("privado/nuevo.jsp").forward(request, response);
				}


		} catch (Exception e) {
			request.setAttribute("mensaje", "Error guardando al perro");

		} finally {

			request.getRequestDispatcher("privado/listado.jsp").forward(request, response);
		}

	}
}
