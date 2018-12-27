package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelos.pojos.Usuario;

@WebServlet("/login")
public class LoginSrvLt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Usuario> usuarios;
	Usuario usuario;

	@Override
	public void init() throws ServletException {
		super.init();
		usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario(1, "uno@uno.com", "Pa$$w0rd", "autor1"));
		usuarios.add(new Usuario(2, "dos@dos.com", "Pa$$w0rd", "autor2"));
		usuarios.add(new Usuario(3, "tres@tres.com", "Pa$$w0rd", "autor3"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String usu = request.getParameter("usu");
		String pass = request.getParameter("pass");
		String idioma = request.getParameter("idioma");
		Date fecha= new Date();
		usuario = null;
		String cual="";
		boolean encontrada=false;
		Cookie cookie=null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if ("cIdioma".equals(cookie.getName())) {
					cookie.setValue(idioma);
					encontrada=true;
					cual="idioma";
				}else if ("cVisita".equals(cookie.getName())) {
					cookie.setValue(fecha.toString());
					encontrada=true;
					cual="visita";
				}else if ("cEmail".equals(cookie.getName())) {
					cookie.setValue(usuario.getEmail());
					encontrada=true;
					cual="email";
				}
			}
		}
		if (!encontrada) {
			switch (cual) {
			case "visita":
				Cookie cVisita = new Cookie("cVisita", fecha.toString() );
				cVisita.setMaxAge(60*10);	
				response.addCookie(cVisita);
				break;
			case "idioma":
				Cookie cIdioma = new Cookie("cIdioma", idioma);
				cIdioma.setMaxAge(60*10);	
				response.addCookie(cIdioma);
				break;
			case "email":
				Cookie cEmail = new Cookie("cEmail", usuario.getEmail() );
				cEmail.setMaxAge(60*10);	
				response.addCookie(cEmail);
				break;
			default:
				break;
			}
			
		}
	
		for (Usuario u : usuarios) {
			if (u.getEmail().equals(usu) && u.getPassword().equals(pass)) {
				usuario = u;
				break;
			}
		}
		if (usuario != null) {
			HttpSession session = request.getSession();
			// listener contador
		

			session.setMaxInactiveInterval(60 * 5);
			session.setAttribute("usuario", usuario);
			session.setAttribute("libro", request.getAttribute("libro"));
			
			request.getRequestDispatcher("/edicion/agregarlibro.jsp").forward(request, response);

		} else {
			request.setAttribute("error", "Credenciales no válidas");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
