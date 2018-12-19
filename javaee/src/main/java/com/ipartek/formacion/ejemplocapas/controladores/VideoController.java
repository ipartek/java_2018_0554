package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.daos.VideoDAO;
import com.ipartek.formacion.modelo.pojos.Video;

/**
 * Servlet implementation class VideoController
 */
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private VideoDAO dao = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// se ejecuta con la primera petición y solo una vez, el resto de peticiones "service"
		dao = new VideoDAO();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		// se ejecuta al parar el servidor
		dao = null;
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		//Antes de doGet o doPost
		System.out.println("Antes de doGet o doPost");
		super.service(req, resp);
		System.out.println("Despues de doGet o doPost");
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
		
		VideoDAO dao = new VideoDAO();
		
		request.setAttribute("videos", dao.getAllByNombre(busqueda) );		
		request.setAttribute("busqueda", busqueda);
		request.getRequestDispatcher("videos.jsp").forward(request, response);
	}

}