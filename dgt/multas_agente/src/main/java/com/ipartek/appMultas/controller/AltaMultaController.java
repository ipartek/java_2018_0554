package com.ipartek.appMultas.controller;

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

import com.ipartek.appMultas.controller.pojo.Mensaje;
import com.ipartek.appMultas.modelo.dao.AgenteDAO;
import com.ipartek.appMultas.modelo.dao.CocheDAO;
import com.ipartek.appMultas.modelo.dao.MultaDAO;
import com.ipartek.appMultas.modelo.pojo.Agente;
import com.ipartek.appMultas.modelo.pojo.Coche;
import com.ipartek.appMultas.modelo.pojo.Multa;

/**
 * Servlet implementation class AltaMultaController
 */
@WebServlet("/privado/altamulta")
public class AltaMultaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(AltaMultaController.class);
	private ValidatorFactory factory;
	private Validator validator;
	private CocheDAO daoCoche;
	private MultaDAO daoMulta;
	private Double importe;
	private Long idAgente;
	private String concepto = "";
	private Coche c;
	
	private Agente agente = null;
	private HttpSession session = null;
	
	private AgenteDAO daoAgente = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoCoche = CocheDAO.getInstance();
		daoMulta = MultaDAO.getInstance();
		daoAgente = AgenteDAO.getInstance();

		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Override
	public void destroy() {
		super.destroy();
		daoCoche = null;
		daoMulta = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Obtener los parametros
			getParameters(request);

			// Generamos la nueva Multa
			Multa m = new Multa();
			m.setImporte(importe);
			m.setConcepto(concepto);
			m.setCoche(c);

			// Validar POJO
			Set<ConstraintViolation<Multa>> violations = validator.validate(m);

			if (violations.size() > 0) {// Validacon no correcta
				String errores = "<ul class='list-unstyled'>";
				for (ConstraintViolation<Multa> violation : violations) {
					errores += String.format("<li> %s : %s </li>", violation.getPropertyPath(), violation.getMessage());
				}
				errores += "</ul>";
				request.setAttribute("mensaje", new Mensaje(Mensaje.TIPO_DANGER, errores));

				// volver al formulario, cuidado que no se pierdan los valores en el form
				reWriteField(request);
				// Volver al formulario
				request.getRequestDispatcher("multar").forward(request, response);

			} else {
				// Correcto: Insert en la DB
				daoMulta.insert(m, idAgente);

				session = getSession(request);
				agente = getAgenteSession(session);
				session.setAttribute("agenteLogueado", daoAgente.obtenerImportes(agente));
				
				LOG.info("Multa creada :" + m.toString() + ". Por el agente: " + agente.toString());
				
				// Crear mensaje
				request.setAttribute("mensaje", new Mensaje(Mensaje.TIPO_SUCCESS, "Multa registrada correctamente."));
				// Volver a index
				request.getRequestDispatcher("listado").forward(request, response);
			}
		} catch (NumberFormatException e) {
			// Importe no es numérico
			LOG.debug(e.getMessage());
			request.setAttribute("mensaje", new Mensaje(Mensaje.TIPO_DANGER, " Se esperaba un número"));

			reWriteField(request);

			// Volver al formulario
			request.getRequestDispatcher("multar").forward(request, response);

		} catch (Exception e) {
			LOG.debug(e.getMessage());
			request.setAttribute("mensaje", new Mensaje(Mensaje.TIPO_DANGER, "Error inesperado"));
		}

	}

	/**
	 * Metodo que obtiene todo los parametros
	 * 
	 * @param request
	 */
	private void getParameters(HttpServletRequest request) {
		// Recoger datos
		concepto = request.getParameter("concepto");
		String importeTexto = request.getParameter("importe");
		try {
			importe = Double.parseDouble(importeTexto);

		} catch (NumberFormatException e) {
			importe = (double) 0;
		}
		Long idCoche = Long.parseLong(request.getParameter("id_coche"));
		c = daoCoche.getBYId(idCoche);
		idAgente = Long.parseLong(request.getParameter("id_agente"));
	}
	
	private Agente getAgenteSession( HttpSession session) {
		agente= (Agente) session.getAttribute("agenteLogueado");
		
		return agente;
	}
	
	private HttpSession getSession( HttpServletRequest request) {
		session = request.getSession();
		
		return session;
	}

	/**
	 * Metod que reescribe los campos del formulario
	 * 
	 * @param request
	 */
	private void reWriteField(HttpServletRequest request) {
		// Reesccribir campos
		request.setAttribute("importe", importe);
		request.setAttribute("concepto", concepto);
		request.setAttribute("coche", c);
	}
	
}
