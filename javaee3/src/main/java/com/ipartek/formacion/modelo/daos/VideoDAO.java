package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojo.Video;

public class VideoDAO {
	private static VideoDAO INSTANCE = null;

	// constructor privado, solo acceso por getInstance()
	private VideoDAO() {
		super();
	}

	public synchronized static VideoDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new VideoDAO();
		}
		return INSTANCE;
	}
	
public Video getById( long id ) {
		
		Video registro = null;
		String sql = "SELECT id, titulo, codigo FROM video WHERE id= ?;";		
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(sql);
			){
			
			pst.setLong(1, id);
			
			try( ResultSet rs = pst.executeQuery() ){
				
				while(rs.next()) { 		
					registro = new Video();
					registro.setId( rs.getLong("id"));
					registro.setTitulo( rs.getString("titulo"));
					registro.setCodigo(rs.getString("codigo"));		
				}
			}
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		
		return registro;
	}
	
	
	
	

	public ArrayList<Video> getAll() {
		ArrayList<Video> listadoVideos = new ArrayList<Video>();
		Video video = null;
		String sql = "SELECT id, titulo, codigo FROM video ORDER BY id DESC LIMIT 500";
		try (
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			){
				try ( ResultSet rs = pst.executeQuery() ){											
					while(rs.next()) { // hemos encontrado usuario								
						video = new Video();
						video.setId( rs.getLong("id"));
						video.setTitulo( rs.getString("titulo"));
						video.setCodigo(rs.getString("codigo"));	
						listadoVideos.add(video);
					}				
			}	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listadoVideos;
	}
	
	
	
	
	public ArrayList<Video> getAllByNombre(String texto1) {
		String texto = texto1;
		ArrayList<Video> listadoVideosBuscados = new ArrayList<Video>();
		Video video = null;
		String sql = "SELECT id, titulo, codigo FROM video WHERE titulo LIKE ? ORDER BY titulo ASC LIMIT 500";
		try (
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			){
				pst.setString(1, "%"+texto+"%");
				try ( ResultSet rs = pst.executeQuery() ){											
					while(rs.next()) { 							
						video = new Video();
						video.setId( Long.parseLong(rs.getString("id")));
						video.setTitulo( rs.getString("titulo"));
						video.setCodigo(rs.getString("codigo"));	
						listadoVideosBuscados.add(video);
					}						
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listadoVideosBuscados;
	}
	
}
