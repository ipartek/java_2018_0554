package com.ipartek.formacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.ipartek.formacion.modelo.pojos.Usuario;

import java.sql.PreparedStatement;
import java.sql.Statement;

public class TestConexionBaseDatos {

	/**
	 * Metodo que hace la conexión a la base de datos y una consulta
	 */
	@Test
	public void textConexion() {
		Connection conn = null;
		try {
			// Comprueba el drive o la libreria, si existe en el proyecto
			Class.forName("com.mysql.jdbc.Driver").newInstance();

		} catch (Exception e) {

			fail("No existe driver, meter dependencia ne pom.xml");
		}
		try {
			// Crea la conexion
			conn = DriverManager.getConnection("jdbc:mysql://192.168.0.44/youtube?useSSL=false", "viernes", "juernes");
			assertNotNull(conn);

			String sql = "select id,nombre,password from usuario order by id desc limit 500";
			PreparedStatement pst = conn.prepareStatement(sql);
			// resultado de una setencia query es resulset --> rs
			ResultSet rs = pst.executeQuery();
			//un bucle que va mostrando cada resultado uno a uno hasta que rs.next() no tenga mas resultados
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String password = rs.getString("password");
				System.out.println(id +" " + nombre + " " + password);

			}
			//1º cerrar el rs 2º el pst 3º el conn
			rs.close();
			pst.close();
			conn.close();

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}

	@Test
	public void testTonto() {
		// fail("Not yet implemented");
		assertTrue(true);

		assertFalse(false);

		assertEquals("manolo", "manolo");

		String email = "danielzallo@gmail.com";
		String password = "Pa$$w0rd";

		Usuario user = new Usuario(1L, email, password);
		// Pues ponerle un mensaje personalizado mediante la sobreescritura
		assertNotNull(user);
		assertEquals(email, user.getEmail());
		assertEquals(password, user.getPassword());

		try {
			user = new Usuario((long) -1, "noEmail", password);
			fail("Deberia haber lanzado EXCEPTION");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "El formato del email no es correcto");
		}

	}

}
