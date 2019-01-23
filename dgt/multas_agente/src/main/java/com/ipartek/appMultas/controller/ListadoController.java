package com.ipartek.appMultas.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.appMultas.modelo.dao.MultaDAO;
import com.ipartek.appMultas.modelo.pojo.Agente;
import com.ipartek.appMultas.modelo.pojo.Multa;

/**
 * Servlet implementation class ListadoController PARA OBTENER Y LISTAR TODAS
 * LAS MULTAS
 */
@WebServlet("/privado/listado")
public class ListadoController extends HttpServlet {
	private final static Logger LOG = Logger.getLogger(ListadoController.class);
	private static final long serialVersionUID = 1L;
	private MultaDAO dao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = MultaDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		dao = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HashMap<Long, Multa> multas = new HashMap<>();
		Agente a = new Agente();

		try {
			// Obtener el agente logueado
			HttpSession sessionn = request.getSession();
			a = (Agente) sessionn.getAttribute("agenteLogueado");

			multas = dao.getAllByIdAgente(a.getId());
			request.setAttribute("multas", multas);
		} catch (SQLException e) {
			LOG.debug(e);
		} finally {
			// Obtiene todo el listado de las multas y redirecciona a listado.jsp
			request.getRequestDispatcher("listado.jsp").forward(request, response);
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

}
