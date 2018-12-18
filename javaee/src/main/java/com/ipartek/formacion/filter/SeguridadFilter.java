package com.ipartek.formacion.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.pojos.Usuario;

/**
 * Servlet Filter implementation class SeguridadFilter
 */
public class SeguridadFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		Usuario uLogueado = (Usuario) session.getAttribute("usuario_logueado");

		if (uLogueado!=null) {
			// pass the request along the filter chain (Continua la petición del usuario al servlet/jsp)
			chain.doFilter(request, response);
		}else {
			//Redirigir al login porque el usuario se ha saltado la sesión o ha caducado
			//req.getLocalAddr();
			session.setAttribute("sesionNoIniciada", "No tienes permiso, por favor inicia sesión");
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
