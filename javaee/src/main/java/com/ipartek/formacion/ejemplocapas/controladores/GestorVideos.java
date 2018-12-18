package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.daos.VideoDAO;
import com.ipartek.formacion.modelo.pojos.Videos;

import ENDESHUSOcom.ipartek.formacion.ejemplocapas.pojos.Usuario;

/**
 * Servlet implementation class GestorVideos
 */
public class GestorVideos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private VideoDAO dao =null;

	
	//ini server config 
@Override
	public void init(ServletConfig config) throws ServletException {
	//se ejecuta con la 1ª peticion y solo una vez, el resto de peticion doService
		super.init(config);
		dao=new VideoDAO();
	}
	
@Override
public void destroy() {
	//se ejecuta al parar el servidor
	super.destroy();
	dao=null;
}


@Override
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	// antes del doGet o doPost
	System.out.println("Antes del get o post");
	super.service(req, res);
	//Despues del doGet o doPost
	System.out.println("Despues del get o post");
}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<Videos> videos = new ArrayList<Videos>();
		
		VideoDAO dao= new VideoDAO();
		
		
//		videos.add("video1");
//		videos.add("Fary");
//		videos.add("Que no...");
//		
		
		request.setAttribute("videos", dao.getAll());
		
		request.getRequestDispatcher("videos.jsp").forward(request,response);
		
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busqueda= request.getParameter("busqueda");
		
		ArrayList<Videos> videos= new ArrayList<Videos>();
		
//videos.add("video1");		
		
		VideoDAO dao = new VideoDAO();
		
		request.setAttribute("videos", dao.getAllByNombre(busqueda));
	
		request.setAttribute("busqueda", busqueda);
		
		request.getRequestDispatcher("videos.jsp").forward(request, response);
	}

}
