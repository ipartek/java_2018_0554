package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.dao.VideoDAO;
import com.ipartek.formacion.pojo.Video;

@WebServlet("/privado/videos")
public class VideosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO dao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		dao = VideoDAO.getInstance();
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Video> videos = new ArrayList<Video>();

		videos = dao.getAll();

		request.setAttribute("videos", videos);

		request.getRequestDispatcher("principal.jsp").forward(request, response);
	}

}
