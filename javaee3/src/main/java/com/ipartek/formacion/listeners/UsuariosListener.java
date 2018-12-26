package com.ipartek.formacion.listeners;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.ipartek.formacion.modelo.pojos.Usuario;

/**
 * Application Lifecycle Listener implementation class UsuariosListener
 *
 */
@WebListener
public class UsuariosListener implements HttpSessionAttributeListener {
	// public static HashMap<String, Usuario> usuariosLogeados
	public static ArrayList<Usuario> usuariosLogeados = new ArrayList<Usuario>();

	public void attributeAdded(HttpSessionBindingEvent event) {
		// System.out.println("attributeAdded");

		System.out.println("attributeAdded");

		if ("usuario".equals(event.getName())) {

			usuariosLogeados.add((Usuario) event.getValue());

			ServletContext appContext = event.getSession().getServletContext();
			appContext.setAttribute("usuariosLogeados", usuariosLogeados);
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		if ("usuario".equals(event.getName())) {

			usuariosLogeados.remove((Usuario) event.getValue());

			ServletContext appContext = event.getSession().getServletContext();
			appContext.setAttribute("usuariosLogeados", usuariosLogeados);
		}
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("attributeReplaced");
	}

}
