package com.ipartek.formacion.listeners;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.ipartek.formacion.modelo.pojos.Usuario;

/**
 * Application Lifecycle Listener implementation class UsuariosListener
 *
 */
@WebListener
public class UsuariosListener implements HttpSessionAttributeListener {

	
	public static ArrayList<Usuario> usuariosLogueados=new ArrayList <Usuario>();
    /**
     * Default constructor. 
     */
    public UsuariosListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    //atributo añadido
    public void attributeAdded(HttpSessionBindingEvent event)  { 
        System.out.println("attributeAdded");
        
        usuariosLogueados.add(new Usuario(1l, "manolo","asfsdfsdf"));
        usuariosLogueados.add(new Usuario(2l, "pepa","afsdfsdf"));
        usuariosLogueados.add(new Usuario(3l, "fede","asdfsdf"));
        
        
        
       ServletContext appContext = event.getSession().getServletContext();
    
       appContext.setAttribute("usuariosLogueados", usuariosLogueados);
       
       
       //Estos usuarios 'usuariosLogueados' creados al pasar el evento tienen que mostrarse en el JSP. 
//       appContext.getRequestDispatcher("listadoUsuarios.jsp").forward(request, response);
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	  System.out.println("attributeRemoved");
    }
//atributo removido
	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	  System.out.println("attributeReplaced");
    }
	
}
