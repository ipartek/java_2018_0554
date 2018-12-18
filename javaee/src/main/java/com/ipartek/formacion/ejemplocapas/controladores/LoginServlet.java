package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemplocapas.pojos.PojoException;
import com.ipartek.formacion.ejemplocapas.pojos.Usuario;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean usuarioCorrecto = false;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Usuario usuario;

		try {
			usuario = new Usuario(0, email, password);
		} catch (PojoException e) {
			if (email != null && password != null) {
				request.setAttribute("error", "Error en el formato de email o contraseña");
			}

			request.getRequestDispatcher("login.jsp").forward(request, response);

			return;
		}

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

		} catch (Exception e) {
			e.printStackTrace();
		}

		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.0.44/youtube?useSSL=false", "viernes", "juernes");

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT id, nombre, password FROM usuario WHERE nombre='" + email
					+ "' AND password='" + password + "'");
			while (rs.next()) {
				if (email.equals(rs.getString("nombre")) && password.equals(rs.getString("password"))) {
					usuarioCorrecto = true;
					break;
				}
			}
			rs.close();
			if (usuarioCorrecto) {
				ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
				ResultSet rsCompleto = stmt.executeQuery("SELECT id, nombre, password FROM usuario");
				while (rsCompleto.next()) {
					usuarios.add(new Usuario(rsCompleto.getInt("id"), rsCompleto.getString("nombre"),
							rsCompleto.getString("password")));
				}
				request.setAttribute("usuarios", usuarios);
				request.getSession().setAttribute("usuario", usuario);
				request.getRequestDispatcher("principal.jsp").forward(request, response);
				rsCompleto.close();
			} else {
				request.setAttribute("error", "No tienes permiso para login");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}