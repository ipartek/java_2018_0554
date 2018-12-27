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

import com.ipartek.formacion.pojo.Pagina;


@WebServlet("/paginas")
public class PaginasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ValidatorFactory factory;
	private Validator validator;
	
	private static ArrayList<Pagina> getAll(){
		ArrayList<Pagina> libro= new ArrayList<Pagina>();
		libro.add(new Pagina("Autor 1","Bootstrap se puede descargar de dos maneras, compilado o mediante el código fiente original. Dependiendo de la forma que hayas elegido, verás una estructura de directorios u otra. En esta sección se muestran los detalles de cada una de ellas."));
		libro.add(new Pagina("Autor 2","La versión original de Bootstrap incluye, además de las versiones compiladas de los archivos CSS y JavaScript, las versiones originales de esos mismos archivos y toda la documentación. Tras descomprimir el archivo que te has descargado con la versión original de Bootstrap, verás la siguiente estructura de archivos y directorios:"));
		libro.add(new Pagina("Autor 3","Los directorios less/, js/ y fonts/ contienen el código fuente utilizado para generar los archivos CSS, JavaScript y las fuentes. El directorio dist/ contiene los mismos archivos que se han mostrado en la sección anterior para la versión compilada de Bootstrap. El direcotrio docs/ incluye el código fuente de la documentación de Bootstrap y un directorio llamado examples/ con varios ejemplos de uso. El resto de archivos están relacionados con otros temas secundarios, como por ejemplo las licencias del código."));
		
		return libro;
	}
	
	private static void insertar(String autor, String texto) {
		ArrayList<Pagina> libro= new ArrayList<Pagina>();
		libro = getAll();
		libro.add(new Pagina(autor, texto));
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int actual=0;
		
		String actualrecogido=request.getParameter("actual");
		
		if(actualrecogido!=null) {
		actual=Integer.parseInt(actualrecogido);
		}
		
		
		ArrayList<Pagina> libro= new ArrayList<Pagina>();
		libro=getAll();
		request.setAttribute("activohome", "active");
		request.setAttribute("paginastotales", libro.size());
		request.setAttribute("pagina", libro.get(actual));
		request.setAttribute("paginaactual", libro.indexOf(libro.get(actual)));
		request.getRequestDispatcher("libro.jsp").forward(request, response);
		
	}


	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String pagina=request.getParameter("pagina");
		int actual=0;
		ArrayList<Pagina> libro= new ArrayList<Pagina>();
		libro=getAll();
		
		String autor = request.getParameter("autor");
		String texto = request.getParameter("textoinsertado");
		Pagina p = new Pagina();
		int paginaActual = 0;
		
		if(autor!=null) {
			try {
				
				p = new Pagina(autor, texto);
				
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
				request.setAttribute("paginaactual", --paginaActual );
				request.setAttribute("paginastotales",  libro.size() );
				request.getRequestDispatcher("libro.jsp").forward(request, response);
			}
			
		}/*FIN IF*/
		
		if(pagina!=null) {
			try {
			
				Integer paginaInt=Integer.parseInt(pagina);
				actual=Integer.parseInt(pagina);
				if(actual>libro.size() || actual==0) {
					request.setAttribute("error", "No existe esa pagina");
					doGet(request, response);
				}
				actual=actual-1;
			
					
				
			}catch(Exception e) {
				request.setAttribute("error", "Inserta un valor numerico");
				doGet(request, response);
			}finally {
				request.setAttribute("paginastotales", libro.size());
				request.setAttribute("pagina", libro.get(actual));
				request.setAttribute("paginaactual", libro.indexOf(libro.get(actual)));
				request.setAttribute("paginaintroducida", actual+1);
				request.getRequestDispatcher("libro.jsp").forward(request, response);
			}
		}
	}


	
	
	
	
	
}
