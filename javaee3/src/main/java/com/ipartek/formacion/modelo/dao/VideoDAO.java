package com.ipartek.formacion.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojo.Video;

public class VideoDAO {
	
	private static VideoDAO INSTANCE = null;
	
	private VideoDAO() {
		super();
	}
	
	public synchronized static VideoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VideoDAO();
		}
		
		return INSTANCE;
	}
	
	public ArrayList<Video> getAll(){
		ArrayList<Video> videos = new ArrayList<Video>();
		String sql = "SELECT id, nombre, url FROM anderSolana ORDER BY id DESC LIMIT 500";
		try(Connection conn = ConnectionManager.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery()
		) {
			
			while(rs.next()) {
				try {
					
				Video video = new Video();
				video.setId(rs.getLong("id"));
				video.setNombre(rs.getString("nombre"));
				video.setUrl(rs.getString("url"));
				videos.add(video);
				}catch (Exception e) {
					
					System.out.println("Video no v�lido");
					e.printStackTrace();
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return videos;
	}
	
	public ArrayList<Video> buscarVideo(String nombre){
		ArrayList<Video> videos = new ArrayList<Video>();
		String sql = "SELECT id, nombre, url FROM anderSolana WHERE nombre LIKE ? ORDER BY id DESC LIMIT 500";
		try(Connection conn = ConnectionManager.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
		) {
			
			pst.setString(1, "%" + nombre + "%");
			
			try(ResultSet rs = pst.executeQuery()
			){
				while(rs.next()) {
					try {
						
					Video video = new Video();
					video.setId(rs.getLong("id"));
					video.setNombre(rs.getString("nombre"));
					video.setUrl(rs.getString("url"));
					videos.add(video);
					}catch (Exception e) {
						
						System.out.println("Video no v�lido");
						e.printStackTrace();
					}
				}
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return videos;
	}

}
