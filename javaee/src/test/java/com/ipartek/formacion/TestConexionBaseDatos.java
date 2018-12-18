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

import org.junit.Test;

import com.ipartek.formacion.modelo.pojos.Usuario;


public class TestConexionBaseDatos {
	
	@Test
	public void testConexion() {
		 try {
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
			 
		 }catch (Exception e) {
			fail("No existe driver, meter dependencia en pom.xml");
		}
		 
		 try {
			 Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.44/youtube?&useSSL=false", "viernes", "juernes");
			 assertNotNull(conn);

			  // CONSULTA SQL
		      String query = "SELECT id, nombre, password FROM usuario order by id desc limit 500;";
		      //STATEMENT
		      PreparedStatement pst = conn.prepareStatement(query);
		      //EJECUTAR QUERY
		      ResultSet rs = pst.executeQuery(query);
		      //OBTENER RESULTADOS
		      while (rs.next())
		      {
		    	  int id = rs.getInt("id");
		    	  String nombre = rs.getString("nombre");
		    	  String password = rs.getString("password");
		        //IMPRIMIR RESULTADOS
		        System.out.println(id + " - " + nombre + " - " + password);
		      }
		      rs.close();
		      pst.close();
		      conn.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("No se pudo establecer la conexión ");
		      System.err.println(e.getMessage());
		    }
	}

	@Test
	public void testTonto() {
		assertTrue("Mensaje personalizado", 2 == 2);
		assertFalse(false);
		assertEquals("manolo", "manolo");
		
		String email ="ander@ipartek.com";
		String pass = "Pa$$w0rd";
		String gitHub = "anderHub";
		
		Usuario u = new Usuario(4L, email, pass, gitHub);
		
		assertNotNull(u);
		assertEquals(email, u.getEmail());
		assertEquals(pass, u.getPassword());
		
		try {
			u = new Usuario((long)-1, "noEmail", pass, "noGitHub");
			fail("Debería haber lanzado Excepcion");
			
		}catch (Exception e) {
			
			assertEquals(e.getMessage(), "El formato del email no es correcto");

		}
	}

}

