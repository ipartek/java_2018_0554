package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelos.pojos.Pagina;

@WebServlet("/pagina")
public class PaginaSrvLt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TreeMap<Integer,Pagina> libro ;
	
	@Override
	public void init() throws ServletException {
		super.init();
		libro = new TreeMap<Integer,Pagina>();
		libro.put ( 1 , new Pagina(1,"autor1","texto1"));
		libro.put ( 2 , new Pagina(2,"autor2","texto2"));
		libro.put ( 3 , new Pagina(3,"autor3","texto3"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			int paginaactual=0;
			
			String recibepagina=request.getParameter("pag");
			if (recibepagina==null) {
				request.setAttribute("error", "No se han publicado páginas");
			}else {
				paginaactual=Integer.parseInt(recibepagina);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
