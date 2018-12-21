package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacin.pojo.Pagina;


@WebServlet("/paginas")
public class PaginasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int actual=0;
		
		String actualrecogido=request.getParameter("actual");
		if(actualrecogido!=null) {
		actual=Integer.parseInt(actualrecogido);
		}
		ArrayList<Pagina> libro= new ArrayList<Pagina>();
		libro.add(new Pagina("Autor1","Texto1"));
		libro.add(new Pagina("Autor2","Texto2"));
		libro.add(new Pagina("Autor3","Texto3"));
		
		request.setAttribute("paginastotales", libro.size());
		
		
		request.setAttribute("pagina", libro.get(actual));
		request.setAttribute("paginaactual", libro.indexOf(libro.get(actual)));
		
		request.getRequestDispatcher("libro.jsp").forward(request, response);
		
	}


	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	
	
	
	
}
