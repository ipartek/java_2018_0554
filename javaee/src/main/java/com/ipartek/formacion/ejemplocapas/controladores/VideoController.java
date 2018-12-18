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

/**
 * Servlet implementation class VideoController
 */
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO dao = null;
       
   @Override
public void init(ServletConfig config) throws ServletException {
	super.init(config);
	//se ejecuta con la primera petición y solo una vez. El resto de peticiones doService
	dao = new VideoDAO();
}
   @Override
public void destroy() {
	super.destroy();
	//se ejecuta al parar el servidor
}
   @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   //se ejecuta antes de doGet o doPost
	   System.out.println("antes de doGet o doPost");
	super.service(req, resp);
	//se ejecuta después de doGet o doPost
	System.out.println("después de doGet o doPost");
}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<String> videos = new ArrayList<String>();
		
		videos.add("video1");
		videos.add("Fary");
		videos.add("Que nos se te olcide el WHERE XD");
		
		request.setAttribute("videos", videos);
		
		request.getRequestDispatcher("videos.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String busqueda = request.getParameter("busqueda");
		
		ArrayList<String> videos = new ArrayList<String>();
		videos.add("video1");		
		
		request.setAttribute("videos", videos);
		request.setAttribute("busqueda", busqueda);
		request.getRequestDispatcher("videos.jsp").forward(request, response);
	}

}