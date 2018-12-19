package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.daos.VideosDao;
import com.ipartek.formacion.modelo.pojos.Video;

/**
 * Servlet implementation class CarritoServlet
 */
public class CarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recibir parametros --> id
		String id = request.getParameter("id");
		Long idV = Long.parseLong(id);
		//buscar en base de datos el video por id
		VideosDao dao = new VideosDao();
		Video vid = dao.getById(idV);
		
		
		//recuperamos carrito de session de usuario
		HttpSession session = request.getSession();
		
		ArrayList<Video> videoscarr = (ArrayList<Video>)session.getAttribute("carrito");
		
		//añadimos el nuevo video 
		if(videoscarr == null) {
			videoscarr = new ArrayList<Video>();
			
		}
		
		videoscarr.add(vid);
		
		//guardamos el carrito en session con el nuevo video
		session.setAttribute("carrito", videoscarr);
		
		
		//redirect a --> http://localhost:8080/javaee/videos
		response.sendRedirect("videos");
	}

}
