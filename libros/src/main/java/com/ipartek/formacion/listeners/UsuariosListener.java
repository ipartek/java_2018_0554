package com.ipartek.formacion.listeners;

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

	//public static HashMap<String, Usuario> usuariosLogeados = new  HashMap<String, Usuario>(); 
	public static ArrayList<Usuario> usuariosLogeados = new ArrayList<Usuario>();
	
   
	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
        System.out.println("attributeAdded");
        if ("usuario".equals(event.getName())) {
        	usuariosLogeados.add((Usuario)event.getValue());
        	 ServletContext appContext = event.getSession().getServletContext();        
             appContext.setAttribute("usuariosLogeados", usuariosLogeados);
        }
        
//        usuariosLogeados.add( new Usuario(1l, "manoli", "aasasasasas"));
//        usuariosLogeados.add( new Usuario(2l, "pepe", "aasasasasas"));
//        usuariosLogeados.add( new Usuario(3l, "federico", "aasasasasas"));
        
        
       
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	 if ("usuario".equals(event.getName())) {
    		 
         	usuariosLogeados.remove((Usuario)event.getValue());
         	
         	 ServletContext appContext = event.getSession().getServletContext();        
              appContext.setAttribute("usuariosLogeados", usuariosLogeados);
         }
    	System.out.println("attributeRemoved");
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	System.out.println("attributeReplaced");
    }
	
}
