package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.dao.UsuarioDAO;
import com.ipartek.formacion.modelo.dao.VideoDAO;

/**
 * Servlet implementation class BackOfficeController
 */
@WebServlet("/privado/backoffice")
public class BackOfficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO usuarioDao = null;
	private VideoDAO videoDao = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		usuarioDao = UsuarioDAO.getInstance();
		videoDao = VideoDAO.getInstance();
	}
	
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
		
		request.setAttribute("n_usuarios", usuarioDao.countUsers());
		request.setAttribute("n_videos", videoDao.countVideos());
		
		request.getRequestDispatcher("backoffice/index.jsp").forward(request, response);
	}

}
