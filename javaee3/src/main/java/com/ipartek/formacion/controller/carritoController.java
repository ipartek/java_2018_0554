package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ipartek.formacion.modelo.pojos.Videos;

/**
 * Servlet implementation class carritoController
 */
@WebServlet("/carritoController")
public class carritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Videos> videos;

//	videos.add( new Video(1l,"video1", "url1"));
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Creo el arrayList
		videos = new  ArrayList<Videos>();
		
		//Obtengo los parametros que me dan los botones de añadir de la lista de videos
		
//		request.setAttribute("videos", videos.getAll());
		//esos videos selectos los meto en una variable que enviare a la vista
	
		
		request.getRequestDispatcher("carrito.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
