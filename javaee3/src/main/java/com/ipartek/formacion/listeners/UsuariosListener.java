package com.ipartek.formacion.listeners;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.ipartek.formacion.modelos.pojos.Usuario;

@WebListener
public class UsuariosListener implements HttpSessionAttributeListener {

	// public static HashMap<String, Usuario> usuariosLogeados = new HashMap<String,
	// Usuario>();
	public static ArrayList<Usuario> usuariosLogeados = new ArrayList<Usuario>();

	public void attributeAdded(HttpSessionBindingEvent event) {

		ServletContext appContext = (ServletContext) event.getSession().getServletContext();

		
		usuariosLogeados.add((Usuario) event.getValue());

		appContext.setAttribute("usuariosLogeados", usuariosLogeados);

	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		//quitar de la lista
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		// hacer logout y volver a cargar usuario
	}

}