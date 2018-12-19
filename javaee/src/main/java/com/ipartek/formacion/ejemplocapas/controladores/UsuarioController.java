package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.daos.UsuarioDAO;
import com.ipartek.formacion.modelo.pojos.PojoException;
import com.ipartek.formacion.modelo.pojos.Usuario;
import com.ipartek.formacion.modelo.pojos.UsuarioNoValido;

/**
 * Servlet implementation class UsuarioController
 */
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO dao = null;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = new UsuarioDAO();
	}

	@Override
	public void destroy() {
		super.destroy();
		// Se ejecuta al parar el servidor

		dao = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Usuario> usuariosValidos = dao.getAll();
		ArrayList<UsuarioNoValido> usuariosNoValidos = dao.getAllNoValid();

		request.setAttribute("listado", usuariosValidos);
		// meto el array list de usuarios no validos en la session para tenerlo en todo
		// momento
		HttpSession session = request.getSession();
		session.setAttribute("usuariosNoValidos", usuariosNoValidos);

		request.getRequestDispatcher("usuarios.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recoger parametros
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String id = request.getParameter("id");
		try {
			Usuario uNuevo= new Usuario();
			try {
				uNuevo = new Usuario();
				uNuevo.setId(Long.parseLong(id));
				uNuevo.setEmail(email);
				uNuevo.setPassword(password);
			} catch (PojoException e) {
				uNuevo=null;
				request.setAttribute("errorMensajeCrear", e.getMessage());
		
			} catch (Exception e) {
				uNuevo=null;
				request.setAttribute("errorMensajeCrear", "Los datos del usuario no son validos");
			} finally {
				request.setAttribute("id", id);
				request.setAttribute("email", email);
				request.setAttribute("password", password);
			}
			
			ArrayList<Usuario> usuarios = new ArrayList<>();
			usuarios = dao.getAll();

			if (uNuevo != null) {
				usuarios.add(uNuevo);
			}

			request.setAttribute("listado", usuarios);
			
			
		} catch (Exception e) {
			request.setAttribute("errorMensajeCrear", "No sabes ni tu lo que te esta fallando");
		}finally {
			request.getRequestDispatcher("usuarios.jsp").forward(request, response);

		}
		

	}

}
