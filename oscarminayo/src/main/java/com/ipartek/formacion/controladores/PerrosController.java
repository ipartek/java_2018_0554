package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.pojos.Perro;

/**
 * Servlet implementation class PerrosController
 */
@WebServlet("/privado/perros")
public class PerrosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Perro> perros = new ArrayList<Perro>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		perros.add(new Perro("Sky", "Alaskan Malamute", "11-1234-2018"));
		perros.add(new Perro("Diablo", "Husky Siberiano", "22-1234-2018"));
		perros.add(new Perro("Thor", "Perro Lobo", "33-1234-2018"));
		
	}
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String raza = request.getParameter("raza");
		String chip = request.getParameter("chip");
		
		
		if(nombre != null) {
			perros.add(new Perro(nombre, raza, chip));
		}
		
		
		request.setAttribute("perros", perros);
		request.getRequestDispatcher("listadoperros.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
	}

}
