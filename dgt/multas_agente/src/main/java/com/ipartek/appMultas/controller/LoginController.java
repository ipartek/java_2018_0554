package com.ipartek.appMultas.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.appMultas.controller.pojo.Mensaje;
import com.ipartek.appMultas.modelo.dao.AgenteDAO;
import com.ipartek.appMultas.modelo.pojo.Agente;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AgenteDAO daoAgente;

	private HttpSession session = null;

	private final static Logger LOG = Logger.getLogger(LoginController.class);

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoAgente = AgenteDAO.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String placa = request.getParameter("placa");
		String password = request.getParameter("password");
		Agente agente = daoAgente.login(placa, password);

		if (placa.equals("") || password.equals("")) {
			request.setAttribute("placa", placa);
			request.setAttribute("password", password);
			request.setAttribute("mensaje", new Mensaje(Mensaje.TIPO_DANGER, "No puede haber campos vacíos"));
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			if (agente == null) {
				request.setAttribute("mensaje", new Mensaje(Mensaje.TIPO_DANGER, "Nº Placa o Contraseña no válidos"));
				request.setAttribute("placa", placa);
				request.setAttribute("password", password);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				session = getSession(request);
				LOG.debug("Agente Logueado: " + agente.toString());
				session.setAttribute("agenteLogueado", daoAgente.obtenerImportes(agente));
				session.setAttribute("mensaje", null);
				// Redireccionar a index.jsp
				response.sendRedirect("privado/index.jsp");
			}
		}
	}
	/**
	 * Obtiene la sesión existente de la request enviada por parámetro
	 * @param request 
	 * @return Session actual
	 */
	private HttpSession getSession(HttpServletRequest request) {
		session = request.getSession();
		return session;
	}

}
