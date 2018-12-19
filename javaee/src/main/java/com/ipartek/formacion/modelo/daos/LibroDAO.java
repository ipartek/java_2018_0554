package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojos.Libro;

public class LibroDAO {
	
	

	public ArrayList<Libro> getAll() {
		
		ArrayList<Libro> listado = new ArrayList<Libro>();
		String sql = "SELECT id, nombre, url FROM oscar ORDER BY id DESC LIMIT 500;";		
		
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(sql);
			  ResultSet rs = pst.executeQuery() 
			){
			Libro l = null;
			while(rs.next()) { 			
				try {
					l = new Libro();
					l.setId( rs.getLong("id"));
					l.setNombre( rs.getString("nombre"));
					l.setAutor( rs.getString("autor"));
					l.setImagen(rs.getString("imagen"));					
					listado.add(l);
				}catch (Exception e) {					
					e.printStackTrace();
				}		
			} // while	
			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return listado;
	}
	
	
	public ArrayList<Libro> getAllByNombre( String nombre ) {
		
		ArrayList<Libro> listado = new ArrayList<Libro>();
		String sql = "SELECT id, nombre, url FROM oscar WHERE NOMBRE LIKE ? ORDER BY id DESC LIMIT 500;";		
		
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(sql);
			
			){
			
			pst.setString(1, "%" + nombre + "%");	
			
			try( ResultSet rs = pst.executeQuery() ){
			
				Libro l = null;
				while(rs.next()) { 			
					try {
						l = new Libro();
						l.setId( rs.getLong("id"));
						l.setNombre( rs.getString("nombre"));
						l.setAutor( rs.getString("autor"));
						l.setImagen(rs.getString("imagen"));					
						listado.add(l);
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