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
 * Servlet implementation class VideosServlet
 */
public class VideosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VISTA_VIDEOS= "videos.jsp";



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VideosDAO dao = new VideosDAO();
		ArrayList<Video> videos = dao.getAll();
		
		request.setAttribute("misVideos", videos);
		request.getRequestDispatcher(VISTA_VIDEOS).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video video= null;
		String nombreVideo = request.getParameter("nombreVideo");
		
		try {
			VideosDAO dao = new VideosDAO();
			video = dao.getByNombre(nombreVideo);
			if (video != null) {
				request.setAttribute("video", video);
			} else {
				request.setAttribute("error", "Ese video no existe");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			request.getRequestDispatcher(VISTA_VIDEOS).forward(request, response);
		}
		
		
	}

}
