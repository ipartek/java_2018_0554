package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.daos.VideosDAO;
import com.ipartek.formacion.modelo.pojos.Video;

/**
 * Servlet implementation class CarritoController
 */
public class CarritoController extends HttpServlet {
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

//			Recibir parametros -> id
		String id = request.getParameter("id");
		Video video = null;
		
//			Buscar en base datos el video por ID

			Long idLong = Long.parseLong(id);
			VideosDAO dao = new VideosDAO();			
			Video videoIns = dao.getById(idLong);
			
			
	
		
		
//			Recuperar carrito de sesion del usuario

			HttpSession session = request.getSession();
			
			ArrayList<Video> carrito = (ArrayList<Video>) session.getAttribute("carrito");

			if (carrito == null) {
				
				carrito = new ArrayList<Video>();
			}

			
		
//			Añadimos el nuevo video
			carrito.add(videoIns);
		
		
//			Guardar el carrito en la sesion
			session.setAttribute("carrito", carrito);
		
//			Redirigir a videos (http://localhost:8080/javaee/videos)
			response.sendRedirect("videos.jsp");
	}

}
