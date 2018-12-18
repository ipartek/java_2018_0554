package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
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
	private VideoDAO dao = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//Se ejecuta con la primera petición y sólo una vez, el resto de peticiones, "Service"
		dao = new VideoDAO();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		//Se ejecuta al parar el servidor
		dao = null;
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Se ejecuta antes de DoGet o DoPost
		//System.out.println("Antes de DoGet-DoPost");
		super.service(req, resp); //Aquí hace el GET o el POST
		//Se ejecuta despues de DoGet o DoPost
		//System.out.println("Después de DoGet-DoPost");

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Video> videos = dao.getAll();
		request.setAttribute("videos", videos);
		
		request.getRequestDispatcher("miTabla.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busqueda = request.getParameter("busqueda");
		
		ArrayList<Video> videosBuscados = dao.buscarVideo(busqueda);
		
		request.setAttribute("videosBuscados", videosBuscados);
		
		request.getRequestDispatcher("miTabla.jsp").forward(request, response);
	}

}

