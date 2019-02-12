package com.ipartek.formacion.modelo.config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;


public class ConnectionManager {

	private final static Logger LOG = Logger.getLogger(ConnectionManager.class);
	private static Connection conn;
	

	public static Connection getConnection() {

		conn = null;
		try {
			//cargar properties
			Properties prop = new Properties();
			
			InputStream input = ConnectionManager.class.getClassLoader().getResourceAsStream("database.properties");	
			prop.load(input);
			LOG.debug("cargado fichero properties");
			
			//comprobar que exista .jar para mysql
			Class.forName(prop.getProperty("ddbb.driver")).newInstance();
			LOG.debug("Existe driver mysql");
	
			//crear conexion
			conn = DriverManager.getConnection(
								prop.getProperty("ddbb.url"), 
								prop.getProperty("ddbb.user"),
								prop.getProperty("ddbb.pass"));
			
			conn.setAutoCommit(false);
			
			LOG.info("conexion establecida");

		}catch (Exception e) {
			
			LOG.fatal("Error estableciendo conexion base datos" , e);
			
		}	
		return conn;

	}
}
