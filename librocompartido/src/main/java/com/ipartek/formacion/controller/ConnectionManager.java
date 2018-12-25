package com.ipartek.formacion.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

	private static Connection conn;
	
	public static String[] getDatos(){
		String datos[] = new String[3];
		if (System.getProperty("user.name").equals("Pankorbo")) {
			datos[0] = "jdbc:mysql://localhost/youtube?useSSL=false";
			datos[1] = "root";
			datos[2] = "";
		}
		else {
			datos[0] = "jdbc:mysql://192.168.0.44/youtube?useSSL=false";
			datos[1] = "viernes";
			datos[2] = "juernes";	
		}
		return datos;
	}
	public static Connection getConnection() {

		conn = null;
		String datos[] = getDatos();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(datos[0], datos[1], datos[2]);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return conn;

	}

}