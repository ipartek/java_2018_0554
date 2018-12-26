package com.ipartek.formacion.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class Applistener implements ServletContextListener {


    public void contextDestroyed(ServletContextEvent sce)  { 
        System.out.println("Desctruye");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("Arranca");
    }
	
}
