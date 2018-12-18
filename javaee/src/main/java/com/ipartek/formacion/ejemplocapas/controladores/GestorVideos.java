package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ENDESHUSOcom.ipartek.formacion.ejemplocapas.pojos.Usuario;

/**
 * Servlet implementation class GestorVideos
 */
public class GestorVideos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<String> videos = new ArrayList<String>();
		
		videos.add("video1");
		videos.add("Fary");
		videos.add("Que no...");
		
		
		request.setAttribute("videos", videos);
		request.getRequestDispatcher("videos.jsp").forward(request,response);
		
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busqueda= request.getParameter("busqueda");
		
		ArrayList<String> videos= new ArrayList<String>();
		videos.add("video1");
		
		request.setAttribute("videos", videos);
		request.setAttribute(name, o);
	
	}

}
