package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestorRetro
 */
public class GestorRetro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GestorRetro() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList <Retro> retro= new ArrayList<Retro>();
		
		//Defino retro
		
		request.setAttribute(Retro, retro);
		
		
		
		//pido atributos Retro
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
