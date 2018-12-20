package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojos.Perro;



public class PerroDAO {
public ArrayList<Perro> getAll() {
		
		ArrayList<Perro> listado = new ArrayList<Perro>();
		String sql = "SELECT id, nombre, raza, chip FROM perros_oscar ORDER BY id DESC LIMIT 500;";		
		
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(sql);
			  ResultSet rs = pst.executeQuery() 
			){
			Perro p = null;
			while(rs.next()) { 			
				try {
					p = new Perro();
					p.setId( rs.getLong("id"));
					p.setNombre( rs.getString("nombre"));
					p.setRaza(rs.getString("raza"));	
					p.setChip(rs.getLong("chip"));
					listado.add(p);
				}catch (Exception e) {					
					e.printStackTrace();
				}		
			} // while	
			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return listado;
	}
	
	
	public ArrayList<Perro> getAllByNombre( String nombre ) {
		
		ArrayList<Perro> listado = new ArrayList<Perro>();
		String sql = "SELECT id, nombre, raza, chip FROM perros_oscar WHERE NOMBRE LIKE ? ORDER BY id DESC LIMIT 500;";		
		
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(sql);
			
			){
			
			pst.setString(1, "%" + nombre + "%");	
			
			try( ResultSet rs = pst.executeQuery() ){
			
				Perro p = null;
				while(rs.next()) { 			
					try {
						p = new Perro();
						p.setId( rs.getLong("id"));
						p.setNombre( rs.getString("nombre"));
						p.setChip(rs.getLong("chip"));					
						listado.add(p);
					}catch (Exception e) {						
						e.printStackTrace();
					}		
				} // while	
			}	
			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return listado;
	}
}
