package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.Set;
import org.apache.log4j.Logger;

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

import com.ipartek.formacion.modelo.dao.UsuarioDAO;
import com.ipartek.formacion.modelo.pojo.Mensaje;
import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(LoginController.class);
	private static final String VISTA_LOGIN = "index.jsp";
	private static final String CONTROLLER_VIDEOS = "privado/videos";
    private UsuarioDAO dao;
    private ValidatorFactory factory;
    private Validator validator;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = UsuarioDAO.getInstance();
		//Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
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
		String vista = VISTA_LOGIN;
		
		Mensaje alerta = new Mensaje();
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		try {
			//Validar
			Usuario usuario = new Usuario();
			usuario.setEmail(email);
			usuario.setPassword(pass);
			
			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
			
			HttpSession session = request.getSession();
			
			if (!session.isNew()) {
			
			if (violations.size() > 0) {
				LOG.error("Se han encontrado " + violations.size() + " violaciones en la validación");
				String errores = "<ul>";
				for (ConstraintViolation<Usuario> violation : violations) {
					errores += String.format("<li> %s : %s </li>", violation.getPropertyPath(), violation.getMessage());
				}
				errores += "</ul>";
				
				if (session.getAttribute("sesionNoIniciada") == null) {
					alerta.setAlerta(errores);
					alerta.setTipo("danger");
				}else {
					alerta = null;
				}
				
				request.setAttribute("mensaje", alerta);
			}else {
			
			usuario = dao.login(email, pass);
			LOG.info("Se está intentando hacer login con el email: " + email + " y contraseña: " + pass);
				if (usuario == null) {
					LOG.error("El usuario no existe en la DB");
					alerta.setAlerta("Usuario erróneo '" + email + "'");
					alerta.setTipo("danger");
					request.setAttribute("mensaje", alerta);
				}else {
					LOG.info("Usuario encontrado en la DB");
					vista = CONTROLLER_VIDEOS;
					session = request.getSession();
					session.setMaxInactiveInterval(60 * 5); // 5 min, también se puede configurar en WEB.XML [Para configurarlo para toda aplicación]
					session.setAttribute("usuario_logueado", usuario);
				}

			}
			}
			
		}catch (Exception e) {
			LOG.error("Ha habido un error en el proceso de Login");
			e.printStackTrace();
		}finally {
			if (vista.equals(CONTROLLER_VIDEOS)) {
			response.sendRedirect(CONTROLLER_VIDEOS);
			}else {
			request.getRequestDispatcher(vista).forward(request, response);
		}
		}
		
		
	}

}
