package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.daos.UsuarioDAO;
import com.ipartek.formacion.modelo.daos.VideoDAO;


@WebServlet("/privado/principal")
public class PrincipalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//LOG
	private final static Logger LOG = Logger.getLogger(VideosCrudController.class);
	//VISTAS
	private static final String PRINCIPAL_JSP = "principal.jsp";
	
	private static VideoDAO videoDAO = null;
	private static UsuarioDAO usuarioDAO = null;
    
    
    @Override
    public void init(ServletConfig config) throws ServletException {    
    	super.init(config);
    	videoDAO = videoDAO.getInstance();
    	usuarioDAO = usuarioDAO.getInstance();
    	
    }


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("contadorvideos", videoDAO.getCount());
		
		request.setAttribute("contadorusuarios", usuarioDAO.getCount());
		
		request.getRequestDispatcher(PRINCIPAL_JSP).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	



}
