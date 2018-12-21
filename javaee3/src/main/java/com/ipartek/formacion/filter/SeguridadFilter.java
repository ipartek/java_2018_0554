package com.ipartek.formacion.filter;

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

import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Servlet Filter implementation class SeguridadFilter
 */
@WebFilter(dispatcherTypes = {
		DispatcherType.REQUEST,
		DispatcherType.INCLUDE, 
		DispatcherType.FORWARD, 
		DispatcherType.ERROR 
		}
, urlPatterns = { "/privado/*" })
public class SeguridadFilter implements Filter {


	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest req= (HttpServletRequest)request;
		
		HttpServletResponse res= (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		
		Usuario uLogeado=(Usuario)session.getAttribute("usuario_logeado");
		
		if(uLogeado!=null) {
			// continua la peticion del usuauir
			chain.doFilter(request, response);
		}else {
			//vuleta al login pork se ha saltado o se ha acabado la  sesion
			//res.sendRedirect("../login");
		
			session.setAttribute("error", "Inicia sesion para acceder a la zona privada");
			res.sendRedirect(req.getContextPath()+"/index.jsp");
			
		}
		
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
