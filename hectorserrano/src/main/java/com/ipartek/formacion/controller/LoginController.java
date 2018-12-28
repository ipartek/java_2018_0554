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

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ValidatorFactory factory;
	private Validator validator;
	private ArrayList<Perro> perro;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		perro = new ArrayList<Perro>();
		perro.add(new Perro("01-6432-2009", "200 x 300", "Pluto", 9, "Chihuahua"));
		perro.add(new Perro("01-9435-2006", "800 x 750", "Mercurio", 12, "Pitbull"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		Usuario u = new Usuario();
		boolean redirect = false;
		try {
			u.setUsuario(usuario);
			u.setPassword(password);
			Set<ConstraintViolation<Usuario>> violations = validator.validate(u);
			if (violations.size() > 0) { // validacion NO PASA

				String errores = "<ul class='list-unlisted'>";
				for (ConstraintViolation<Usuario> violation : violations) {

					errores += "<li>" + violation.getPropertyPath() + ": " + violation.getMessage() + "</li>";

				}
				errores += "</ul>";
				request.setAttribute("error", errores);
			} else {
				String usuarioCorrecto = u.getUsuario();
				String passwordCorrecto = u.getPassword();
				if ("scobby".equals(usuarioCorrecto) && "galletas".equals(passwordCorrecto)) {
					redirect = true;
					HttpSession session = request.getSession();
					session.setAttribute("logueado", u);
					session.setAttribute("arrayPerros", perro);
				} else {
					request.setAttribute("usuario", usuario);
					request.setAttribute("password", password);
					request.setAttribute("error", "Login incorrecto");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (redirect) {
				response.sendRedirect("privado/index.jsp");
			} else {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}
}
