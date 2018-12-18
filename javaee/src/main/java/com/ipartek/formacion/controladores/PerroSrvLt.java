package com.ipartek.formacion.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelos.daos.PerroDAO;


public class PerroSrvLt extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PerroSrvLt() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*ArrayList<Perro> perros = new ArrayList<Perro>();
			perros.add(new Perro(1,"Beagle","https://t1.ea.ltmcdn.com/es/razas/0/4/3/img_340_beagle_0_600.jpg"));	
			perros.add(new Perro(2,"Akita","https://t1.ea.ltmcdn.com/es/razas/7/0/1/img_107_akita-inu-o-akita-japones_0_600.jpg"));	
			perros.add(new Perro(3,"Boxer","https://www.petdarling.com/articulos/wp-content/uploads/2014/08/boxer.jpg"));*/	
			PerroDAO dao = new PerroDAO();
			request.setAttribute("listado", dao.getAll());
			request.getRequestDispatcher("misperros.jsp").forward(request, response);
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
