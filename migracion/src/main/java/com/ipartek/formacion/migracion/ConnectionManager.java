package com.ipartek.formacion.migracion;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;




public class ConnectionManager {


	private static Connection conn;
	

	public static Connection getConnection() {

		conn = null;
		try {
			//cargar properties
			Properties prop = new Properties();
			
			InputStream input = ConnectionManager.class.getClassLoader().getResourceAsStream("database.properties");	
			prop.load(input);
	
			
			//comprobar que exista .jar para mysql
			Class.forName(prop.getProperty("ddbb.driver")).newInstance();
	
	
			//crear conexion
			conn = DriverManager.getConnection(
								prop.getProperty("ddbb.url"), 
								prop.getProperty("ddbb.user"),
								prop.getProperty("ddbb.pass"));
			
			
			// No automitar por defecto
			conn.setAutoCommit(false);
			
			

		}catch (Exception e) {
			
			e.printStackTrace();
			
		}	
		return conn;

	}
}
