package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.daos.VideoDAO;
import com.ipartek.formacion.modelo.pojos.Videos;

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
		
		
		try {
			String id= request.getParameter("id");
			
//buscar en BD el Video por Id [DAO]
			
				//creo a partir del DAO 
			VideoDAO dao = new VideoDAO();
			
			request.setAttribute("videoCarrito", dao.getById(Long.parseLong(id)));//DEL ID DEL VIDEO EXTRAIGO LO DEMAS DE LA BD 
			request.getRequestDispatcher("videos").forward(request, response); //reenvio los datos al Servlet que procesa la lista de videos
			
//recuperamos carrito de sesion del usuario
			HttpSession session=request.getSession();
			
			ArrayList<Videos>carrito=(ArrayList<Videos>)session.getAttribute("videos");
			
			if(carrito==null) {
				carrito=new ArrayList<Videos>();
				
			}
			
			//pull
			
			//añadimos el nuevo video 
//			carrito.add(v);
			
			//pull
			//guardamos el carrito de sesion de nuevo
			session.setAttribute("carrito", carrito);
			//hacer...
			
			//redirect a videos .jsp (http://localhost:8080/javaee/videos)
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	finally {
		//redirect a videos.jsp
	}
	}

}
