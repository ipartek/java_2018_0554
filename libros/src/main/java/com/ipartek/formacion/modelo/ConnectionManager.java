package com.ipartek.formacion.modelo;

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
			
			LOG.info("conexion establecida");

		}catch (Exception e) {
			
			LOG.fatal("Erro estableciendo conexion base datos" , e);
			
		}	
		return conn;

	}
}


//package com.ipartek.formacion.modelo;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class ConnectionManager {
//
//	private static Connection conn;
//	private static final String URL = "jdbc:mysql://192.168.0.44/youtube?useSSL=false";
//	private static final String USER = "viernes";
//	private static final String PASS = "juernes";
//
//	public static Connection getConnection() {
//
//		conn = null;
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver").newInstance();
//			conn = DriverManager.getConnection( URL , USER, PASS);
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
//
//		return conn;
//
//	}
//	
//}
