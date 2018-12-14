package com.ipartek.formacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import com.ipartek.formacion.ejemplocapas.pojos.Usuario;

public class TestConexionBaseDatos {
	
	
	@Test
	public void testConexion() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			
			

			
		}catch (Exception e) {
			fail("No existe driver, meter depencia en pom.xml");
		}	
		
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.44/youtube?useSSL=false", "viernes","juernes");
			assertNotNull(conn);
			
		}catch (Exception e) {
			fail("no se pudo establecer conexion " + e.getMessage());
		}
		
		
		
		
		
	}

	@Test
	public void testTonto() {
		
		
		assertTrue( 2 == 2 );
		assertFalse(false);
		assertEquals("manolo", "manolo");
		
		String email = "ander@ipartek.com";
		String pass = "Pa$$w0rd";
		
		Usuario u = new Usuario((long)-1, email, pass);
		
		assertNotNull(u);
		assertEquals(email, u.getEmail());
		assertEquals(pass, u.getPassword());
		
		try {
			u = new Usuario((long)-1, "noEmail", pass);
			fail("deeberia haber lanzado Exception");
			
			
		}catch (Exception e) {
			
			assertEquals(e.getMessage(), "El formato del email no es correcto");
			
		}	
		
	}

}
