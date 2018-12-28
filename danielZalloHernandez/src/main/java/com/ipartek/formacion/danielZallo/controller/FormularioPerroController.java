package com.ipartek.formacion.danielZallo.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.ipartek.formacion.danielZallo.modelo.pojo.Chip;
import com.ipartek.formacion.danielZallo.modelo.pojo.Perro;

/**
 * Servlet implementation class FormularioPerroController
 */
@WebServlet("/privado/insertarPerro")
public class FormularioPerroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_FORMULARIO="formularioPerro.jsp";
	private static final String CONTROLLER_LISTADO_PERROS="/privado/perros";
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(VIEW_FORMULARIO).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nPerro= request.getParameter("nPerro");
		String anios= request.getParameter("anios");
		String raza= request.getParameter("raza");
		String peso= request.getParameter("peso");
		String apadrinado= request.getParameter("apadrinado");
		String num_identifiacion= request.getParameter("num_identifiacion");
		String latitud= request.getParameter("latitud");
		String longitud= request.getParameter("longitud");
		
		Perro p= null;
		
		
		try {
			//Nombre, raza y los datos del chip tienes que estar para poder crear el perro sino mensaje de error;
			if(nPerro.equals("") || raza.equals("")||num_identifiacion.equals("")||latitud.equals("") || longitud.equals("")) {
				// En caso de que no estes la raza, el nombre ni el chip se envian al formulario los datos que ha introducido el usuario para que no escriba todo otra vez
				request.setAttribute("nPerro",nPerro);
				request.setAttribute("anios",anios);
				request.setAttribute("raza",raza);
				request.setAttribute("peso",peso);
				request.setAttribute("apadrinado",apadrinado);
				request.setAttribute("num_identifiacion",num_identifiacion);
				request.setAttribute("latitud",latitud);
				request.setAttribute("longitud",longitud);
				//El mensaje de error
				request.setAttribute("alerta", "Para ingresar un perro debe introducir los datos siguientes obligatoriamente: nombre,raza y los datos del chip");
				request.getRequestDispatcher(VIEW_FORMULARIO).forward(request, response);
			}
			//Obtengo los perros del servletContext
			HashMap<Long, Perro> perros = (HashMap<Long, Perro>) request.getServletContext().getAttribute("perros");
			
			//Obtengo el ultimo id del hasmap
			int idp=0;
			for(int i=1; i<=perros.size();i++) {
				if(i==perros.size()) {
					 idp = i;
					 idp++;
				}
			}
			//Creo el perro
			p = new Perro(Long.valueOf(idp), nPerro, Long.parseLong(anios), raza,Double.parseDouble(peso), apadrinado, new Chip(num_identifiacion, latitud, longitud));
			
			//Añado el perro al listado
			perros.put(Long.valueOf(idp), p);
			
			//actualizar 
			ServletContext sc =request.getServletContext();
			sc.setAttribute("perros", perros);
			
			
			response.sendRedirect(request.getContextPath() + CONTROLLER_LISTADO_PERROS);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
