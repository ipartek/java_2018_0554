package com.ipartek.formacion.controller;

import java.io.IOException;
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

import com.ipartek.formacion.dao.UsuarioDAO;
import com.ipartek.formacion.pojo.Usuario;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VISTA_LOGIN = "index.jsp";
	private static final String VIDEOS_CONTROLLER = "/privado/videos";
	private UsuarioDAO dao;
	private ValidatorFactory factory;
	private Validator validator;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = UsuarioDAO.getInstance();
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String vista = VISTA_LOGIN;

		String usuario = request.getParameter("usuario");
		String pass = request.getParameter("pass");

		try {
			// validar parámetros
			Usuario u = new Usuario();
			u.setNombre(usuario);
			u.setPass(pass);

			Set<ConstraintViolation<String>> violations = validator.validate(usuario);

			if (violations.size() > 0) { // validacion NO PASA

				String errores = "<ul>";
				for (ConstraintViolation<String> violation : violations) {

					errores += "<li>" + violation.getPropertyPath() + ": " + violation.getMessage() + "</li>";

					// violation.getPropertyPath()
				}
				errores += "</ul>";
				request.setAttribute("errores", violations);
				request.setAttribute("mensaje", errores);

			} else { // validacion OK

				u = dao.login(usuario, pass);

				if (u == null) {

					request.setAttribute("mensaje", "Credenciales incorrectas");
				} else {

					HttpSession session = request.getSession();
					session.setAttribute("usuario", u);
					vista = VIDEOS_CONTROLLER;
				}
			}
		} catch (Exception e) {
			request.setAttribute("mensaje", "El usuario o la contraseña no son correctos");
		} finally {
			request.getRequestDispatcher(vista).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
