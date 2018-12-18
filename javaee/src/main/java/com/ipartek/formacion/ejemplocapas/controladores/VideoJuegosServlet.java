package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.pojos.Video;
import com.ipartek.formacion.modelo.pojos.VideoJuego;

/**
 * Servlet implementation class VideoJuegosServlet
 */
public class VideoJuegosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<VideoJuego> videojuegos = new ArrayList<VideoJuego>();
		videojuegos.add(new VideoJuego(1L,"God of War","Sony","https://los40.com/los40/imagenes/2018/03/20/videojuegos/1521544253_597018_1521544350_noticia_normal.jpg"));
		videojuegos.add(new VideoJuego(1L,"The Last Of Us","Sony","https://upload.wikimedia.org/wikipedia/en/thumb/4/46/Video_Game_Cover_-_The_Last_of_Us.jpg/220px-Video_Game_Cover_-_The_Last_of_Us.jpg"));
		videojuegos.add(new VideoJuego(1L,"Uncharted 3","Sony","https://i.ytimg.com/vi/lXQpESBaszE/maxresdefault.jpg"));
		
		request.setAttribute("videojuegos", videojuegos );
		
		request.getRequestDispatcher("videojuegos.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String busqueda = (String)request.getParameter("busqueda");
		ArrayList<VideoJuego> videojuegos = new ArrayList<VideoJuego>();
		videojuegos.add(new VideoJuego(1L,"God of War","Sony","https://los40.com/los40/imagenes/2018/03/20/videojuegos/1521544253_597018_1521544350_noticia_normal.jpg"));
			
		request.setAttribute("videojuegos", videojuegos);
		request.setAttribute("busqueda", busqueda);
		request.getRequestDispatcher("videojuegos.jsp").forward(request, response);
	}

}
