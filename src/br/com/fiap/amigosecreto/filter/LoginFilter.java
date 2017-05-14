package br.com.fiap.amigosecreto.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.amigosecreto.entity.Usuario;
import br.com.fiap.amigosecreto.enums.Perfil;

@WebFilter({ "/*" })
public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String url = getUrl(request);
		if (url != null) {
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect(url);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	private static String getUrl(ServletRequest request) {
		HttpServletRequest req = (HttpServletRequest) request;
		if (req == null || req.getMethod().equals("POST")) {
			return null;
		}
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		String uri = req.getRequestURI();
		boolean ehPaginaLivre = ehPaginaLivre(uri);
		if (usuario == null && ehPaginaLivre) {
			return null;
		}
		if (usuario == null && !ehPaginaLivre) {
			return "login";
		}
		boolean ehAdministrador = usuario.getPerfil() == Perfil.ADMINISTRADOR;
		if (ehAdministrador && uri.contains("/user")) {
			return "admin";
		}
		if (!ehAdministrador && uri.contains("/admin")) {
			return "user";
		}
		if (!ehPaginaLivre) {
			return null;
		}
		if (ehAdministrador) {
			return "admin";
		}
		return "user";
	}
	
	private static boolean ehPaginaLivre(String uri) {
		return uri.equals("/JavaWeb-AmigoSecreto/") || uri.contains("/login") || uri.contains("/cadastro");
	}

}
