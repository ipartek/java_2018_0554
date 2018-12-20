package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.daos.VideoDAO;
import com.ipartek.formacion.modelo.pojo.Video;

/**
 * Servlet implementation class VideosController
 */
@WebServlet("/privado/videos")
public class VideosController extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	private VideoDAO dao = null;
       
	
	@Override
	public void init(ServletConfig config) throws ServletException {		
		super.init(config);
		// se ejecuta con la 1º peticion y solo una vez, el resto de peticion "service"
		dao = new VideoDAO();
	}
   
	@Override
	public void destroy() {	
		super.destroy();
		//se ejecuta al para el servidor
		dao = null;
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Antes de doGet o doPost
		
		super.service(req, resp);		
		
		// Despues de doGet o doPost
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				
		request.setAttribute("videos", dao.getAll() );
		
		request.getRequestDispatcher("principal.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		String busqueda = request.getParameter("busqueda");
//		
//		ArrayList<Video> videos = new ArrayList<Video>();
//				
//		request.setAttribute("videos", dao.getAllByNombre(busqueda) );		
//		request.setAttribute("busqueda", busqueda);
//		request.getRequestDispatcher("principal.jsp").forward(request, response);
		
	}

}