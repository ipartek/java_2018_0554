package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacin.pojo.Pagina;
import com.ipartek.formacin.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VIEW_LOGIN = "login.jsp";
	public static final String CONTROLLER_INSERTAR = "privado/insertar.jsp";
	
	private static ArrayList<Usuario> getAll(){
		ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
		usuarios.add(new Usuario(1L,"ima@gmail.com","Pa$$w0rd"));
		usuarios.add(new Usuario(1L,"curso@mail.com","Pa$$w0rd"));
		return usuarios;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("activologin", "active");
		
		request.getRequestDispatcher(VIEW_LOGIN).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String mail=request.getParameter("mail");
		String pass=request.getParameter("pass");
		
		ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
		usuarios=getAll();
		
		for(int i=0; i<usuarios.size();i++) {
			if(mail.equals(usuarios.get(i).getEmail()) && pass.equals(usuarios.get(i).getPassword())) {
				request.getRequestDispatcher(CONTROLLER_INSERTAR).forward(request, response);
			}
		}
		
	}

}

