package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.daos.PerroDAO;
import com.ipartek.formacion.modelo.pojos.Perro;

/**
 * Servlet implementation class CarritoController
 */
public class CarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PerroDAO dao = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//se ejecuta con la 1º petición y solo una vez, el resto de peticiones iran al "service"
		dao = new PerroDAO();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		//Se ejecuta al parar el servidor
		
		dao= null;
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
		//recibir parametros
		String id = request.getParameter("id");
		//buscar en base datos el Perro por id
		Perro perroResultado = dao.getById(Long.parseLong(id));
		//recuperar carrito de sesion del usuario
		HttpSession session = request.getSession();
		ArrayList<Perro> carrito = (ArrayList<Perro>)session.getAttribute("carrito");
		
		if( carrito== null){
			carrito = new ArrayList<Perro>();
			
		}
		//añadir perro al carrito
		carrito.add(perroResultado);
		//guardamos el carrito en session
		session.setAttribute("carrito", carrito);
		//redirect a perro controller
		response.sendRedirect("perros");
	}

}
