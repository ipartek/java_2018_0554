package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.daos.VideoDao;
import com.ipartek.formacion.modelo.pojos.Video;


public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		VideoDao dao = new VideoDao();
		ArrayList<Video> listadoVideos = dao.listarVideos();
		request.setAttribute("listadoVideos", listadoVideos);
	}catch(Exception e) {e.printStackTrace();
	}finally {
		request.getRequestDispatcher("videos.jsp").forward(request, response);
	}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String texto = request.getParameter("textoBuscar").trim();
		
		try {
			VideoDao dao = new VideoDao();
			ArrayList<Video> listadoVideosbuscados = dao.listarVideosBuscados(texto);
			request.setAttribute("listadoVideosbuscados", listadoVideosbuscados);
			request.setAttribute("texto", texto);
			
			/*VideoDao dao2 = new VideoDao();
			ArrayList<Video> listadoVideos = dao2.listarVideos();
			request.setAttribute("listadoVideos", listadoVideos);*/
		}catch(Exception e) {
			e.printStackTrace();
		
		}finally {
			request.getRequestDispatcher("videos.jsp").forward(request, response);
		}
	}

}
