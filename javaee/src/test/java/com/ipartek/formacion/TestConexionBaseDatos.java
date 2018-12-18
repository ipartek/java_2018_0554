package com.ipartek.formacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.ipartek.formacion.modelo.pojos.Usuario;


public class TestConexionBaseDatos {
	
	@Test
	public void testConexion() {
		assertTrue(true);
		try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e) {
			fail("No existe driver, meter dependencia en pom.xml");
		}
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.44/youtube?useSSL=false",
                    "viernes","juernes");
			assertNotNull(conn);
			
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery("SELECT id, nombre, password from usuario order by id desc limit 500");
//			
			String sql = "SELECT id, nombre, password from usuario order by id desc limit 500";
			PreparedStatement pst = conn.prepareStatement(sql);
			 
			 ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
//				System.out.println(rs.getInt(1)+ "" +rs.getString(2)+ "" + rs.getString(3));
				
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String password = rs.getString("password");
				
				System.out.println(id + "" + nombre + "" + password);
				}
			
			rs.close();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			fail("No se pudo establecer conexion");
		}
	}

	@Test
	public void testTonto() {
		assertTrue(true);
		assertFalse(false);
		assertEquals("Manolo", "Manolo");
		
		String email = "ander@ipartek.com";
		String pass = "Pa$$w0rd";
		
		Usuario u = new Usuario((long)-1, email, pass);
		
		assertNotNull(u);
		assertEquals(email, u.getEmail());
		assertEquals(pass, u.getPassword());
		
		
		try {
		 u = new Usuario((long)-1, "noEmail", pass);
		 fail("Deberia haber lanzado Exception");
		}catch(Exception e) {
			assertEquals(e.getMessage(), "El formato del email no es correcto");
		}
	}

}
