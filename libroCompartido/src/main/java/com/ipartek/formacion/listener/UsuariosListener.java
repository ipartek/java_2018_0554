package com.ipartek.formacion.listener;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Application Lifecycle Listener implementation class UsuariosListener
 *
 */
@WebListener
public class UsuariosListener implements HttpSessionAttributeListener {
	
	//public static HashMap<String, Usuario> usuariosLogueados = new HashMap<String, Usuario>();
	public static ArrayList<Usuario> usuariosLogueados = new ArrayList<Usuario>();

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
         System.out.println("Atributo añadido");
         
         if (event.getName().equals("usuario_logueado")) {
			usuariosLogueados.add((Usuario) event.getValue());
		}
         
         ServletContext appContext = event.getSession().getServletContext();
         appContext.setAttribute("usuarios_logueados", usuariosLogueados);
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
         if (event.getName().equals("usuario_logueado")) {
			usuariosLogueados.remove((Usuario) event.getValue());
		}
         
         ServletContext appContext = event.getSession().getServletContext();
         appContext.setAttribute("usuarios_logueados", usuariosLogueados);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	System.out.println("Atributo reemplazado");
    }
	
}
