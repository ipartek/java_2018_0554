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

import com.ipartek.formacion.daos.AgenteDAO;
import com.ipartek.formacion.pojos.Agente;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// log para mensajes
	private final static Logger LOG = Logger.getLogger(LoginController.class);
	
	// vistas/rutas
	public static final String VIEW_LOGIN = "login.jsp";
	private static final String PRIVADO_PRINCIPAL = "/privado/principal";

	// dao y objetos
	private AgenteDAO agenteDAO = null;
	Agente agente = null;

	// validator
	private ValidatorFactory factory;
	private Validator validator;

	
	// init para validator, dao , objetos y colecciones
	@Override  
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		agenteDAO = AgenteDAO.getInstance();
		agente = new Agente();
		
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher(VIEW_LOGIN).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recojo parametros
		String placa = request.getParameter("placa");
		String pass = request.getParameter("pass");
		
		// vista
		String view = VIEW_LOGIN;
			
		// para lógica
		boolean redirect = false;  // para redireccionar la ruta
		Integer placaInt = 0; // para parseo 
		
		
		try {
			placaInt = Integer.parseInt(placa);
		} catch (Exception e) {
			placaInt = null;
			
		}

		try {

			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(60 * 60 * 24 * 365 * 10); // intervalo

			// validar
			Agente a = new Agente();
			a.setPlaca(placaInt);
			a.setPassword(pass);

			Set<ConstraintViolation<Agente>> violations = validator.validate(a);

			if (violations.size() > 0) { // validacion NO PASA

				String errores = "<ul>";
				for (ConstraintViolation<Agente> violation : violations) {
					errores += String.format("<li> %s : %s </li>", violation.getPropertyPath(), violation.getMessage());
				}
				errores += "</ul>";
				request.setAttribute("error", errores);
				request.setAttribute("placa", placa);
				request.setAttribute("pass", pass);

			} else { // validacion OK

				agente = agenteDAO.login(placaInt, pass); 						// objeto con atributos de parametros recogidos
				if (agente == null) { 											// si al comparar con la base de datos devuelve objeto vacio

					request.setAttribute("error", "Credenciales incorrectas"); 
				} else {														// si devuelve objeto con parametros que coinciden con la base de datos
					session.setAttribute("agente_logeado", agente);  
					redirect = true;
					LOG.debug("Logeado en pagina principal");
				}
			}

		} catch (Exception e) {
			request.setAttribute("error", "ERROR FATAL");
			LOG.error(e);
		} finally {

			if (redirect) {
				response.sendRedirect(request.getContextPath() + PRIVADO_PRINCIPAL); // si existe agente voy a principal
			} else {
				request.getRequestDispatcher(view).forward(request, response);  	 // si no existe vuelvo a login
			}
		}
	}

}
