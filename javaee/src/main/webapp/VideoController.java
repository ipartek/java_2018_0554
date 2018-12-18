package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VideoController
 */
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<String> videos = new ArrayList<String>();
		
		videos.add("video1");
		videos.add("Fary");
		videos.add("Que nos se te olcide el WHERE XD");
		
		request.setAttribute("videos", videos);
		
		request.getRequestDispatcher("videos.jsp").forward(request, response);
		//public void destroy();
		//el destroy se ejecuta para parar el servidor 
		// se ejecuta con la primera peticion y solo una vez
		//antes del doGet o doPost
		super.service(req, resp);
		private static final long 
	//despues del doGet o doPost
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String busqueda = request.getParameter("busqueda");
		
		ArrayList<String> videos = new ArrayList<String>();
		videos.add("video1");		
		
		request.setAttribute("videos", videos);
		request.setAttribute("busqueda", busqueda);
		request.getRequestDispatcher("videos.jsp").forward(request, response);
	}

}
