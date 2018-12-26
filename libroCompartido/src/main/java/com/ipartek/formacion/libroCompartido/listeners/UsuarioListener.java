package com.ipartek.formacion.libroCompartido.listeners;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.ipartek.formacion.libroCompartido.modelo.pojo.Usuario;

/**
 * Application Lifecycle Listener implementation class UsuarioListener
 *
 */
@WebListener
public class UsuarioListener implements HttpSessionAttributeListener {
	//public static HashMap<String, Usuario> usuariosLogeados = new HashMap<String,Usuario>();
	public static ArrayList<Usuario> usuariosLogeados = new ArrayList<Usuario>();
	
	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
       System.out.println("attributeAdded");
       
       //Obtengo el usuario de la session
       Usuario u= (Usuario) event.getSession().getAttribute("usuarioLogeado");
       
       //Añado el usuario al array de los usuarioLogeados
       usuariosLogeados.add(u);
       
       
       ServletContext appContext = event.getSession().getServletContext();
       appContext.setAttribute("usuariosLogeados", usuariosLogeados);
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	 System.out.println("attributeRemoved");
    	
		if(event.getName().equals("usuarioLogeado")) {
			usuariosLogeados.remove((Usuario) event.getValue());
		}
         
	  ServletContext appContext = event.getSession().getServletContext();
      appContext.setAttribute("usuariosLogeados", usuariosLogeados);
        
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	 System.out.println("attributeReplaced");
    }
	
}
