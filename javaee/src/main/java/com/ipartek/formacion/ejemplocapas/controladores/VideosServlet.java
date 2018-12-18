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

/**
 * Servlet implementation class VideosServlet
 */
public class VideosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VISTA_VIDEOS = "videos.jsp";
	private VideosDAO dao = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//se ejecuta con la 1º petición y solo una vez, el resto de peticiones iran al "service"
		dao = new VideosDAO();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		//Se ejecuta al parar el servidor
		
		dao= null;
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Antes de doGet o do Post
		System.out.println("Antes de doGet o doPost");
		
		super.service(req, resp);
		
		//Desues de doGet o doPost
		System.out.println("Despues de doGet o doPost");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		ArrayList<Video> videos = dao.getAll();

		request.setAttribute("misVideos", videos);
		request.getRequestDispatcher(VISTA_VIDEOS).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Video video = null;
		String nombreVideo = request.getParameter("nombreVideo");
		ArrayList<Video> videos = new ArrayList<>();
		try {
			// Creo el dao para hacer la llamar el metodo getByNombre
			
			videos = dao.getByNombre(nombreVideo);

				request.setAttribute("busqueda", nombreVideo);
				request.setAttribute("misVideos", videos);


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher(VISTA_VIDEOS).forward(request, response);
		}

	}

}
