package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojos.Videos;

import ENDESHUSOcom.ipartek.formacion.ejemplocapas.pojos.Usuario;

public class VideoDAO {
	
	/**
	 * comprobar si existe el usuario en la bbdd
	 * @param email String 
	 * @param pass String contraseña
	 * @return usuario con datos si existe, null si no existe
	 */
	
public Videos getById( long id ) {
		
		Videos registro = null;
		String sql = "SELECT id, nombre, url FROM oscar WHERE id= ?;";		
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(sql);
			){
			
			pst.setLong(1, id);
			
			try( ResultSet rs = pst.executeQuery() ){
				
				while(rs.next()) { 		
					registro = new Videos();
					registro.setId( rs.getLong("id"));
					registro.setTitulo( rs.getString("nombre"));
					registro.setUrl(rs.getString("url"));		
				}
			}
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		
		return registro;
	}
	
	public ArrayList <Videos>getAll(){
		ArrayList<Videos> listado = new ArrayList<Videos>();
		String sql = "SELECT id, nombre, url FROM oscar ORDER BY id DESC LIMIT 500;";		
		
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(sql);
			  ResultSet rs = pst.executeQuery() 
			){
			Videos v = null;
			while(rs.next()) { 			
				try {
					v = new Videos();
					v.setId( rs.getLong("id"));
					v.setTitulo( rs.getString("nombre"));
					v.setUrl(rs.getString("url"));					
					listado.add(v);
				}catch (Exception e) {					
					e.printStackTrace();
				}		
			} // while	
			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return listado;
	}
	
	
public ArrayList<Videos> getAllByNombre( String nombre ) {
		
		ArrayList<Videos> listado = new ArrayList<Videos>();
		String sql = "SELECT id, nombre, url FROM oscar WHERE NOMBRE LIKE ? ORDER BY id DESC LIMIT 500;";		
		
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(sql);
			
			){
			
			pst.setString(1, "%" + nombre + "%");	
			
			try( ResultSet rs = pst.executeQuery() ){
			
				Videos v = null;
				while(rs.next()) { 			
					try {
						v = new Videos();
						v.setId( rs.getLong("id"));
						v.setTitulo( rs.getString("nombre"));
						v.setUrl(rs.getString("url"));					
						listado.add(v);
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
