package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelos.pojos.Pagina;
import com.ipartek.formacion.modelos.pojos.Usuario;

@WebServlet("/nuevapag")
public class NuevapagSrvLt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL="pagina?pag=";
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String texto=request.getParameter("texto");
		String direccion=URL;
		HttpSession session= request.getSession();
		ArrayList<Pagina> libro= (ArrayList<Pagina>) request.getServletContext().getAttribute("libro");
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		Pagina pagina;
		if(texto!=null && texto!="") {
			pagina=new Pagina();
			
			pagina.setAutor(usuario.getNombre());
			pagina.setContenido(texto);
			
			libro.add(pagina);
			
			direccion+=libro.size()-1;
			request.getServletContext().setAttribute("libro", libro);
		}else {
			direccion+=0;
			request.setAttribute("error", "No se ha escrito ningun texto");
			
		}
		request.getRequestDispatcher(direccion).forward(request, response);
		
	}

}
