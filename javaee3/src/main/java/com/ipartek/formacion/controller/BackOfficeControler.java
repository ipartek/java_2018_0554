package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelos.daos.UsuarioDAO;
import com.ipartek.formacion.modelos.daos.VideosDAO;

/**
 * Servlet implementation class BackOfficeControler
 */
@WebServlet("/privado/backoffice")
public class BackOfficeControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_PRINCIPAL = "/privado/index.jsp";
	private UsuarioDAO daoUsuarios;
	private VideosDAO daoVideo;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoUsuarios=UsuarioDAO.getInstance();
		daoVideo=VideosDAO.getInstance();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		daoUsuarios=null;
		daoVideo=null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int totalVideos=daoVideo.count();
		int totalUsuarios =daoUsuarios.count();
		request.setAttribute("totalVideos", totalVideos);
		request.setAttribute("totalUsuarios", totalUsuarios);
		
		
		request.getRequestDispatcher(VIEW_PRINCIPAL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
