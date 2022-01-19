package com.flexsoles.servicios;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.flexsoles.persistencia.Usuario;

public interface UsuarioServicio extends UserDetailsService{
	public Usuario buscarPorNombreUsuario(String username);
	public int crearUsuario (Usuario u);
	
}
