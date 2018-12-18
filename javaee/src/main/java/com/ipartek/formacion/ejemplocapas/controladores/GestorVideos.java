package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.daos.VideoDAO;
import com.ipartek.formacion.modelo.pojos.Videos;

import ENDESHUSOcom.ipartek.formacion.ejemplocapas.pojos.Usuario;

/**
 * Servlet implementation class GestorVideos
 */
public class GestorVideos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<Videos> videos = new ArrayList<Videos>();
		
		VideoDAO dao= new VideoDAO();
		
		
//		videos.add("video1");
//		videos.add("Fary");
//		videos.add("Que no...");
//		
		
		request.setAttribute("videos", dao.getAll());
		
		request.getRequestDispatcher("videos.jsp").forward(request,response);
		
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busqueda= request.getParameter("busqueda");
		
		ArrayList<Videos> videos= new ArrayList<Videos>();
		
//videos.add("video1");		
		
		VideoDAO dao = new VideoDAO();
		
		request.setAttribute("videos", dao.getAllByNombre(busqueda));
	
		request.setAttribute("busqueda", busqueda);
		
		request.getRequestDispatcher("videos.jsp").forward(request, response);
	}

}
