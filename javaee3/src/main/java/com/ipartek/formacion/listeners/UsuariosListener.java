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
		//System.out.println("attributeAdded");

		usuariosLogeados.add(new Usuario(1l, "manoli", "aasasasasas"));
		usuariosLogeados.add(new Usuario(2l, "pepe", "aasasasasas"));
		usuariosLogeados.add(new Usuario(3l, "federico", "aasasasasas"));

		
		
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
