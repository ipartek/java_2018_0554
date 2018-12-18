package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AntiguoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
//		
//		if("javier@lete.com".equals(usuario.getEmail()) && "Pa$$w0rd".equals(usuario.getPassword())) {
//			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
//			
//			usuarios.add(new Usuario(1L, "javier@lete.com", "Pa$$w0rd"));
//			usuarios.add(new Usuario(2L, "pepe@perez.com", "Pa$$w0rd"));
//			
//			request.setAttribute("usuarios", usuarios);
//			
//			request.getSession().setAttribute("usuario", usuario);
//			
//			request.getRequestDispatcher("principal.jsp").forward(request, response);
//		} else {
//			//response.sendRedirect("login.jsp");
//			request.setAttribute("error", "No tienes permiso para login");
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//		}
//		//response.getWriter().println("Hola " + usuario.getEmail());
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
//			comprobar que existe el driver mysql
			Class.forName("com.mysql.jdbc.Driver").newInstance();

		} catch (Exception e) {
//			request.setAttribute("error", "No tienes las dependencias necesarias");
		}
//		
//		Usuario usuario;
//
//		try {
//			usuario = new Usuario(null, email, password);
//		} catch(PojoException e) {
//			//response.sendRedirect("login.jsp");
//			if(email != null && password != null) {
//				request.setAttribute("error", "Error en el formato de email o contraseña");
//			}
//			
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//			
//			return;
//		}
//		CONEXION BBDD
		try {
			// conexion a la bbdd
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.44/youtube?useSSL=false", "viernes",
					"juernes");

			// crear la consulta
			String sql = "SELECT nombre, password from usuario where nombre='" + email + "'and password='" + password
					+ "'";

			// decir que la consulta es una sentencia preparata
			PreparedStatement pst = conn.prepareStatement(sql);

			// ejecutar la consulta y guardar el resultado en "rs"
			ResultSet rs = pst.executeQuery();

			// mientras "rs" tenga resultados muestra los campos
			while (rs.next()) {
				request.getRequestDispatcher("prueba.jsp").forward(request, response);
			}
			rs.close();
			pst.close();
			conn.close();

		} catch (Exception e) {
			request.setAttribute("error", "No tienes permiso para login");
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}
	}

}
