package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.daos.UsuarioDAO;
import com.ipartek.formacion.modelo.pojos.Usuario;

/**
 * Servlet implementation class UsuarioController
 */
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		UsuarioDAO dao = new UsuarioDAO();		
		usuarios = dao.getAll();
		
		request.setAttribute("listado", usuarios);
		
		request.getRequestDispatcher("usuarios.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			//recoger parametros del formulario
			
			String email = request.getParameter("email");
			
			Usuario uNuevo = new Usuario();	
			try {
				//crear usuario nuevo   TODO hacer insert en base datos
				uNuevo = new Usuario();		
				uNuevo.setEmail(email);
				
			}catch (Exception e) {
				uNuevo = null;
				request.setAttribute("mensaje", "Los datos del usuario no son validos");
			}
			
			// añadir en listado
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();		
			UsuarioDAO dao = new UsuarioDAO();		
			usuarios = dao.getAll();
			
			if( uNuevo != null ) {
				usuarios.add(uNuevo);
			}	
			
			//enviar atributo para pintar JSP
			request.setAttribute("listado", usuarios);
			
		}catch (Exception e) {
			
			request.setAttribute("mensaje", "TENEMOS UN PROBLEMA SIN CONTROLAR");
		}finally {
			
			// Ir a JSP o VISTA
			request.getRequestDispatcher("usuarios.jsp").forward(request, response);
		}	
			
			
	}

}
