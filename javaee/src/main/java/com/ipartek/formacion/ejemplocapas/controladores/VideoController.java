package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.daos.VideosDAO;
import com.ipartek.formacion.modelo.pojos.Video;

/**
 * Servlet implementation class VideoController
 */
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/*
		videos.add("video1");
		videos.add("Fary");
		videos.add("Que nos se te olcide el WHERE XD");
		*/
		ArrayList<Video> videos = new ArrayList<Video>();
		VideosDAO dao = new VideosDAO();
		
		request.setAttribute("videos", dao.getAll());
		request.getRequestDispatcher("videos.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String busqueda = request.getParameter("busqueda");
		
		ArrayList<Video> videos = new ArrayList<Video>();
		VideosDAO dao = new VideosDAO();
//		videos.add("video1");		
		
		request.setAttribute("videos", dao.getAllByNombre(busqueda));
		request.setAttribute("busqueda", busqueda);
		request.getRequestDispatcher("videos.jsp").forward(request, response);
	}

}
