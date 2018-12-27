package com.ipartek.formacion.libroCompartido.listeners;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.ipartek.formacion.libroCompartido.modelo.pojo.Usuario;

/**
 * Application Lifecycle Listener implementation class UsuarioListener
 *
 */
@WebListener
public class UsuarioListener implements HttpSessionAttributeListener {
	public static HashMap<String, Usuario> usuariosLogueados = new HashMap<String, Usuario>();
	
	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
      
       System.out.println("Atributo añadido");
       
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
    	 System.out.println("attributeRemoved");
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
    	 System.out.println("attributeReplaced");
    }
	
}
