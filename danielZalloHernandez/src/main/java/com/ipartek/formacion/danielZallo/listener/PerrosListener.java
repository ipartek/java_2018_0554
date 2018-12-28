package com.ipartek.formacion.danielZallo.listener;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.ipartek.formacion.danielZallo.modelo.pojo.Chip;
import com.ipartek.formacion.danielZallo.modelo.pojo.Perro;

/**
 * Application Lifecycle Listener implementation class PerrosListener
 *
 */
@WebListener
public class PerrosListener implements HttpSessionAttributeListener {
	public static HashMap<Long, Perro> perros = new HashMap<Long, Perro>();

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		perros.put(1L, new Perro(1L, "Lau", 12L, "Shi tzu", (double) 10, "Si", new Chip("11-1111-2005", "10", "10")));
		perros.put(2L, new Perro(2L, "Luna", 2L, "Husky Siberiano", (double)25, "No", new Chip("11-1111-2016", "10", "10")));

    	
    	ServletContext appContext = event.getSession().getServletContext();
         appContext.setAttribute("perros", perros);
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}
