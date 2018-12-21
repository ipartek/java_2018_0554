package com.ipartek.formacion.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojo.Perro;


public class PerrosDao {

	public Perro getById( long id ) {
			
			Perro registro = null;
			String sql = "SELECT id, nombre, raza FROM endika_perros WHERE id= ?;";		
			try ( Connection conn = ConnectionManager.getConnection();
				  PreparedStatement pst = conn.prepareStatement(sql);
				){
				
				pst.setLong(1, id);
				
				try( ResultSet rs = pst.executeQuery() ){
					
					while(rs.next()) { 		
						registro = new Perro();
						registro.setId( rs.getLong("id"));
						registro.setNombre( rs.getString("nombre"));
						registro.setRaza(rs.getString("raza"));		
					}
				}
				
					
			} catch (Exception e) {
				e.printStackTrace();
			}	
			
			
			return registro;
	}

	
	public ArrayList<Perro> getAll() {
		ArrayList <Perro> perros = new ArrayList <Perro>();
		
		String sql = "SELECT id, nombre, url FROM endika_video ORDER BY id DESC LIMIT 500";
		try(Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {
			
			Perro perro = null;
			while(rs.next()) {
				try {
				perro = new Perro();
				perro.setId(rs.getLong("id"));
				perro.setNombre(rs.getString("nombre"));
				perro.setRaza(rs.getString("raza"));
				//a�adimos en array
				perros.add(perro);
				}catch(Exception e) {
					perros.toString();
					System.out.println("video no valido");
					e.printStackTrace();
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return perros;
	}



}
