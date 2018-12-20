package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.daos.PerroDAO;
import com.ipartek.formacion.modelo.pojos.Perro;
import com.ipartek.formacion.modelo.pojos.Video;

/**
 * Servlet implementation class PerroControler
 */
public class PerroControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Perro> perros = new ArrayList<Perro>();
		PerroDAO dao = new PerroDAO();
		request.setAttribute("perros", dao.getAll());
		request.getRequestDispatcher("perro.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String busqueda = request.getParameter("busqueda");
		
		ArrayList<Perro> perros = new ArrayList<Perro>();	
		
		PerroDAO dao = new PerroDAO();
		
		request.setAttribute("perros", dao.getAllByNombre(busqueda) );	
		request.setAttribute("busqueda", busqueda);
		request.getRequestDispatcher("perro.jsp").forward(request, response);
		
	}

}
