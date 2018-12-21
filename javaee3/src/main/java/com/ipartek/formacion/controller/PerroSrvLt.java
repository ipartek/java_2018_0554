package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelos.daos.PerroDAO;

@WebServlet("/pral")
public class PerroSrvLt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PerroDAO dao;
	

    public PerroSrvLt() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
			dao=PerroDAO.getInstance();
			request.setAttribute("listado", dao.getAll());
			request.getRequestDispatcher("principal.jsp").forward(request, response);
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
