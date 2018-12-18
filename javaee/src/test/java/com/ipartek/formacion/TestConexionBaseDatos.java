package com.ipartek.formacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import org.junit.Test;

import ENDESHUSOcom.ipartek.formacion.ejemplocapas.pojos.Usuario;

//CLASE CONEXION A BBDD

public class TestConexionBaseDatos {
	@Test
	public void testConexion() {
		assertTrue(2 == 2);

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("No existe driver, meter dependencia en pol.xml");
		}

		try { // conectamos a la BBDD
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://192.168.0.44/youtube?useSSL=false" + "user=viernes&password=juernes");

			assertNotNull(conn);

			// CONSULTA
			String sql = "SELECT id, nombre, password FROM usuario WHERE nombre ='xabier@ipartek.com' AND password='Pa$$w0rd'";

			PreparedStatement pst = conn.prepareStatement(sql); //

			ResultSet rs = pst.executeQuery();

			// SI ENCUENTRA VALORES Y LA SENTENCIA AVANZA...
			while (rs.next()) {

				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String password = rs.getString("password");

				System.out.println(id + " " + nombre + " " + password);
			}

//	Statement stmt = (Statement) conn.createStatement();

			String lastName = rs.getString("Lname");
			System.out.println(lastName);

			rs.close();
			pst.close();
			conn.close();

		} catch (SQLException e) {
			fail("no se pudo establecer conexion");
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void testTonto() {

		assertTrue(2 == 2);
		assertFalse(false);
		assertEquals("manolo", "manolo");

		String email = "ander@ipartek.com";
		String pass = "Pa$$w0rd";

		Usuario u = new Usuario((long) -1, email, pass);

		assertNotNull(u);
		assertEquals(email, u.getEmail());
		assertEquals(pass, u.getPassword());

		try {
			u = new Usuario((long) -1, "noEmail", pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals(e.getMessage(), "El formato del email no es correcto");
		}

	}

}
