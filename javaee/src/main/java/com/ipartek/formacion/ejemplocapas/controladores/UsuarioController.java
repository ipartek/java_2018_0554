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
		//		recoger parametros del formulario
				
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				Long id = Long.parseLong(request.getParameter("id"));

//				Guardar los parametros

				
				Usuario uNuevo = new Usuario();
				try {
	//				Crear nuevo usuario
					uNuevo = new Usuario();
					uNuevo.setId(id);
					uNuevo.setEmail(email);
					uNuevo.setPassword(password);
				}catch(Exception e) {
					request.setAttribute("emailValue", email);
					request.setAttribute("passwordValue", password);
					request.setAttribute("idValue", id);
					uNuevo = null;
					request.setAttribute("mensaje", "Datos no validos");
				}
				
		//		Añadir en listado
				ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
				UsuarioDAO dao = new UsuarioDAO();
				usuarios = dao.getAll();
				if(uNuevo != null) {
					usuarios.add(uNuevo);
				}
				
				
		//		enviar atributo para jsp
				request.setAttribute("listado", usuarios);
		}catch(Exception e) {
			
				request.setAttribute("mensaje", "Hay un problema sin controlar");
			
		}finally {
		//		ir a jsp
				request.getRequestDispatcher("usuarios.jsp").forward(request, response);
		}
	}

}
