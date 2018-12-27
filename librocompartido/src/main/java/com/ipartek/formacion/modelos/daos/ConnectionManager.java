package com.ipartek.formacion.modelos.daos;

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
			Properties prop = new Properties();
			InputStream input = ConnectionManager.class.getClassLoader().getResourceAsStream("database.properties");
			prop.load(input);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = (Connection) DriverManager.getConnection(prop.getProperty("ddbb.url"), prop.getProperty("ddbb.user"),
					prop.getProperty("ddbb.pass"));

		} catch (Exception e) {

			LOG.fatal("Error estableciendo conexion base datos", e);
		}

		return conn;

	}

}
