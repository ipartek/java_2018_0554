package com.ipartek.formacion.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;


@WebListener
public class UsuariosListener implements HttpSessionAttributeListener {

    public void attributeAdded(HttpSessionBindingEvent event)  { 
         System.out.println("añadido");
    }


    public void attributeRemoved(HttpSessionBindingEvent event)  { 
      System.out.println("removido");
    }


    public void attributeReplaced(HttpSessionBindingEvent event)  { 
       System.out.println("reemplazado");
    }
	
}
