package com.ipartek.formacion.listeners;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.ipartek.formacion.modelo.pojos.Usuario;

@WebListener
public class UsuariosListener implements HttpSessionAttributeListener {

	public static ArrayList<Usuario> usuariosLogeados = new ArrayList<Usuario>();

	public void attributeAdded(HttpSessionBindingEvent event) {
		if ("usuario".equals(event.getName())) {
			usuariosLogeados.add((Usuario) event.getValue());
		}
		ServletContext appContext = event.getSession().getServletContext();
		appContext.setAttribute("usuariosLogeados", usuariosLogeados);
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("attributeRemoved");
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("attributeReplaced");
	}

}