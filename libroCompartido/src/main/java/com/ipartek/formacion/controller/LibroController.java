package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.pojo.Libro;
import com.ipartek.formacion.modelo.pojo.Pagina;

/**
 * Servlet implementation class LibroController
 */
@WebServlet("/libro")
public class LibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<Long, Pagina> paginas;
	private Libro libro;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		paginas = new HashMap<Long, Pagina>();
		paginas.put(1L, new Pagina(0L, "Peter", "A parte del colombiano Jeison Murillo, que a partir del año que viene podrá ser alineado para dar oxígeno a Gerard Piqué y Clément Lenglet, el Barça tiene previsto inscribir en la Champions League, de cara a las rondas finales, a Moussa Wague. Así lo confirmó Ernesto Valverde en la rueda de prensa previa al encuentro contra el Celta de Vigo, donde se le cuestionó por la poca presencia de jugadores del filial en el primer equipo."));
		paginas.put(1L, new Pagina(1L, "Ander", "El lateral derecho senegalés, que el pasado verano se convirtió en el africano más joven en marcar un gol en un Mundial, podrá unirse a los Riqui Puig, Miranda y compañía sobre todo en la Copa del Rey, donde el 'Txingurri' tiene previsto dar descanso a los jugadores titulares, siempre y cuando el cuadro del torneo no se empine mucho."));
		paginas.put(2L, new Pagina(2L, "Pedro", "Wague cumplió 20 años el pasado octubre y aterrizó en el Barça B procedente del KAS Eupen belga. Debutó tarde por problemas burocráticos que también le impidieron ser inscrito para ayudar al primer equipo. Ahora, salvo impedimento de última hora, ya podrá entrar en convocatorias cuando el entrenador lo estime conveniente. Es un jugador rápido, con sentido ofensivo, y que combinaría con Sergi Roberto y Semedo en la posición de lateral derecho. Por la izquierda, el relevo de la casa es Miranda."));
		paginas.put(3L, new Pagina(3L, "Ander", "El futbolista serbio, ex del Valladolid y del Villarreal, juega actualmente en el Astana. En el mercado de invierno de la temporada 2007/08 fichó, cuando tenía 24 años, por el Borussia Dortmund. Fue presentado junto a Hummels. Los alemanes pagaron cerca de tres millones por él. Ya era internacional con su país, pero no tuvo demasiadas oportunidades en el equipo y año y medio después decidió marcharse cedido al 1860 Múnich. No volvería más al Borussia Dortmund."));
		paginas.put(4L, new Pagina(4L, "Juanjo", "Uno de los primeros norteamericanos que decidió dar el salto a Europa. En este caso, Donovan aprovechó el final de la MLS para llegar en calidad de cedido al Bayern de Múnich. Era el invierno del 2008/2009 y firmó avalado por Jürgen Klinsmann, por entonces técnico de los bávaros. Landon disputó sólo siete encuentros."));
		
		libro = new Libro(paginas, 1L);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int paginaActual = 1;
		int totalPaginas = libro.getPaginas().size();
		Pagina paginaMostrar = new Pagina();
		
		try {
			String pagina = request.getParameter("pagina");
			if ( pagina != null ) {
				paginaActual = Integer.parseInt(pagina);
				if ( paginaActual <= 0 ) {
					paginaActual = 1;
				}
				if ( paginaActual > totalPaginas ) {
					paginaActual = 1;
				}						
				paginaMostrar = libro.getPaginas().get((long)paginaActual);			
			}else {
				paginaMostrar = libro.getPaginas().get(1L);
			}

	}catch (Exception e) {
		request.setAttribute("alerta", "Pagina NO disponible" );
		paginaMostrar = libro.getPaginas().get(1L);
		paginaActual = 1;

	}finally {
		HttpSession session = request.getSession();
		session.setAttribute("paginas", libro.getPaginas());
		
		request.setAttribute("pagina", paginaMostrar );
		request.setAttribute("paginaActual", paginaActual);
		request.setAttribute("totalPaginas",  totalPaginas );

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}		
		
		
		
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
