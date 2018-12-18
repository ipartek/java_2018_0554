package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelos.daos.VideoDAO;
import com.ipartek.formacion.modelos.pojos.Video;

public class VideoSrvLt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VideoDAO dao= new VideoDAO();
		if(dao.creatabla()) {
			ArrayList<Video> videos = new ArrayList<Video>();
			videos=dao.getAll();
			request.setAttribute("videos", videos);
			request.getRequestDispatcher("mitabla.jsp").forward(request, response);
			
		}else {
			request.getRequestDispatcher("principal.jsp").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String quebusco=(String)request.getParameter("busca");
		VideoDAO dao= new VideoDAO();
		ArrayList<Video> videos = new ArrayList<Video>();
			videos=dao.buscarvideo(quebusco);
			request.setAttribute("videos", videos);
			request.getRequestDispatcher("mitabla.jsp").forward(request, response);
		
		
	}

}
