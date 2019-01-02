package com.ipartek.formacion.listeners;



import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {
	private final static Logger LOG = Logger.getLogger(AppListener.class);
    

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	//System.out.println("Para o destruye la App");
    	LOG.trace("Para o destruye la App");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	//System.out.println("Arranca la App o el Contexto de Servlets");
    	LOG.trace("Arranca la App o el Contexto de Servlets");
    }
	
}
