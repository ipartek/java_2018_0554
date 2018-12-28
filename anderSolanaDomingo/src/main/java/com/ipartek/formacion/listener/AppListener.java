package com.ipartek.formacion.listener;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.ipartek.formacion.modelo.pojo.Chip;
import com.ipartek.formacion.modelo.pojo.Perro;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	ArrayList<Perro> perros = new ArrayList<Perro>();
    	perros.add(new Perro("Rex", 6, "Pastor Alemán", 20.5, true, new Chip(1L, "43.2641428", "-2.929876")));
    	perros.add(new Perro("Tommy", 2, "Bulldog", 11.7, true, new Chip(2L, "43.2612345", "-2.926789")));
    	perros.add(new Perro("Alexa", 14, "Dogo", 23.2, false, new Chip(3L, "43.2654321", "-2.926809")));
    	perros.add(new Perro("Siri", 4, "Pitbull", 18.0, false, new Chip(4L, "43.2613542", "-2.920769")));
    	perros.add(new Perro("Blacky", 21, "Yorsay", 7.1, true, new Chip(5L, "43.2642315", "-2.923691")));
    	
		ServletContext appContext = sce.getServletContext();
		appContext.setAttribute("perros", perros);
    }
	
}
