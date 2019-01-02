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
			// cargar properties
			Properties prop = new Properties();

			InputStream input = ConnectionManager.class.getClassLoader().getResourceAsStream("database.properties");
			prop.load(input);
			LOG.debug("cargado fichero properties");
			// comprobar que exista .jar para mysql
			Class.forName(prop.getProperty("ddbb.driver")).newInstance();
			LOG.debug("Existe driver mysql");
			// crear conexion
			if (System.getProperty("user.name").equals("Pankorbo")) {
				// Equipo personal
				conn = DriverManager.getConnection(prop.getProperty("ddbb.pankorbo.url"),
						prop.getProperty("ddbb.pankorbo.user"), prop.getProperty("ddbb.pankorbo.pass"));
			} else {
				// Equipo en Ipartek
				conn = DriverManager.getConnection(prop.getProperty("ddbb.ipartek.url"),
						prop.getProperty("ddbb.ipartek.user"), prop.getProperty("ddbb.ipartek.pass"));
			}

			LOG.info("Conexión establecida");

		} catch (Exception e) {

			LOG.fatal("Error estableciendo conexión base datos", e);

		}
		return conn;

	}
}