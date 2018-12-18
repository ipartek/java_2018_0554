package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MiTablaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<String> videos = new ArrayList<String>();
		
		videos.add("video1");
		videos.add("Fary");
		videos.add("lalalal");
		
		request.setAttribute("videos", videos);
		request.getRequestDispatcher("mitabla.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busqueda = request.getParameter("busqueda");
		
		ArrayList<String> videos = new ArrayList<String>();
		videos.add("video1");
		request.setAttribute("videos", videos);
		request.setAttribute("busqueda", busqueda);
		request.getRequestDispatcher("mitabla.jsp").forward(request, response);
	}

}
