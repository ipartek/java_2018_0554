package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.daos.UsuarioDAO;
import com.ipartek.formacion.modelo.pojos.Usuario;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VISTA_LOGIN= "login.jsp";
	private static final String VISTA_PRINCIPAL= "principal.jsp";
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	Usuario userComprobado = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher(VISTA_LOGIN).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuarioLogin =null;
		
		String vista = VISTA_LOGIN;
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
	
		try {
			UsuarioDAO dao = new UsuarioDAO();
			usuarioLogin = dao.login(email, password);
			if(usuarioLogin != null) {
				vista=VISTA_PRINCIPAL;
				
				request.setAttribute("usuario", usuarioLogin);

				
				//guardar usuario logeado en sesion
				// Como recuperar la session
				HttpSession session = request.getSession();
				//Dar tiempo limite a la sesion
				session.setMaxInactiveInterval(60 * 5); 
				//5 min Los tiempos nunca se pone el resultado en segundos directamente
				// También se puede configurar el cierre de la sesion en el web.xml
				session.setAttribute("usuario_logeado", usuarioLogin);
				

				
			}else {
				request.setAttribute("error", "Usuario NO VALIDO");
			}
		}catch (Exception e) {
			// TODO: handle exception
		} finally {
			request.getRequestDispatcher(vista).forward(request, response);
		}
	}

	/**
	 * Metodo que comprueba si existe el driver
	 */
	private void comprobarDriver() {
		try {
			// Comprueba el drive o la libreria, si existe en el proyecto
			Class.forName("com.mysql.jdbc.Driver").newInstance();

		} catch (Exception e) {

			System.out.println("No existe driver, meter dependencia ne pom.xml");
		}
	}

	/**
	 * Metodo que obtiene todos los usuarios de la base de datos y los introduce en
	 * el arraylist de usuarios
	 * 
	 * @param usuarios
	 * @throws SQLException
	 */
	private void obtenerUsuarios(ArrayList<Usuario> usuarios) throws SQLException {
		Connection conn = conexionBaseDatosUsuario();
		String sql = "select id,nombre,password from usuario order by id desc limit 500";
		PreparedStatement pst = conn.prepareStatement(sql);
		// resultado de una setencia query es resulset --> rs
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Long id = (long) rs.getInt("id");
			String correo = rs.getString("nombre");
			String pass = rs.getString("password");
			Usuario u = new Usuario(id, correo, pass);
			usuarios.add(u);
		}
		cerrarConexion(conn, pst, rs);

	}

	/**
	 * Metodo que comprueba el email y la pass del formulario y que devuelve el
	 * usuario logeado
	 * 
	 * @param usuarioLogin
	 * @return
	 * @throws SQLException
	 */
	private Usuario comprobarUsuario(Usuario usuarioLogin) throws SQLException {
		String sql = "select nombre,password from usuario where nombre=? and password=?";
		Connection conn = conexionBaseDatosUsuario();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, usuarioLogin.getEmail());
		pst.setString(2, usuarioLogin.getPassword());

		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			String nombre = rs.getString("nombre");
			String password = rs.getString("password");
			Usuario user = new Usuario(null, nombre, password);
			return user;
		}
		return null;

	}

	/**
	 * hace la conexion a la base de datos
	 * 
	 * @return
	 * @throws SQLException
	 */
	private Connection conexionBaseDatosUsuario() throws SQLException {
		Connection conn = null;

		conn = DriverManager.getConnection("jdbc:mysql://192.168.0.44/youtube?useSSL=false", "viernes", "juernes");
		return conn;
	}

	/**
	 * Metodo que cierra todas las conexiones
	 * 
	 * @param conn
	 * @param pst
	 * @param rs
	 * @throws SQLException
	 */
	private void cerrarConexion(Connection conn, PreparedStatement pst, ResultSet rs) throws SQLException {
		rs.close();
		pst.close();
		conn.close();
	}

}
