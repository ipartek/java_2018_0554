package com.ipartek.formacion.libroCompartido.listeners;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.log4j.Logger;

import com.ipartek.formacion.libroCompartido.modelo.pojo.Usuario;

/**
 * Application Lifecycle Listener implementation class UsuarioListener
 *
 */
@WebListener
public class UsuarioListener implements HttpSessionAttributeListener {
	public static HashMap<String, Usuario> usuariosLogueados = new HashMap<String, Usuario>();
	private final static Logger LOG = Logger.getLogger(UsuarioListener.class);
	
	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	LOG.trace("Atributo añadido");
    	
       
       if (event.getName().equals("usuarioLogeado")) {
      	 Usuario usuario = (Usuario) event.getValue();
			usuariosLogueados.put(usuario.getUsuario(), usuario);
		}
       
       ServletContext appContext = event.getSession().getServletContext();
       appContext.setAttribute("usuarios_logueados", usuariosLogueados);
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	LOG.trace("attributeRemoved");
    	
         if (event.getName().equals("usuarioLogeado")) {
        	 Usuario usuario = (Usuario) event.getValue();
			usuariosLogueados.remove(usuario.getUsuario());
		}
         
         ServletContext appContext = event.getSession().getServletContext();
         appContext.setAttribute("usuarios_logueados", usuariosLogueados);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	LOG.trace("attributeReplaced");
    	
    }
	
}
