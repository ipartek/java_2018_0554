package com.ipartek.formacion.controller;

import java.io.IOException; //
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.Dao.PalabraDAO;
import com.ipartek.formacion.pojo.Palabra;

@WebServlet("/adivina")
public class AdivinaController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	
	// variables parametros
	
	public  String id ="";
	public   String letra1 ="";
	public  String letra2 ="";
	public  String letra1u ="";
	public  String letra2u ="";
	public String op ="";
	public String  palabraParametros="";
	
	
	
	// variables logica
	private int contador=0;
	private int maxIntentos=7;
	//private String correcta="pi";
	
	// dao y objetos
	private PalabraDAO palabraDAO = null;
	Palabra palabraBaseDatos = null;
	
		
	// init para validator, dao , objetos y colecciones
	@Override  
	public void init(ServletConfig config) throws ServletException {
	
		super.init(config);
		palabraDAO = PalabraDAO.getInstance();
		palabraBaseDatos = new Palabra();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}	
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		try {	
			getParametros(request);
			// realizar operacion
			switch (op) {
				case "jugar":
					jugar(request);
					break;
				case "update":
					update(request);
					break;
					
				}
		
		}catch ( Exception e) {
			request.setAttribute("mensaje", "error fatal en LOGICA ");
		}finally {
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
						
	}// fin doproces
		
		private void getParametros(HttpServletRequest request) {
			  // palabra parametros en un string
			id = request.getParameter("id");	
			letra1 = request.getParameter("letra1");
			letra2 = request.getParameter("letra2");
			op = request.getParameter("op");
			request.setAttribute("maxInt", maxIntentos);
			request.setAttribute("contador", contador);
		
			palabraParametros = (letra1 + letra2); // palabra con parametros
				
			}
		
		
		
		private void jugar(HttpServletRequest request) { 
					
				Long identificador = Long.parseLong(id);
				Palabra ObjetoParametros = new Palabra (identificador,letra1,letra2); //objeto con parametros						
				  // palabra para guardar la de la base de datos
				
				Palabra p = new Palabra();
				 p = palabraDAO.getPalabra(letra1, letra2);  // para obtener palabra de la base de datos
				 try {
					 
					 // logica juego
					 if (  p == null){
						 if (contador < maxIntentos) {						
								;// para que salga la palabra que has escrito
								getParametros(request);
								request.setAttribute("mensaje", "Has fallado");					
								contador ++;
									
								
						 }else if (contador== maxIntentos){ 		
								getParametros(request);
								request.setAttribute("mensaje", "Has perdido");
								contador=0;	
						}				
					}else{
							request.setAttribute("mensaje","has ganado");			
							request.setAttribute("acierto", "acierto");
							contador=0;	
							request.setAttribute("letra1", p.getLetra1());
							request.setAttribute("letra2", p.getLetra2());
							
					} 
					  
				 }catch ( Exception e) {
					 request.setAttribute("mensaje", "error fatal en metodo DAO JUgar");
				 }
				 
		
		}// fin jugar

		
		
		private void update(HttpServletRequest request) {
			Long identificador = Long.parseLong(id);
			letra1u = request.getParameter("letra1u");
			letra2u = request.getParameter("letra2u");
			Palabra palabraActualizar = new Palabra (identificador,letra1u , letra2u); //objeto con parametros						
			  // palabra para guardar la de la base de datos
			

			
			try { //todo que la id sea -1 para nuevas palabras en lugar de actualizar
			palabraDAO.update(palabraActualizar);
			request.setAttribute("mensaje", "Palabra actualizada");
			
			}catch ( SQLException e) {
				request.setAttribute("mensaje", "error fatal en metodo DAO update");
			}
			
		}
}// fin

	
	
	
	