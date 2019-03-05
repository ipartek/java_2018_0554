package com.ipartek.appMultas.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.appMultas.controller.pojo.Mensaje;
import com.ipartek.appMultas.modelo.dao.CocheDAO;
import com.ipartek.appMultas.modelo.pojo.Coche;

/**
 * Servlet implementation class MatriculaController PARA COMPROBAR QUE LA
 * MATRÍCULA EXISTE
 */
@WebServlet("/privado/matricula")
public class MatriculaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(MatriculaController.class);
	private final static String CONTROLLER_MULTAR = "multar";
	private final static String VIEW_MATRICULA = "matricula.jsp";
	private CocheDAO dao;
	private String vista;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = CocheDAO.getInstance();
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
		String matricula = null;
		matricula = request.getParameter("matricula");

		request.setAttribute("matricula", matricula);
		// Llama a matricula.jsp para la introducción de la matrícula a comprobar
		request.getRequestDispatcher("matricula.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Comprobar matrícula
		// recoger matricula
		String matricula = "";
		matricula = request.getParameter("matriculaCoche");
		Coche c = null;
		vista = VIEW_MATRICULA;
		try {
			if (!matricula.equals("")) {
				c = dao.getByMatricula(matricula);
				if (c != null) {
					// Comprobar que existe el coche
					request.setAttribute("coche", c);

					// Si es correcta, enviar a formulario.jsp
					vista = CONTROLLER_MULTAR;
				} else {
					request.setAttribute("mensaje",
					new Mensaje(Mensaje.TIPO_WARNING, "Esa matrícula no está registrada"));
				}
			} else {
				// Si no existe, crear alerta y volver a matricula.jsp
				request.setAttribute("mensaje", new Mensaje(Mensaje.TIPO_WARNING, "Introduce una matricula"));
			}
		} catch (Exception e) {
			LOG.trace(e.getMessage());
			request.setAttribute("mensaje", new Mensaje(Mensaje.TIPO_DANGER, "ERROR INESPERADO"));
		} finally {
			request.setAttribute("matricula", matricula);
			request.getRequestDispatcher(vista).forward(request, response);
		}
	}
	
}
