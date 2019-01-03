package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.daos.PerroDAO;
import com.ipartek.formacion.modelo.daos.VideoDAO;
import com.ipartek.formacion.modelo.pojos.Perro;

/**
 * Servlet implementation class PerroController
 */
@WebServlet("/privado/perros")
public class PerroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final long serialVersionUID1 = 1L;
	private PerroDAO dao;  
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//se ejecuta con la primera peticion y solo una vez, el resto de peticiones "service"
		dao = new PerroDAO();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		//se ejecuta al parar el servidor
		dao = null;
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Antes de doGet o doPost
		System.out.println("Antes de doGet o doPost");
		
		super.service(req, resp);
		
		//Despues de doGet o doPost
		System.out.println("Antes de doGet o doPost");
	}
  

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
