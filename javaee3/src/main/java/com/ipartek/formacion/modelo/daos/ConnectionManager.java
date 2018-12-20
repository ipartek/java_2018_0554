package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

	private static Connection conn;
	// CONEXION IPARTEK
	private static final String URL = "jdbc:mysql://192.168.0.44/youtube?useSSL=false";
	private static final String USER = "viernes";
	private static final String PASS = "juernes";
	
	// CONEXION CASA
//	private static final String URL = "jdbc:mysql://localhost:3306/youtube?useSSL=false";	
//	private static final String USER = "root";
//	private static final String PASS = "";

	public static Connection getConnection() {

		conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection( URL , USER, PASS);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return conn;

	}
	
}
