package com.ipartek.formacion;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class TestConexionBaseDatos {

	@Test
	public void testConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

		} catch (Exception e) {
			fail("No existe driver, meter dependencia en pom.xml");
		}

		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.0.44/youtube?useSSL=false", "viernes", "juernes");
			assertNotNull(conn);

			Statement stmt = conn.createStatement();
//			Seleccionar información
			String busqueda = "SELECT id, nombre, password FROM usuario";
			ResultSet rs = stmt.executeQuery(busqueda);
//			ResultSet rs = stmt.executeQuery(busqueda+" WHERE nombre='' AND password=''");
			while (rs.next()) {
				int id = rs.getInt("id");
				String email = rs.getString("nombre");
				String password = rs.getString("password");
				System.out.println(id + " | " + email + " | " + password);
			}
//			Cerrar ResultSet
//			Cerrar Statement 
//			Cerrar Conexión
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			fail("No se pudo establecer conexión");
		}

	}
}