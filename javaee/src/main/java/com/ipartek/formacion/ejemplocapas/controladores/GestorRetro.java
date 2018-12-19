package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.pojos.Retro;

/**
 * Servlet implementation class GestorRetro
 */
public class GestorRetro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
ArrayList<Retro> juegos = new ArrayList<Retro>();
		
		juegos.add(new Retro(1,"kirby","NES",80,"HAL","imagen1"));
		juegos.add(new Retro(2,"zelda","NES",80,"Capcom","imagen2"));
		juegos.add(new Retro(3,"bravely default", "3DS",2010, "", "imagen3"));
		
		
		request.setAttribute("juegos", juegos);
		
		request.getRequestDispatcher("retro.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String busqueda= request.getParameter("busqueda");
		
		ArrayList<Retro> juegos= new ArrayList<Retro>();
		
//		juegos.add("juegoA");		
		
		request.setAttribute("juegos", juegos);
		
		request.setAttribute("busqueda", busqueda);
		
		request.getRequestDispatcher("juegos.jsp").forward(request, response);
	
	}

}