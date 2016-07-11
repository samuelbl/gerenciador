package br.com.alura.gerenciador.web;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements javax.servlet.Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

	    String usuario = getUsuario(req);    
	    
	    System.out.println("Usuario " + usuario + " acessando a URI "
	            + req.getRequestURI());

	    chain.doFilter(request, response);
		
		
	}

	private String getUsuario(HttpServletRequest req) {

	     Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");	   
	     if (usuario==null) return "<deslogado>";
	     return usuario.getEmail();
	     
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
		
}
