package com.ipartek.appMultas.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.appMultas.controller.pojo.Mensaje;
import com.ipartek.appMultas.modelo.dao.AgenteDAO;
import com.ipartek.appMultas.modelo.dao.MultaDAO;
import com.ipartek.appMultas.modelo.pojo.Agente;
import com.ipartek.appMultas.modelo.pojo.Multa;

/**
 * Servlet implementation class MultaController
 */
@WebServlet("/privado/multa")
public class MultaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static Logger LOG = Logger.getLogger(MultaController.class);

	private static final String OP_LISTAR = "1";
	private static final String OP_IR_FORMULARIO = "2";
	private static final String OP_DAR_DE_BAJA = "3";
	private static final String OP_LISTADO_BAJA = "4";
	private static final String OP_DESANULAR = "5";

	private MultaDAO daoMulta = null;
	private AgenteDAO daoAgente = null;
	
	private Agente agente = null;
	private HttpSession session = null;

	private String vista;
	private Mensaje alerta;
	// Parámetros
	private String op;
	private Long id;

	@Override
	public void init() throws ServletException {
		super.init();
		daoMulta = MultaDAO.getInstance();
		daoAgente = AgenteDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		daoMulta = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		vista = "listado";
		alerta = new Mensaje();
		try {
			// Recoger parámetros
			getParametros(request);

			// Realizar operación
			switch (op) {
			case OP_IR_FORMULARIO:
				irFormulario(request);
				break;
			case OP_DAR_DE_BAJA:
				darDeBaja(request);
				break;
			case OP_LISTADO_BAJA:
				listadoBaja(request);
				break;
			case OP_DESANULAR:
				desAnular(request);
				break;
			default:
				listar(request);
				break;
			}

		} catch (Exception e) {
			LOG.error(e);
		} finally {
			// Ir a una vista
			request.getRequestDispatcher(vista).forward(request, response);
		}

	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	/**
	 * Desanula una multa en la BD (Actualiza el campo fecha_modificacion y pone a NULL el campo fecha_baja).
	 * Actualiza los importes de los objetivos del agente.
	 * Crea una alerta para notificar al usuario. 
	 * @param request
	 */
	private void desAnular(HttpServletRequest request) {
		try {
			daoMulta.desAnularMulta(id);
			session = getSession(request);
			agente = getAgenteSession(session);
			session.setAttribute("agenteLogueado", daoAgente.obtenerImportes(agente));

			alerta.setTipo(Mensaje.TIPO_SUCCESS);
			alerta.setTexto("Se ha des-anulado la multa correctamente. ");
			request.setAttribute("mensaje", alerta);
			vista = "listado";
			
			//recupero la multa que se ha des-anulado para mostrarla en el log
			Multa mDesAnulada= daoMulta.getById(id);
			LOG.info("Se ha des-anulado la multa :"+ mDesAnulada.toString());
			
		} catch (SQLException e) {
			LOG.error(e);
			alerta.setTipo(Mensaje.TIPO_DANGER);
			alerta.setTexto("No ha sido posible des-anular la multa. ");
			request.setAttribute("mensaje", alerta);
		}
		
	}

	private void listadoBaja(HttpServletRequest request) {
		vista = "listadoBajas.jsp";
		HttpSession session = request.getSession();
		Agente a = (Agente) session.getAttribute("agenteLogueado");
		try {
			request.setAttribute("multas", daoMulta.getAllByIdAgenteAnulada(a.getId()));
		} catch (SQLException e) {
			LOG.error(e);
		}

	}
	/**
	 * Da de baja una multa en la BD (Actualiza el campo fecha_baja).
	 * Actualiza los importes de los objetivos del agente.
	 * Crea una alerta para notificar al usuario. 
	 * @param request
	 */
	private void darDeBaja(HttpServletRequest request) {
		try {
			daoMulta.darBajaMulta(id);
			session = getSession(request);
			agente = getAgenteSession(session);
			session.setAttribute("agenteLogueado", daoAgente.obtenerImportes(agente));
			
			listadoBaja(request);
			alerta.setTipo(Mensaje.TIPO_SUCCESS);
			alerta.setTexto("Se ha anulado la multa correctamente. ");
			request.setAttribute("mensaje", alerta);
			
		
			Multa mDeBaja= daoMulta.getById(id);
			LOG.info("Se ha dado de baja la multa :"+ mDeBaja.toString());
		} catch (SQLException e) {
			LOG.error(e);
			alerta.setTipo(Mensaje.TIPO_DANGER);
			alerta.setTexto("No ha sido posible anular la multa. ");
			request.setAttribute("mensaje", alerta);
		}
	}
	/**
	 * Nos redirecciona a la página correspondiente para visualizar todas las multas activas.
	 * @param request
	 */
	private void listar(HttpServletRequest request) {
		alerta.setTipo(Mensaje.TIPO_INFO);
		alerta.setTexto("Visualizando todas las multas activas. ");
		request.setAttribute("mensaje", alerta);
	}
	/**
	 * Proporciona la dirección de la vista de formulario. 
	 * @param request
	 */
	private void irFormulario(HttpServletRequest request) {
		vista = "detalle.jsp";
		Multa m = new Multa();

		if (id > 0) {
			m = daoMulta.getById(id);
		}
		request.setAttribute("multa", m);
	}
	/**
	 * Obtiene todos los parámetros de la request actual. 
	 * @param request
	 */
	private void getParametros(HttpServletRequest request) {
		op = request.getParameter("op");
		if (op == null) {
			op = OP_LISTAR;
		}
		String idTexto = request.getParameter("id");
		if (idTexto == null) {
			id = 0L;
		} else {
			id = Long.parseLong(request.getParameter("id"));
		}
		LOG.debug(String.format("Parametros: op=%s id=%s", op, id));
	}
	/**
	 * Obtiene el agente de la sesión actual (logueado)
	 * @param session Sesión actual
	 * @return Agente logueado
	 */
	private Agente getAgenteSession( HttpSession session) {
		agente= (Agente) session.getAttribute("agenteLogueado");
		return agente;
	}
	/**
	 * Obtiene la sesión existente de la request enviada por parámetro
	 * @param request 
	 * @return Session actual
	 */
	private HttpSession getSession( HttpServletRequest request) {
		session = request.getSession();
		return session;
	}
}
