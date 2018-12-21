package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ipartek.formacion.modelo.pojos.Pagina;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Pagina> pagina = new ArrayList<Pagina>();

		pagina.add(new Pagina(1L,"Cervantes","Cuerpo de la pagina"));
		pagina.add(new Pagina(2L,"Otro ","segundo Cuerpo de la pagina"));
		pagina.add(new Pagina(3L,"Otro mas","tercer Cuerpo de la pagina"));
		boolean primera = true;
		 
		request.setAttribute("primera", primera);
		request.setAttribute("libro", pagina);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
