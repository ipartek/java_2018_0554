package com.ipartek.formacion.controller;

import java.io.IOException;




import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


@WebServlet("/cambioidioma")
public class CambioIdiomaSrvLt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(CambioIdiomaSrvLt.class);


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idioma= request.getParameter("i");
		Cookie cIdioma = new Cookie("cIdioma", idioma);
		cIdioma.setMaxAge(60*10);	
		response.addCookie(cIdioma);
//		HttpSession session= request.getSession();
//		session.setAttribute("language", idioma);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
