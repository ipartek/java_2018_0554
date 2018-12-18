package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojos.Video;

public class VideosDAO {
	
public ArrayList<Video> getAllByNombre(String nombre) {
		
		ArrayList<Video> listado = new ArrayList<Video>();
		String sql = "SELECT id, nombre, url FROM mikel_videos WHERE nombre like ? order by id desc limit 500";		
		
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(sql);
			  
			){
			pst.setString(1, "%" + nombre + "%");
			
			try(ResultSet rs = pst.executeQuery() ){
				
			
			Video v = null;
			while(rs.next()) { 			
				try {
					v = new Video();
					v.setId( rs.getLong("id"));
					v.setNombre( rs.getString("nombre"));
					v.setUrl(rs.getString("url"));
					// añadir en array
					listado.add(v);
				}catch (Exception e) {
					System.out.println("usuario no valido");
					e.printStackTrace();
				}		
			} // while	
			}catch(Exception e) {
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return listado;
	}
	
public ArrayList<Video> getAll() {
		
		ArrayList<Video> listado = new ArrayList<Video>();
		String sql = "SELECT id, nombre, url FROM mikel_videos ORDER BY id DESC LIMIT 500";		
		
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(sql);
			  ResultSet rs = pst.executeQuery() 
			){
			Video v = null;
			while(rs.next()) { 			
				try {
					v = new Video();
					v.setId( rs.getLong("id"));
					v.setNombre( rs.getString("nombre"));
					v.setUrl(rs.getString("url"));
					// añadir en array
					listado.add(v);
				}catch (Exception e) {
					System.out.println("usuario no valido");
					e.printStackTrace();
				}		
			} // while	
			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return listado;
	}
}
