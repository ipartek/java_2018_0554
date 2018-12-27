package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.pojo.Video;

/**
 * Servlet implementation class ComprarServlet
 */
public class ComprarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String idVideoString = request.getParameter("idVideo");
			Long idVideo = Long.parseLong(idVideoString);
			String tituloVideo = request.getParameter("tituloVideo");
			String urlVideo = request.getParameter("urlVideo");

			ArrayList<Video> videoscarrito = new ArrayList<Video>();
			videoscarrito.add(new Video(idVideo, tituloVideo, urlVideo));
			
//			guardar la sesion
			HttpSession sessioncarrito = request.getSession();
			sessioncarrito.setMaxInactiveInterval(60 * 5); //5 minutos TAMBIEN SE PUEDE CONFIGURAR EN WEB.XML
			sessioncarrito.setAttribute("videoscarrito", videoscarrito);
			
			request.getRequestDispatcher("carrito.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
