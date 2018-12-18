package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.daos.VideoDAO;
import com.ipartek.formacion.modelo.pojos.Disco;


/**
 * Servlet implementation class DiscoController
 */
public class DiscoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ArrayList<Disco> discos = new ArrayList <Disco> ();	
	
	discos.add(new Disco());
	

	
	request.setAttribute("discos", discos);
	request.getRequestDispatcher("discos.jsp").forward(request, response);
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String busqueda = request.getParameter("busqueda");
		
		ArrayList<Disco> discos = new ArrayList<Disco>();
		
		DiscoDAO dao = new DiscoDAO();
		
		request.setAttribute("discos", dao.getAllByNombre(busqueda) );		
		request.setAttribute("busqueda", busqueda);
		request.getRequestDispatcher("discos.jsp").forward(request, response);*/
		String busqueda = request.getParameter("busqueda");
		
		ArrayList<String> discos = new ArrayList<String>();
		discos.add("Disco1");		
		
		request.setAttribute("discos", discos);
		request.setAttribute("busqueda", busqueda);
		request.getRequestDispatcher("discos.jsp").forward(request, response);
	}

}
