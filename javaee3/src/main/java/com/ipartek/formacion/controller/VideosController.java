package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.daos.VideoDAO;
import com.ipartek.formacion.modelo.pojos.Video;

/**
 * Servlet implementation class VideosController
 */
@WebServlet("/privado/videos")
public class VideosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO dao;  
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//se ejecuta con la primera peticion y solo una vez, el resto de peticiones "service"
		dao = new VideoDAO();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		//se ejecuta al parar el servidor
		dao = null;
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Antes de doGet o doPost
		System.out.println("Antes de doGet o doPost");
		
		super.service(req, resp);
		
		//Despues de doGet o doPost
		System.out.println("Antes de doGet o doPost");
	}
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Video> videos = new ArrayList<Video>();
		
		request.setAttribute("videos", dao.getAll());
		
		request.getRequestDispatcher("principal.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
