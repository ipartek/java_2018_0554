package com.ipartek.formacion.libroCompartido.controller;

import java.io.IOException;import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.libroCompartido.modelo.pojo.Libro;
import com.ipartek.formacion.libroCompartido.modelo.pojo.Pagina;

/**
 * Servlet implementation class LibroController
 */
@WebServlet("/index")
public class LibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<Long, Pagina> paginas;
	private Libro libroPrincipal;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//Se crea las paginas del libro y luego se introducen en el libro
		paginas = new HashMap<>();
			paginas.put(1L,new Pagina(1L," Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas eget semper nunc, in ullamcorper dui. Donec dui ante, porta nec fermentum at, bibendum sed lectus. Cras porta elit et est placerat, nec interdum leo condimentum. Sed faucibus nunc id hendrerit vehicula. Sed dapibus, turpis sit amet varius rhoncus, tortor nisl efficitur velit, non imperdiet nunc dui a metus. Integer blandit nulla nisl, sed maximus nibh semper ut. Mauris rutrum, nibh eget hendrerit tempor, mi justo tempus enim, eu feugiat purus eros non ante. Cras tempor justo ut ullamcorper pretium. Sed fermentum nunc a libero accumsan, in luctus nulla convallis. Donec eleifend hendrerit nulla dictum imperdiet. Vestibulum a neque hendrerit, faucibus eros vitae, mollis eros.","Pepe"));
			paginas.put(2L,new Pagina(2L," Nullam ut luctus est. Donec finibus leo massa, sed consectetur nisi dapibus at. Phasellus eleifend non magna at gravida. Proin ac pulvinar nisl. Mauris dapibus magna vel nulla finibus imperdiet. Sed et facilisis turpis. In a sem quam. Cras finibus nunc in purus convallis, ac aliquam lorem interdum.","Manolo"));
			paginas.put(3L,new Pagina(3L,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas feugiat sollicitudin neque, a rhoncus ipsum hendrerit ac. Suspendisse ac ligula justo. Mauris arcu magna, tristique eget lobortis mollis, feugiat et ipsum. Vivamus eu interdum nisl, ut venenatis sem. Aenean at massa vel orci porttitor ultricies in eget sem. Proin nunc. ","Daniel"));

		 libroPrincipal = new Libro(1L, 1, paginas, paginas.size());
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pagina = request.getParameter("pagina");
		
		
		if(pagina == null ) {
			pagina ="1";
		}
		
		Pagina paginaMostrar= libroPrincipal.getPaginas().get(Long.parseLong(pagina));
		
		request.setAttribute("paginaMostrar", paginaMostrar);
		request.setAttribute("paginasTotales", libroPrincipal.getTotalPaginas());

		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
