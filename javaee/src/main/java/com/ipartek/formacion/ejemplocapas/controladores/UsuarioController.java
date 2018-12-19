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

public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		// Obtener usuarios de la base de datos
		UsuarioDAO dao = new UsuarioDAO();
		usuarios = dao.getAll();
		
		// Pasar listado de usuarios al JSP usuarios.jsp
		request.setAttribute("listado", usuarios);

		// redirigir listado a página jsp
		request.getRequestDispatcher("usuarios.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Obtener usuarios de la base de datos

		// Recoger datos del nuevo usuario
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String id = request.getParameter("id");

		try {		

			Usuario uNuevo = new Usuario();

			try {
						
				uNuevo.setEmail(email);
				uNuevo.setPassword(pass);
				uNuevo.setId(Long.parseLong(id));
			}catch (NumberFormatException e) {
				uNuevo = null;
				request.setAttribute("mensaje", "El id debe ser un número");
				request.setAttribute("email",email);
				request.setAttribute("pass",pass);
			}catch(PojoException e){
				uNuevo = null;
				request.setAttribute("mensaje", e.getMessage());
				request.setAttribute("id",id);
			}catch (Exception e) {
				uNuevo = null;
				request.setAttribute("mensaje", "los datos del usuario no son validos");
				request.setAttribute("email",email);
				request.setAttribute("pass",pass);
				request.setAttribute("id",id);
			}

			// Crear nuevo usuario y añadirlo al listado
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

			UsuarioDAO dao = new UsuarioDAO();
			usuarios = dao.getAll();

			if( uNuevo != null ) {
				usuarios.add(uNuevo);
			}
			
			request.setAttribute("listado", usuarios);

		} catch (Exception e) {
			// Pasar listado de usuarios al JSP usuarios.jsp
			request.setAttribute("mensaje", "tenemos un problema");
		} finally {
			// redirigir listado a página jsp
			request.getRequestDispatcher("usuarios.jsp").forward(request, response);
		}
	}

}
