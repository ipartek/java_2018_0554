package com.ipartek.formacion.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelos.daos.PerroDAO;


public class PerroSrvLt extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PerroSrvLt() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
			PerroDAO dao = new PerroDAO();
			request.setAttribute("listado", dao.getAll());
			request.getRequestDispatcher("misperros.jsp").forward(request, response);
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
