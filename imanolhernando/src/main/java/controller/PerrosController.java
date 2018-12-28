package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.PerroDAO;
import pojos.Perro;


/**
 * Servlet implementation class PerroController
 */
@WebServlet("/privado/perros")
public class PerrosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PerroDAO dao;
	ArrayList<Perro> perros;
	
	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		 
    	dao = PerroDAO.getInstance();
    	
    	 perros= new ArrayList<Perro>();
    	 perros=dao.getAll();
    	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String chip = request.getParameter("chip");
		Perro p= new Perro();
		
		if(chip==null) {
		request.setAttribute("perros", perros);	
		request.getRequestDispatcher("perros.jsp").forward(request, response);
		
		}else {
		
		
		
			try {
				
				Long txip=Long.parseLong(chip);
				p=dao.getByChip(txip);
				
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				request.setAttribute("perro", p);	
				request.getRequestDispatcher("perro.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ArrayList<Perro> perros= new ArrayList<Perro>();
//		perros=dao.getAll();
		
		String nombre = request.getParameter("nombre");
		String chip = request.getParameter("chip");
		String raza = request.getParameter("raza");
		try {
			Long txip=Long.parseLong(chip);
			Perro p = new Perro(nombre,1,raza,true,txip, 43.257,-2.92344);
			perros.add(p);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			request.setAttribute("perros", perros);	
			request.getRequestDispatcher("perros.jsp").forward(request, response);
		}
		
		
		
		
		
	}

}
