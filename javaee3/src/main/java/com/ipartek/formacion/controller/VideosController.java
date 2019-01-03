package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.ipartek.formacion.modelo.dao.VideoDAO;
import com.ipartek.formacion.modelo.pojo.Alerta;
import com.ipartek.formacion.modelo.pojo.Video;


/**
 * Servlet implementation class VideosController
 */
@WebServlet("/privado/videos")
public class VideosController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private VideoDAO dao;
	private ValidatorFactory factory;
	private Validator validator;
       
    @Override
    public void init(ServletConfig config) throws ServletException {    
    	super.init(config);
    	dao = VideoDAO.getInstance();    	
    	factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		ArrayList<Video> video = new ArrayList<Video>();
//		
//		request.setAttribute("video", dao.getAll());
//		
//		request.getRequestDispatcher("videos/index.jsp").forward(request, response);
//		
		
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		vista = VIEW_INDEX;
	alerta = null;
		try {
			// recoger parametros
			getParametros(request);
			// realizar operacion
		switch (op) {
				case OP_IR_FORMULARIO:
					irFormulario(request);
					break;
			case OP_GUARDAR:
					guardar(request);
				break;	
				case OP_ELIMINAR:
					eliminar(request);
					break;	
			default:
					listar(request);
					break;
			}
			
			
		}catch (Exception e) {
			LOG.error(e);		
			alerta = new Alerta( Alerta.TIPO_DANGER, "Error inexesperado sentimos las molestias.");
			
	}finally {
			// mensaje para el usuario
			request.setAttribute("alerta", alerta);
			// ir a una vista
			request.getRequestDispatcher(vista).forward(request, response);
		}	
	}

		
		private void listar(HttpServletRequest request) {

			// alerta = "Lista de Usuarios";
			request.setAttribute("video", dao.getAll());		
			
		}
		
	}
   
		
		private void getParametros(HttpServletRequest request) {

			op = request.getParameter("op");
			if( op == null ) {
			op = OP_LISTAR;
			} 

			id = request.getParameter("id");
			nombre = request.getParameter("nombre");
			codigo = request.getParameter("codigo");

		LOG.debug( String.format("parametros: op=%s id=%s nombre=%s codigo=%s", op, id, nombre, codigo ));

	}

		
		
//		public boolean insert( Video v) throws SQLException {
//
//			boolean resul = false;
//			String sql = "INSERT INTO `video` (`nombre`, `codigo`) VALUES (?,?);";
//			try ( Connection conn = ConnectionManager.getConnection();
//				  PreparedStatement pst = conn.prepareStatement(sql);				   
//				){
//
//				pst.setString(1, u.getEmail());
//				pst.setString(2, u.getPassword());			
//				int affectedRows = pst.executeUpdate();
//				if ( affectedRows == 1 ) {
//					resul = true;
//				}
//
//			}
//			return resul;
//
//		}
		
}
	
}