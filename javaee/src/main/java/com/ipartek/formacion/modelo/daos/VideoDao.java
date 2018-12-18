package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojos.Video;

public class VideoDao {

	public ArrayList<Video> listarVideos() {
		ArrayList<Video> listadoVideos = new ArrayList<Video>();
		Video video = null;
		String sql = "SELECT id, nombre, url FROM imanol ORDER BY id DESC LIMIT 500";
		try (
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			){
				try ( ResultSet rs = pst.executeQuery() ){											
					while(rs.next()) { // hemos encontrado usuario								
						video = new Video();
						video.setId( rs.getLong("id"));
						video.setNombre( rs.getString("nombre"));
						video.setUrl(rs.getString("url"));	
						listadoVideos.add(video);
					}				
			}	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listadoVideos;
	}
	
	
	
	
	public ArrayList<Video> listarVideosBuscados(String texto1) {
		String texto = texto1;
		ArrayList<Video> listadoVideosBuscados = new ArrayList<Video>();
		Video video = null;
		String sql = "SELECT  nombre, url FROM imanol WHERE nombre LIKE ? ORDER BY nombre ASC LIMIT 500";
		try (
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			){
				pst.setString(1, "%"+texto+"%");
				try ( ResultSet rs = pst.executeQuery() ){											
					while(rs.next()) { 							
						video = new Video();
						video.setNombre( rs.getString("nombre"));
						video.setUrl(rs.getString("url"));	
						listadoVideosBuscados.add(video);
					}						
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listadoVideosBuscados;
	}
	
}
