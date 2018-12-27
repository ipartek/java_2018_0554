package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.dao.VideoDAO;
import com.ipartek.formacion.modelo.pojo.Video;

/**
 * Servlet implementation class CarritoController
 */
@WebServlet("/privado/comprar")
public class ComprarController extends HttpServlet {
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
		String id = request.getParameter("idVideo");
		Video video = null;
		
//			Buscar en base datos el video por ID

			Long idLong = Long.parseLong(id);
			VideoDAO dao = VideoDAO.getInstance();			
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
		
//			Redirigir a videos (http://localhost:8080/libros/videos)
			response.sendRedirect("carrito.jsp");
	}

}
