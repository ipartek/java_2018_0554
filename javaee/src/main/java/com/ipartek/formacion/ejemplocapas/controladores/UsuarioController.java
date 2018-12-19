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

		request.getRequestDispatcher("usuarios.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAO dao = new UsuarioDAO();
		
		ArrayList<Usuario> usuarios = dao.getAll();
		
		Usuario usuario = new Usuario();
		
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {

			usuario.setId(Long.parseLong(id));
			usuario.setEmail(email);
			usuario.setPassword(password);
			
			usuarios.add(usuario);
		}catch (PojoException e) {
			usuario = null;
			request.setAttribute("mensaje", e.getMessage());
		}catch (NumberFormatException e) {
			usuario = null;
			request.setAttribute("mensaje", "No has introducido un ID");
		}catch (Exception e) {
			usuario = null;
			request.setAttribute("mensaje", e.getMessage());
		}finally {
			request.setAttribute("id", id);
			request.setAttribute("email", email);
			request.setAttribute("password", password);
		}
		
		request.setAttribute("listado", usuarios);
		request.getRequestDispatcher("usuarios.jsp").forward(request, response);
		
	}
}
