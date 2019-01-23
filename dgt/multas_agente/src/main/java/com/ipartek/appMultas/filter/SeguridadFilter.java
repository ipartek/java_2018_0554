package com.ipartek.appMultas.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.appMultas.controller.pojo.Mensaje;
import com.ipartek.appMultas.modelo.pojo.Agente;

/**
 * Servlet Filter implementation class SeguridadFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/privado/*" })
public class SeguridadFilter implements Filter {


	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {	}
	public void init(FilterConfig fConfig) throws ServletException { }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		Agente aLogueado = (Agente) session.getAttribute("agenteLogueado");
		
		if (aLogueado!=null) {
			chain.doFilter(request, response);
		}else {
			session.setAttribute("mensaje", new Mensaje(Mensaje.TIPO_DANGER, "No tienes permiso, por favor, logueate"));
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

}
