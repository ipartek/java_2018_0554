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

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.daos.UsuarioDAO;
import com.ipartek.formacion.modelo.pojos.Mensaje;
import com.ipartek.formacion.modelo.pojos.Usuario;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(LoginController.class);
	private ValidatorFactory factory;
	private Validator validator;
	
	private Mensaje mensaje = null;
	
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
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		Usuario u = new Usuario();
		boolean redirect = false;
		try {
			u.setEmail(usuario);
			u.setPassword(password);
			Set<ConstraintViolation<Usuario>> violations = validator.validate(u);
			if (violations.size() > 0) { // validacion NO PASA

				String errores = "<ul>";
				for (ConstraintViolation<Usuario> violation : violations) {

					errores += "<li>" + violation.getPropertyPath() + ": " + violation.getMessage() + "</li>";

					// violation.getPropertyPath()
				}
				errores += "</ul>";
				mensaje = new Mensaje(mensaje.MENSAJE_DANGER, errores);
				request.setAttribute("mensaje", mensaje);
			} else {
				u = dao.login(usuario, password);
				if (u != null) {
					redirect = true;
					HttpSession session = request.getSession();
					session.setAttribute("usuarioLogueado", u);
				} else {
					request.setAttribute("usuario", usuario);
					request.setAttribute("password", password);
					mensaje = new Mensaje(mensaje.MENSAJE_DANGER, "Usuario Inválido");
					request.setAttribute("mensaje", mensaje);
				}
			}
		} catch (Exception e) {
			LOG.error(e);
			mensaje = new Mensaje(mensaje.MENSAJE_DANGER, e.getMessage());
			request.setAttribute("mensaje", mensaje);
		} finally {
			if (redirect) {
				response.sendRedirect(request.getContextPath()+"/privado/usuarios");
			}
			else {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
	}

}
