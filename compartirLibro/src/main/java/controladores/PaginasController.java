package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Pagina;

public class PaginasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<Pagina> libro = new ArrayList<Pagina>();
		Pagina pagina = new Pagina(1);
		libro.add(pagina);
		
		request.setAttribute("pagina", pagina.getByNumero(libro,1));
		request.setAttribute("libro", libro);
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Pagina> libro = new ArrayList<Pagina>();

		libro.add(new Pagina(1));
		libro.add(new Pagina(2));
		libro.add(new Pagina(3));
		libro.add(new Pagina(4));
		libro.add(new Pagina(5));

		int numeroPagina;

		Pagina pagina = (Pagina) request.getAttribute("pagina");

		String cambiarPagina = request.getParameter("cambioPagina");

		try {
			if (cambiarPagina.equals("anterior") && pagina.getNumero() != 1) {
				numeroPagina = pagina.getNumero() - 1;
				request.setAttribute("pagina", pagina.getByNumero(libro, numeroPagina));
			} else if (cambiarPagina.equals("siguiente") && pagina.getNumero() != libro.size()) {
				numeroPagina = pagina.getNumero() + 1;
				request.setAttribute("pagina", pagina.getByNumero(libro, numeroPagina));
			}
			numeroPagina = pagina.getNumero() + 1;
			
		} catch (Exception e) {			
			request.setAttribute("mensaje", "Ha ocurrido un error");
			
		} finally {			
			request.setAttribute("libro", libro);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

}
