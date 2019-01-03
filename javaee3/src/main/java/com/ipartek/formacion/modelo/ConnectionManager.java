package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

	private static Connection conn;
	private static final String URL = "jdbc:mysql://127.0.0.1/javaee?useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "root";

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