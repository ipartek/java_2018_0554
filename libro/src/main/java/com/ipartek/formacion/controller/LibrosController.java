package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.ipartek.formacion.modelo.pojos.Pagina;

/**
 * Servlet implementation class LibrosController
 */
@WebServlet("/libros")
public class LibrosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Pagina> paginas;	
	private ValidatorFactory factory;
	private Validator validator;
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		
		factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
	
	paginas = new ArrayList<Pagina>();
	
	paginas.add(new Pagina("Amaia", "Sed suscipit hendrerit augue vitae aliquet. Vestibulum eget sem a ipsum tincidunt viverra. Quisque fringilla nisl ut dui dictum aliquam. Sed ut elit eu justo pharetra convallis sit amet sodales lectus. Praesent consectetur iaculis est, vel laoreet nunc vestibulum nec. Cras fermentum maximus pretium. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In hac habitasse platea dictumst. Integer at lorem ipsum. Vivamus consequat consectetur dui, eu fringilla velit posuere sed. Sed in lorem rutrum, eleifend velit ac, scelerisque neque."));
	paginas.add(new Pagina("Kyran", "Sed in euismod quam. Pellentesque ultrices, turpis a ullamcorper ornare, risus massa cursus enim, vel tincidunt sem neque vitae dui. Donec eget massa nibh. Quisque sed nisl a enim scelerisque auctor nec a dui. Pellentesque aliquet elit urna, vel tincidunt arcu tempus ac. Fusce dolor dui, rutrum a dui quis, dapibus pretium nunc. Nullam sapien justo, porta at arcu vel, maximus volutpat enim. Vivamus porta nulla nunc, ut pharetra tortor porttitor nec. Maecenas id luctus velit, et consectetur odio. Integer dapibus gravida sem ut placerat. Sed blandit nulla aliquam libero sagittis, eget pretium libero molestie. Cras ut facilisis velit, sed aliquam velit."));
	paginas.add(new Pagina("Maite", "Nam enim ligula, blandit tincidunt tempor at, lobortis vel neque. Cras convallis maximus vulputate. Curabitur elementum ac nunc vel tincidunt. Aliquam in metus lectus. Curabitur et sodales purus. Donec porttitor urna ex, eget vulputate quam auctor at. Nulla auctor orci ac dui iaculis, id molestie neque vestibulum. Sed maximus diam vitae massa vehicula, et ultrices lacus gravida. Nulla congue convallis sollicitudin. Aliquam dictum nibh nec ligula ullamcorper condimentum. Curabitur vestibulum elit ut dui posuere, nec pharetra justo tincidunt. Aenean id mauris magna. Maecenas auctor faucibus dolor, ut lacinia lorem laoreet a. Etiam eu enim nisi. Fusce ut nisl leo. Proin ipsum lacus, luctus vitae aliquam vel, efficitur vel orci."));
}
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		int pagActual = 0;
		int pagTotal = paginas.size();
		Pagina pagMostrar = new Pagina();
		
		try {
		
			String pagina = request.getParameter("pagina");
			if (pagina != null) {
				pagActual = Integer.parseInt(pagina);
				if (pagActual <=0) {
					pagActual = 0;
				}
				if (pagActual > pagTotal) {
					pagActual = 0;
				}
				pagMostrar = paginas.get(--pagActual);
			} else {
				pagMostrar = paginas.get(0);
			}
		} catch (Exception e) {
			request.setAttribute("alerta", "Página no disponible");
			pagMostrar = paginas.get(0);
			pagActual = 0;
		} finally {
			request.setAttribute("pagina", paginas.get(pagActual));
			request.setAttribute("pagActual", pagActual);
			request.setAttribute("pagTotal", pagTotal);
			
			request.getRequestDispatcher("libro.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String autor = request.getParameter("autor");
		String texto = request.getParameter("texto");
		Pagina p = new Pagina();
		int paginaActual = 0;
		
		try {
		
			p = new Pagina(texto, autor);
			
			//validar			
		    Set<ConstraintViolation<Pagina>> violations = validator.validate(p);
		    if ( violations.isEmpty() ) {
		    	
		    	paginas.add(p);
		    	
		    }else {
		    	
		    	request.setAttribute("alerta", "Por favor rellena el autor y texto");
		    }
			
			paginaActual = paginas.size();
				
		}catch (Exception e) {
			request.setAttribute("alerta", "Error Escribiendo pagina" );
			
		}finally {
			request.setAttribute("pagina", p );
			request.setAttribute("paginaActual", --paginaActual );
			request.setAttribute("paginasTotal",  paginas.size() );
			request.getRequestDispatcher("libro.jsp").forward(request, response);
		}		
	}

}
