package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.daos.UsuarioDAO;
import com.ipartek.formacion.modelo.pojos.Usuario;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(LoginController.class);
	private ValidatorFactory factory;
	private Validator validator;

	private UsuarioDAO dao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = UsuarioDAO.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String idioma = request.getParameter("idioma");
		Usuario u = new Usuario();
		boolean redirect = false;
		try {
			// Idioma
			Locale locale = new Locale(idioma);
			ResourceBundle message = ResourceBundle.getBundle("i18nmessages", locale);
			
			// Cookie
//			Cookie cookie = null;
//			Cookie[] cookies = request.getCookies();
//			if (cookies != null) {
//				for(int i = 0; i < cookies.length; i++) {
//					cookie = cookies[i];
//					if(cookie.getName().equals("cIdioma")) {
//						cookie.setMaxAge(0);
//						response.addCookie(cookie);
//					}
//						Cookie cIdioma = new Cookie("cIdioma", idioma);
//						cIdioma.setMaxAge(2147483647); // 68 años
//						response.addCookie(cIdioma);
//				}
//			}
			
			Cookie cIdioma = new Cookie("cIdioma", idioma);
			Cookie cVisita = new Cookie("cVisita", "visita");
			
			cIdioma.setMaxAge(2147483647); // 68 años
			cVisita.setMaxAge(2147483647); // 68 años
			response.addCookie(cIdioma);
			response.addCookie(cVisita);
			
			u.setEmail(usuario);
			u.setPassword(password);
			Set<ConstraintViolation<Usuario>> violations = validator.validate(u);
			if (violations.size() > 0) { // validacion NO PASA

				String errores = "<ul class='list-unlisted'>";
				for (ConstraintViolation<Usuario> violation : violations) {

					errores += "<li>" + violation.getPropertyPath() + ": " + violation.getMessage() + "</li>";

				}
				errores += "</ul>";
				request.setAttribute("errores", violations);
				request.setAttribute("mensajeError", errores);
			} else {
				u = dao.login(usuario, password);
				if (u != null) {
					redirect = true;
					HttpSession session = request.getSession();
					session.setAttribute("logueado", u);
					session.setAttribute("idioma", idioma);
				} else {
					request.setAttribute("usuario", usuario);
					request.setAttribute("pass", password);
					request.setAttribute("error", message.getString("login.incorrecto"));
				}
			}
		} catch (Exception e) {
			LOG.error(e);
		} finally {
			if (redirect) {
				response.sendRedirect("libro");
			} else {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}

}
