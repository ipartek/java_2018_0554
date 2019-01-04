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

@WebServlet("/privado/buscar")
public class VideosController extends HttpServlet {
	//VISTAS
		private static final String VIEW_INDEX = "videos/index.jsp";
		private static final String VIEW_FORM = "videos/form.jsp";
	
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


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String texto = request.getParameter("textobuscar");
		
		try {
			ArrayList<Video> listadoVideosbuscados = dao.getAllByNombre(texto);
			request.setAttribute("videos", listadoVideosbuscados);
			request.setAttribute("texto", texto);
		}catch(Exception e) {
			e.printStackTrace();
		
		}finally {
			request.getRequestDispatcher(VIEW_INDEX).forward(request, response);
		}
	}

}
