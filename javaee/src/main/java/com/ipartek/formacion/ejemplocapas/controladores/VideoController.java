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
import com.ipartek.formacion.modelo.pojos.Perro;
import com.ipartek.formacion.modelo.pojos.Video;

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
		
		ArrayList<Video> videos = new ArrayList<Video>();
		
		Video v1 = new Video(1L, "video1", "https://http2.mlstatic.com/pastor-aleman-cachorros-super-calidad-vip-D_NQ_NP_949437-MLM27059324737_032018-F.jpg");
		Video v2 = new Video(2L, "Fary", "https://t2.ea.ltmcdn.com/es/razas/0/0/1/img_100_labrador-retriever_0_600.jpg");
		Video v3 = new Video(3L, "Que nos se te olcide el WHERE XD", "https://t1.ea.ltmcdn.com/es/razas/0/4/3/img_340_beagle_0_600.jpg");
		
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