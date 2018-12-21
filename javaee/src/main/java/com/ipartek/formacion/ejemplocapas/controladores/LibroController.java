package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.pojos.Libro;

public class LibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Libro> libros = new ArrayList<Libro>();
		
		libros.add(new Libro(1,"La conjura de los necios", "John Kennedy Toole","https://www.anagrama-ed.es/uploads/media/portadas/0001/20/fe3abb0d94d574517d0160e09ce080edff62814b.jpeg"));
		libros.add(new Libro(2,"Memorias del subsuelo", "Fiodor Dostoyevski","https://kbimages1-a.akamaihd.net/85b2a6e6-9f3f-4e92-b420-5276fc5fdbdc/353/569/90/False/memorias-del-subsuelo.jpg"));
		libros.add(new Libro(3,"Opiniones de un payaso", "Heinrich Böll","https://cloud10.todocoleccion.online/libros-clasicos-segunda-mano/tc/2011/11/28/29496744.jpg"));
		libros.add(new Libro(4,"Trainspotting", "Irvine Welsh","https://images.gr-assets.com/books/1379533280l/703645.jpg"));
		
		request.setAttribute("libros", libros);
		
		ArrayList<Libro> lista_compra = new ArrayList<Libro>();
		
		request.getRequestDispatcher("libros.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String busqueda = request.getParameter("busqueda");
		
		ArrayList<Libro> libros = new ArrayList<Libro>();
		
		libros.add(new Libro(1,"La conjura de los necios", "John Kennedy Toole","https://www.anagrama-ed.es/uploads/media/portadas/0001/20/fe3abb0d94d574517d0160e09ce080edff62814b.jpeg"));
						
		request.setAttribute("libros", libros);		
		//request.setAttribute("busqueda", busqueda);
		request.getRequestDispatcher("libros.jsp").forward(request, response);
	}

}