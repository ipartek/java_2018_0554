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
import java.sql.PreparedStatement;

import org.junit.Test;

import com.ipartek.formacion.ejemplocapas.pojos.Usuario;

import com.mysql.jdbc.Statement;

public class TestConexionBaseDatos {
	
	@Test
	
	public void testConexion() {
			
		
		try {//comprobar el driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();		
			
			
		} catch (Exception e) {
			fail("No existe driver, meter dependencia en pom.xml");
		}
		
		try {
			//conexion a la bbdd
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.44/youtube?useSSL=false","viernes","juernes");
			assertNotNull(conn);
			
			//Consulta
			
			String sql = "SELECT id, nombre, password FROM usuario ORDER BY id DESC LIMIT 500";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			
			//iteracion sobre el bucle de resultados
			while (rs.next()) {
				int id =rs.getInt("id");
				String nombre = rs.getString("nombre");
				String password = rs.getString("password");
				
				System.out.println(id + " " + nombre + " " + password);
			}
			
//			Statement s = (Statement) conn.createStatement();
//			ResultSet rs = s.executeQuery("SELECT * FROM usuario");
			
			
			
		}catch(SQLException e){
			fail("no se pudo establecer conexion");
		}
		
	}
	
	

	@Test
	public void testTonto() {
		assertTrue ("mensaje personalizado",2==2);
		assertFalse (false);
		assertEquals("manolo","manolo");
		
		String email = "javier@lete.com";
		String pass = "Pa$$w0rd";
		
		Usuario u = new Usuario ((long)-1,email,pass);
		
		assertNotNull(u);
		assertEquals(email, u.getEmail());
		assertEquals(pass, u.getPassword());
		
		try {
			u = new Usuario((long)-1, "noEmail", pass);
			fail("deberia haber lanzado una Excepcion");
			
			
		} catch (Exception e) {
			assertEquals(e.getMessage(), "El formato del email no es correcto");
		}
		
	}

}
