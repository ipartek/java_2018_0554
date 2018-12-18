package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelos.daos.VideoDAO;
import com.ipartek.formacion.modelos.pojos.Video;

public class VideoSrvLt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO dao = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//inicio solo 1 vez
		dao=new VideoDAO();
	}

	@Override
	public void destroy() {
		dao=null;
		super.destroy();
		//cierre serv
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//antes doget dopost
		System.out.println("antes");
		super.service(req, resp);
		System.out.println("despues");
		//despues doget dopost
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (dao.creatabla()) {
			ArrayList<Video> videos = new ArrayList<Video>();
			request.setAttribute("videos", dao.getAll());
			request.getRequestDispatcher("mitabla.jsp").forward(request, response);

		} else {
			request.getRequestDispatcher("principal.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String quebusco = (String) request.getParameter("busca");
		VideoDAO dao = new VideoDAO();
		ArrayList<Video> videos = new ArrayList<Video>();
		videos = dao.buscarvideo(quebusco);
		request.setAttribute("videos", videos);
		request.setAttribute("busqueda", quebusco);
		request.getRequestDispatcher("mitabla.jsp").forward(request, response);

	}

}
