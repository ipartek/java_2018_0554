package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.ipartek.formacion.modelo.daos.VideoDAO;
import com.ipartek.formacion.modelo.pojo.Video;

/**
 * Servlet implementation class VideosController
 */
@WebServlet("/privado/videos")
public class VideosController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private VideoDAO dao;
	private ValidatorFactory factory;
	private Validator validator;
       
    @Override
    public void init(ServletConfig config) throws ServletException {    
    	super.init(config);
    	dao = VideoDAO.getInstance();    	
    	factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setAttribute("videos", dao.getAll());
		
		request.getRequestDispatcher("principal.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String texto = request.getParameter("textobuscar");
		
		try {
			//VideoDao dao = new VideoDao();
			ArrayList<Video> listadoVideosbuscados = dao.getAllByNombre(texto);
			request.setAttribute("videos", listadoVideosbuscados);
			request.setAttribute("texto", texto);
			
			/*VideoDao dao2 = new VideoDao();
			ArrayList<Video> listadoVideos = dao2.listarVideos();
			request.setAttribute("listadoVideos", listadoVideos);*/
		}catch(Exception e) {
			e.printStackTrace();
		
		}finally {
			request.getRequestDispatcher("principal.jsp").forward(request, response);
		}
	}

}
