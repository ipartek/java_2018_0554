package com.ipartek.formacion.controladores;

import java.io.IOException; // excepciones 
import java.util.HashMap; // java util para colecciones

import javax.servlet.ServletException;  // paquetes servlets generados
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojos.Noticia;  // importar paquete de la clase POJO Proyecto  //CAMBIO NOMBRE PAQUETE
 
@WebServlet("/borrarnoticiaservlet") // id servlet. nombre para llamarlo
public class BorrarNoticiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//request peticion ; response ; respuesta generada a la peticion
		// metodo con dos parametros el que recibe OBJETO request y el que responde OBJETO response
		
		// do get para pedir nombres titulo fecha etc... 
		// Se envia la informacion del formulario por url  
		
		
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// PETICION
		//Creamos el atributo del objeto request (DE la peticion ). lo que se escribe por EL CAMPO id SE ENVIA POR REQUEST DESDE JSP Y lo guarda en STRING ID
		String id = request.getParameter("id");
		
		@SuppressWarnings("unchecked") // Suprimimos advertencias de nombre "unchecked"
		
		// HASH MAP FUNCION CON UNA clave y un valor  clave (tipo) Long, valor Proyecto
		HashMap<Long, Noticia> proyectos = 
				(HashMap<Long, Noticia>) request.getServletContext().getAttribute("noticias");
		
		// GENERAR RESPUESTA A LA PETICION
		// elimina el elemento del hashmap mediante metodo remove
		proyectos.remove(Long.parseLong(id)); // borrar proyecto de una determinada id mediante el metodo remove.  Hay un casting entre long e id
		
		//getRequestDispatcher.forward  sirve para que el servlet envie la respuesta al jsp. mediante el objeto request
		request.getRequestDispatcher("mantenimiento.jsp").forward(request, response);
	}

	
	// doPost tambien recibe y genera respuesta es parecido que get pero cambia. Se recomienda para Archivos adjuntos, formularios con comentarios etc.
		//se envia la informacion del formulario  por objeto request
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
