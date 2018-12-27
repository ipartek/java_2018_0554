package com.ipartek.formacion.listener;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.LoginController;
import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Application Lifecycle Listener implementation class UsuariosListener
 *
 */
@WebListener
public class UsuariosListener implements HttpSessionAttributeListener {
	private final static Logger LOG = Logger.getLogger(UsuariosListener.class);
	public static HashMap<String, Usuario> usuariosLogueados = new HashMap<String, Usuario>();

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
         LOG.trace("Atributo añadido");
         
         if (event.getName().equals("usuario_logueado")) {
        	 Usuario usuario = (Usuario) event.getValue();
			usuariosLogueados.put(usuario.getEmail(), usuario);
		}
         
         ServletContext appContext = event.getSession().getServletContext();
         appContext.setAttribute("usuarios_logueados", usuariosLogueados);
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	LOG.trace("Atributo eliminado");
         if (event.getName().equals("usuario_logueado")) {
        	Usuario usuario = (Usuario) event.getValue();
			usuariosLogueados.remove(usuario.getEmail());
		}
         
         ServletContext appContext = event.getSession().getServletContext();
         appContext.setAttribute("usuarios_logueados", usuariosLogueados);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	LOG.trace("Atributo reemplazado");
    }
	
}
