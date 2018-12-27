package com.ipartek.formacion.libroCompartido.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.libroCompartido.modelo.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Usuario> usuariosRegistrados = new ArrayList<>();
	private static final String VIEW_LOGIN = "login.jsp";
	private static final String CONTROLER_CREARPAGINA = "privado/nuevaPagina";
	private final static Logger LOG = Logger.getLogger(LoginController.class);
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		 usuariosRegistrados.add(new Usuario(1L, "Manolo", "Manolo1234."));
		 usuariosRegistrados.add(new Usuario(2L, "Pepe", "Pepe1234."));
		 usuariosRegistrados.add(new Usuario(3L, "Daniel", "Daniel1234."));
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario= request.getParameter("usuario");
		String password =request.getParameter("pass");
		String idiomaSeleccionado = request.getParameter("idiomaSeleccionar");
		
		
		String vista = VIEW_LOGIN;
		Usuario usuarioLogeado= null;
		try {
			//declarar la session
			HttpSession session = request.getSession();
			
			//idioma TODO ver porque al poner eu_ES sale es_ES
			Locale locale = new Locale("eu_ES");
			
			// Debemos indicara el package donde se encuentra y el nombre del /properties sin la extension del locale 
			ResourceBundle messages = ResourceBundle.getBundle("i18nmessages", locale );
			
			
			//guardar cookie
			Cookie cIdioma = new Cookie("cIdioma", idiomaSeleccionado);
			cIdioma.setMaxAge(60*10); //TODO que no expire
			response.addCookie(cIdioma);
			
			for (Usuario u : usuariosRegistrados) {
				if(u.getUsuario().equals(usuario)) {
					if(u.getPassword().equals(password)) {
						usuarioLogeado = u;
						
						
						//Asocioamos un listener para listar usuarios conectados @see UsuarioListener
						session.setMaxInactiveInterval(60 * 5); // 5minutos
						session.setAttribute("usuarioLogeado", usuarioLogeado);
						
						
							//Selecciona el idioma de la app web
							session.setAttribute("language", idiomaSeleccionado);
					
						
						vista= CONTROLER_CREARPAGINA;
						return;
						
					}
				}
			} 
			
			if(usuarioLogeado == null) {
				request.setAttribute("alerta", messages.getString("login.incorrecto"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			LOG.debug("Error",e);
		} finally {
			if (vista.equals(CONTROLER_CREARPAGINA)) {
				response.sendRedirect(CONTROLER_CREARPAGINA);
			} else {
				request.getRequestDispatcher(vista).forward(request, response);
			}

		}
		
	}

}
