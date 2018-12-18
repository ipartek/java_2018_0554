package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.daos.VideosDAO;
import com.ipartek.formacion.modelo.pojos.Video;

public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private VideosDAO dao = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		VideosDAO dao = null;
		super.init(config);
		// Se ejecuta con la primera petición y solo una vez, el resto de peticiones
		// service
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		dao = null;
		super.destroy();
		// Se ejecuta al detener el servidor
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Esto se ejecuta
		// Antes del doGet y del doPost
		System.out.println("Antes del doGet y del doPost");
		super.service(req, resp);
		System.out.println("Después del doGet o doPost");
		// Despues del doGet o doPost
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Video> videos = new ArrayList<Video>();

		request.setAttribute("videos", dao.getAll());

		request.getRequestDispatcher("video.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String busqueda = request.getParameter("busqueda");

		ArrayList<Video> videos = new ArrayList<Video>();

		VideosDAO dao = new VideosDAO();

		request.setAttribute("videos", dao.getAllByNombre(busqueda));
		request.setAttribute("busqueda", busqueda);
		request.getRequestDispatcher("video.jsp").forward(request, response);
	}

}