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

import com.ipartek.formacion.controller.pojo.Mensaje;
import com.ipartek.formacion.modelo.daos.LoginDAO;
import com.ipartek.formacion.modelo.pojo.Agente;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	private static final String VISTA_PRAL = "privado/principal.jsp";
	private static final String VISTA_LOGIN = "login.jsp";
	
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(LoginController.class);
	
	private Mensaje mensaje;
	
	private ValidatorFactory factory;
	private Validator validator;
	
	private LoginDAO daoLogin;
	Agente a = null;
	String placa = "";
	String password = "";
	String vista = "";

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoLogin = LoginDAO.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("titulo", "Iniciar Sesión | App Multas");
		vista = VISTA_LOGIN;
		mensaje = null;
		irAVista(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getParameters(request);
		try {
			a=new Agente();
			a.setPlaca(placa);
			a.setPassword(password);
			Set<ConstraintViolation<Agente>> violations = validator.validate(a);
			if (violations.size() > 0) {
				String errores = "<ul class='list-unlisted'>";
				for (ConstraintViolation<Agente> violation : violations) {
					errores += "<li>" + violation.getPropertyPath().toString().toUpperCase() + ": " + violation.getMessage() + "</li>";
				}
				errores += "</ul>";
				mensaje = new Mensaje(Mensaje.TIPO_DANGER, errores);
				LOG.debug(mensaje.getTexto());
				setParametersError(request);
			}
			else {
				a = daoLogin.login(Integer.parseInt(placa), password);
				if (a != null) {
					HttpSession session = request.getSession();
					session.setAttribute("agenteLogueado", a);
					request.setAttribute("titulo", "Menú | App Multas");
					vista = VISTA_PRAL;
				}
				else {
					mensaje = new Mensaje(Mensaje.TIPO_DANGER, "Usuario Inválido");
					setParametersError(request);
				}
			}
		}
		catch (Exception e) {
			LOG.error(e);
			mensaje = new Mensaje(Mensaje.TIPO_WARNING, e.getMessage());
			setParametersError(request);
		}
		finally {
			request.setAttribute("mensaje", mensaje);
			irAVista(request, response);
		}
	}
	
	protected void irAVista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(vista).forward(request, response);	
	}
	
	private void getParameters(HttpServletRequest request) {
		placa = request.getParameter("placa");
		password = request.getParameter("password");
	}
	
	private void setParametersError(HttpServletRequest request) {
		vista = VISTA_LOGIN;
		request.setAttribute("titulo", "Iniciar Sesión | App Multas");
		request.setAttribute("placa", placa);
		request.setAttribute("password", password);
	}
}