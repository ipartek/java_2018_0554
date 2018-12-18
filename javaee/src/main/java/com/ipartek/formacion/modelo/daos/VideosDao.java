package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojos.Usuario;
import com.ipartek.formacion.modelo.pojos.Video;

public class VideosDao {

	public ArrayList<Video> getAll() {
		ArrayList <Video> videos = new ArrayList <Video>();
		
		String sql = "SELECT id, nombre, url FROM endika_video ORDER BY id DESC LIMIT 500";
		try(Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {
			
			Video video = null;
			while(rs.next()) {
				try {
				video = new Video();
				video.setId(rs.getLong("id"));
				video.setNombre(rs.getString("nombre"));
				video.setUrl(rs.getString("url"));
				//añadimos en array
				videos.add(video);
				}catch(Exception e) {
					videos.toString();
					System.out.println("video no valido");
					e.printStackTrace();
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return videos;
	}

public ArrayList<Video> getAllByNombre( String nombre ) {
		
		ArrayList<Video> listado = new ArrayList<Video>();
		String sql = "SELECT id, nombre, url FROM oscar WHERE NOMBRE LIKE ? ORDER BY id DESC LIMIT 500;";		
		
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(sql);
			
			){
			
			pst.setString(1, "%" + nombre + "%");	
			
			try( ResultSet rs = pst.executeQuery() ){
			
				Video v = null;
				while(rs.next()) { 			
					try {
						v = new Video();
						v.setId( rs.getLong("id"));
						v.setNombre( rs.getString("nombre"));
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
