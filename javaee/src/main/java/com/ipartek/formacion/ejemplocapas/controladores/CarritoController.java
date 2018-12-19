package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.daos.VideoDAO;

/**
 * Servlet implementation class CarritoController
 */
public class CarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//recibir parametros (id)
		
		
		String id= request.getParameter("id");
		
	//buscar en BD el Video por Id [DAO]
		
			//creo a partir del DAO 
		VideoDAO dao = new VideoDAO();
		
		request.setAttribute("videoCarrito", dao.getById(Long.parseLong(id)));//DEL ID DEL VIDEO EXTRAIGO LO DEMAS DE LA BD 
		request.getRequestDispatcher("videos").forward(request, response); //reenvio los datos al Servlet que procesa la lista de videos
		
	//recuperamos carrito de sesion del usuario
		
		//añadimos el nuevo video 
		
		//guardamos el carrito de sesion de nuevo
		
		//redirect a videos .jsp (http://localhost:8080/javaee/videos)
		
	
	}

}
