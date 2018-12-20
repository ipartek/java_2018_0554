package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.daos.VideoDAO;
import com.ipartek.formacion.modelo.pojos.Video;

public class CarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			VideoDAO dao = new VideoDAO();
			Video v = dao.getById(Long.parseLong(id));
			HttpSession session = request.getSession();
			ArrayList<Video> carrito = (ArrayList<Video>) session.getAttribute("carrito");
			if (carrito == null) {
				carrito = new ArrayList<Video>();
			}
			carrito.add(v);
			session.setAttribute("carrito", carrito);
		}
		catch (Exception e) {
			
		}
		finally {
			String url = request.getContextPath() + "/privado/videos";
			response.sendRedirect(url);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
