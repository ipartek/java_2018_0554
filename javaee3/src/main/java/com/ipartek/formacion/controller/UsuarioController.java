package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.dao.UsuarioDAO;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/privado/usuarios")
public class UsuarioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private static UsuarioDAO dao = null;   
	
	
    @Override
    public void init(ServletConfig config) throws ServletException {    
    	super.init(config);
    	dao = UsuarioDAO.getInstance();
    }
    
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		request.setAttribute("usuarios", dao.getAll() );
		
		request.getRequestDispatcher("usuarios/index.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
