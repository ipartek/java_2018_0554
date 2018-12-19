package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.daos.UsuarioDAO;
import com.ipartek.formacion.modelo.pojos.PojoException;
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
		
		request.getRequestDispatcher("usuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			//recoger parametros del formulario
			
			String id = request.getParameter("id");
			String email = request.getParameter("email");			
			String password = request.getParameter("password");
			
//			Long idid = Long.parseLong(id);
			
			
			Usuario uNuevo = new Usuario();	
			try {
				//crear usuario nuevo   TODO hacer insert en base datos
								
				uNuevo = new Usuario();
				uNuevo.setId( Long.parseLong(id));
				uNuevo.setEmail(email);
				uNuevo.setPassword(password);
				
			}catch (NumberFormatException e) {
				uNuevo = null;		
				request.setAttribute("mensaje", "El id debe ser numerico");
			}catch (PojoException e) {
				uNuevo = null;		
				request.setAttribute("mensaje", e.getMessage() );
			
			}catch (Exception e) {
				uNuevo = null;				
				request.setAttribute("mensaje", "Los datos del usuario no son validos");
			}finally {
				request.setAttribute("email", email);
				request.setAttribute("id", id);
				request.setAttribute("password", password);
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
			request.getRequestDispatcher("usuario.jsp").forward(request, response);
		}	
			
			
	}

}