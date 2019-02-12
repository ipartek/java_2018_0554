package com.ipartek.formacion.controller;

import java.io.IOException; //

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.daos.CocheDAO;
import com.ipartek.formacion.pojos.Coche;

@WebServlet("/privado/buscar")
public class BuscarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// LOG
	private final static Logger LOG = Logger.getLogger(BuscarController.class);

	// VISTAS
	private static final String BUSCAR_MATRICULA_JSP = "buscarMatricula.jsp";
	private static final String CREAR_MULTA_JSP = "multa.jsp";

	private CocheDAO cocheDAO = null;
	
	// metodo init para dao
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		cocheDAO = CocheDAO.getInstance();
		

	}

	// do get para recibir formulario al pulsar nueva multa
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("mensaje", "Busca una matricula ");

		request.getRequestDispatcher(BUSCAR_MATRICULA_JSP).forward(request, response); // AL PULSAR EN NUEVA MULTA DIRECTAMENTE ENVIO A BUSCAR MATRICULA
		LOG.debug("Entrando buscador matricula");
	}

	
	// DO POST PARA CREAR MULTA
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String matriculaBuscar = request.getParameter("buscar"); 							//	recojo parametro de la matricula introducida en formulario
		Coche c = new Coche();  															// creo objeto para introducir matricula
		c = cocheDAO.getMatricula(matriculaBuscar); 										// busco matricula en base de datos a traves del dao

		if (c != null) {
			request.setAttribute("coche", c);												// si el objeto coche contiene matricula
			request.setAttribute("mensaje", "Todos los campos son obligatorios");
			request.getRequestDispatcher(CREAR_MULTA_JSP).forward(request, response);  		// ruta envia a jsp para crear multa
		} else {
			request.setAttribute("matricula", matriculaBuscar);								// si el objeto coche esta vacio
			request.setAttribute("mensaje", "La matricula no existe");
			
			request.getRequestDispatcher(BUSCAR_MATRICULA_JSP).forward(request, response); 	// ruta vuelve a jsp de buscar matricula
		}

	}

}