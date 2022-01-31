package com.flexsoles.servicios;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.flexsoles.modelo.DaoGenerico;
import com.flexsoles.persistencia.Usuario;

public interface UsuarioServicio extends UserDetailsService, DaoGenerico<Usuario>{
	public Usuario buscarPorNombreUsuario(String username);
	public Usuario crearUsuario(Usuario u);
	
}
