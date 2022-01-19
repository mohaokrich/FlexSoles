package com.flexsoles.seguridad;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.flexsoles.persistencia.Rol;
import com.flexsoles.persistencia.Usuario;
import com.flexsoles.servicios.UsuarioServicio;

public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler{
	@Autowired
	private UsuarioServicio UsuarioServicio;

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		HttpSession session = request.getSession();
		Usuario authUser = UsuarioServicio.buscarPorNombreUsuario(userDetails.getUsername());
		session.setAttribute("usuario", authUser);
		session.setAttribute("usuario.nombre", authUser.getNombre());
		session.setAttribute("usuario.id", authUser.getId());

		boolean isUsuario = false;
		boolean isAdmin = false;
		final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (final GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("USER")) {
				isUsuario = true;
				session.setAttribute("usuario.rol", grantedAuthority.getAuthority().equals("USER"));
				break;
			} else if (grantedAuthority.getAuthority().equals("ADMIN")) {
				isAdmin = true;
				session.setAttribute("usuario.rol", grantedAuthority.getAuthority().equals("ADMIN"));
				break;
			}
		}

		String targetUrl;
		if (isUsuario) {
			targetUrl = "/index";
		} else if (isAdmin) {
			targetUrl = "/producto/crear";
		} else {
			throw new IllegalStateException();
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	public void setRedirectStrategy(final RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}



}
