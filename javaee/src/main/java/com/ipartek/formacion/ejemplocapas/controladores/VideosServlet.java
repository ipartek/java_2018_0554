package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.daos.*;
import com.ipartek.formacion.modelo.pojos.Video;

/**
 * Servlet implementation class VideoController
 */
public class VideosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private VideosDao dao = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//Se ejecuta con la primera peticion y solo una vez,
		//el resto de peticiones doService
		
		dao = new VideosDao();
	}
       
	   @Override
	public void destroy() {
		super.destroy();
		//se ejecuta al parar el servidor
		dao = null;
	}
	   
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		antes de DoGet o DoPost
		System.out.println("Antes de doGet o doPost");
		super.service(req, resp);
//		Despues de doGet o doPost
		System.out.println("Antes de doGet o doPost");
	}   
	   
	   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Video> videos = new ArrayList<Video>();
		
		request.setAttribute("videos", dao.getAll() );
		
		request.getRequestDispatcher("videos.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String busqueda = request.getParameter("busqueda");
		
		ArrayList<Video> videos = new ArrayList<Video>();
		
		VideosDao dao = new VideosDao();
		
		request.setAttribute("videos", dao.getAllByNombre(busqueda) );		
		request.setAttribute("busqueda", busqueda);
		request.getRequestDispatcher("videos.jsp").forward(request, response);
	}

}