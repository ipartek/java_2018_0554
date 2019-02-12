package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


@WebServlet("/privado/principal")
public class PrincipalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//LOG
	private final static Logger LOG = Logger.getLogger(PrincipalController.class);
	//VISTAS
	private static final String PRINCIPAL_JSP = "principal.jsp";
	
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("Entrando a principal");
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher(PRINCIPAL_JSP).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	



}
