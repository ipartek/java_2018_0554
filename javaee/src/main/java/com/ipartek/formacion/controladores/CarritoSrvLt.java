package com.ipartek.formacion.controladores;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelos.daos.CarritoDAO;


public class CarritoSrvLt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CarritoDAO dao=null;
@Override
public void init(ServletConfig config) throws ServletException {
	
	super.init(config);
	dao = new CarritoDAO();
	
}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		request.getSession().setAttribute("carrito", dao.getAll());
		request.getRequestDispatcher("miscomprasperros.jsp").forward(request, response);
		
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
