package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.daos.VideoDAO;
import com.ipartek.formacion.modelo.pojos.Video;

/**
 * Servlet implementation class VideoServlet
 */
public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VideoDAO dao = new VideoDAO();
		ArrayList<Video> videos = dao.getAll();
		request.setAttribute("videos", videos);
		
		request.getRequestDispatcher("miTabla.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busqueda = request.getParameter("busqueda");
		
		VideoDAO dao = new VideoDAO();
		ArrayList<Video> videosBuscados = dao.buscarVideo(busqueda);
		
		request.setAttribute("videosBuscados", videosBuscados);
		
		request.getRequestDispatcher("miTabla.jsp").forward(request, response);
	}

}

