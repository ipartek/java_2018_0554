package com.ipartek.formacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.junit.Test;

import com.ipartek.formacion.modelos.pojos.Usuario;

import java.sql.PreparedStatement;
import java.sql.Statement;

public class TestConexionBaseDatos {


	public void test_tontako() {
		assertTrue(2 == 2);
		assertFalse(2 == 3);
		assertEquals("manolo","manolo");
		
		String email="hola@gaa.com";
		String pass="Pa$$w0rd";
	
		
		Usuario u;
		try {
			u = new Usuario(-1,email,pass);
			assertNotNull(u);
			assertEquals(email,u.getEmail());
			assertEquals(email,u.getPassword());
			fail("deberioa haber entrado a excepcion");
		} catch (Exception e) {
			assertEquals(e.getMessage(),"xfdfgdfgdfg");
		}
		
			
	}
	@Test
	public void test_conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			
		} catch (Exception e) {
			fail("No exiate controlador");

		}
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.44/youtube?user=viernes&password=juernes&useSSL=false");
			assertNotNull(conn);
			String consulta="select id, nombre, password from usuario";
			PreparedStatement pst = conn.prepareStatement(consulta); 
			ResultSet resultados = pst.executeQuery();
			while (resultados.next()) 
			{ 
			    System.out.println (resultados.getInt ("id") + " " + resultados.getString ("nombre")+ " " + resultados.getString ("password")+ " " + resultados.getInt("id_rol")); 
			}
			resultados.close();
			pst.close();
			conn.close();
		}catch (Exception e) {
			fail("sin conexion");
		}
	}

	public void listado() {
		
	}

}
