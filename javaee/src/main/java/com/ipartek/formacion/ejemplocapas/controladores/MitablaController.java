package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.daos.MiTabla;
import com.ipartek.formacion.modelo.daos.UsuarioDAO;
import com.ipartek.formacion.modelo.pojos.Usuario;


public class MitablaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*String email = request.getParameter("email");
		String password = request.getParameter("password");		
		
		try {
			
			UsuarioDAO dao = new UsuarioDAO();			
			usuario = dao.login(email, password);*/
		
		String nombre = request.getParameter("nombre");
		String url = request.getParameter("url");
		
		MiTabla mitabla = new MiTabla();
		mitabla = mitabla.
		
		ArrayList<MiTabla> mitabla = ;
	}

}
