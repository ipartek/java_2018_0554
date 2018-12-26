package com.ipartek.formacion.listeners;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.ipartek.formacion.modelo.pojos.Usuario;
@WebListener
public class UsuariosListener implements HttpSessionAttributeListener {
	public static ArrayList<Usuario> usuariosLogueados = new ArrayList<Usuario>();

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("attributeAdded");

		if ("logueado".equals(event.getName())) {

			usuariosLogueados.add((Usuario) event.getValue());

			ServletContext appContext = event.getSession().getServletContext();
			appContext.setAttribute("usuariosLogueados", usuariosLogueados);
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent event) {
		if ("usuario".equals(event.getName())) {

			usuariosLogueados.remove((Usuario) event.getValue());

			ServletContext appContext = event.getSession().getServletContext();
			appContext.setAttribute("usuariosLogueados", usuariosLogueados);
		}
	}
	public void attributeReplaced(HttpSessionBindingEvent event) {

	}

}