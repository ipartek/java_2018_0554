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
 * Servlet implementation class LibroController
 */
@WebServlet("/privado/libro")
public class PaginaController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Pagina> libro;	
	private ValidatorFactory factory;
	private Validator validator;
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		
		factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
		
		
		libro = new  ArrayList<Pagina>();
		libro.add( new Pagina("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse et velit porttitor, condimentum dui ut, rhoncus mi. Nunc lacinia arcu nec neque mattis elementum. Praesent pellentesque nibh et enim interdum, at tincidunt felis tempus. Aliquam sit amet risus posuere, cursus libero vitae, aliquet est. Etiam condimentum ac ex id consectetur. Nunc placerat odio interdum tellus facilisis tempus. Nunc a quam eros. Nulla facilisi. Maecenas ullamcorper porttitor tortor, ut laoreet nulla dictum a. Aenean molestie eu nibh id iaculis. Nulla sodales venenatis nibh, id egestas metus.", "autor1"));
		libro.add( new Pagina("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut nec nulla ullamcorper, commodo arcu quis, tincidunt dui. Fusce consectetur pretium magna vitae semper. Praesent sed metus vel purus varius vestibulum. Nullam sagittis ex odio, a pellentesque diam molestie ut. Nam velit nisi, aliquet vel ultrices in, pulvinar quis ex. Integer feugiat rutrum arcu, vitae sagittis lacus interdum et.", "autor2"));
		libro.add( new Pagina("Nam eu accumsan risus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam condimentum fringilla iaculis. Quisque ultricies turpis mauris, quis fringilla leo rhoncus sit amet. Phasellus facilisis enim nec leo sagittis, id eleifend quam efficitur. Morbi a ipsum ac turpis vestibulum congue. Morbi scelerisque libero nulla, ut dictum nisl luctus ac. Sed consectetur blandit dui, sed volutpat tortor pellentesque non. Quisque sit amet ligula sapien. Morbi id pretium eros. Suspendisse turpis sem, tempor sed ipsum non, pulvinar cursus lacus.", "autor3"));
		libro.add( new Pagina("Nullam et lorem semper, auctor neque vel, facilisis ligula. Ut dui sem, malesuada eu ultrices nec, volutpat vel ligula. Fusce a mauris eu massa feugiat suscipit. Fusce id malesuada purus. Vivamus dignissim leo leo, eu rhoncus nisi iaculis a. Sed mattis tincidunt purus, sit amet venenatis libero hendrerit in. Phasellus dui lorem, laoreet id fringilla sed, scelerisque efficitur elit.", "autor4"));
		libro.add( new Pagina("Aliquam laoreet dapibus mi, nec euismod nisi sodales non. Nam eu quam consequat, rhoncus lorem sit amet, viverra nisi. Fusce luctus ante dignissim tortor ornare, eu facilisis sem mattis. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Duis tempus magna non rutrum dapibus. Donec tempus odio id dolor tristique, at rhoncus libero sodales. Duis consequat aliquam mi ut lacinia. Sed semper, est eu sagittis cursus, nulla enim pulvinar neque, in vehicula purus est vitae libero. Curabitur dignissim arcu eu tellus consequat cursus. Curabitur vel pellentesque nibh. Integer ornare viverra enim, auctor eleifend lectus. Donec id nisi ac felis maximus commodo.", "autor5"));		
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int paginaActual = 0;
		int paginasTotal = libro.size();
		Pagina paginaMostrar = new Pagina();
		
		try {
		
				String pagina = request.getParameter("pagina");
				if ( pagina != null ) {
					paginaActual = Integer.parseInt(pagina);
					if ( paginaActual <= 0 ) {
						paginaActual = 1;
					}
					if ( paginaActual > paginasTotal ) {
						paginaActual = 1;
					}						
					paginaMostrar = libro.get(--paginaActual);			
				}else {
					paginaMostrar = libro.get(0);
				}
				
		}catch (Exception e) {
			request.setAttribute("alerta", "Pagina NO disponible" );
			paginaMostrar = libro.get(0);
			paginaActual = 0;
			
		}finally {
			request.setAttribute("pagina", paginaMostrar );
			request.setAttribute("paginaActual", paginaActual);
			request.setAttribute("paginasTotal",  paginasTotal );
			
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
		    	
		    	libro.add(p);
		    	
		    }else {
		    	
		    	request.setAttribute("alerta", "Por favor rellena el autor y texto");
		    }
			
			paginaActual = libro.size();
				
		}catch (Exception e) {
			request.setAttribute("alerta", "Error Escribiendo pagina" );
			
		}finally {
			request.setAttribute("pagina", p );
			request.setAttribute("paginaActual", --paginaActual );
			request.setAttribute("paginasTotal",  libro.size() );
			request.getRequestDispatcher("libro.jsp").forward(request, response);
		}		
			
	}

}