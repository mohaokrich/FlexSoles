package com.flexsoles.servicios;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flexsoles.modelo.UsuarioDAO;
import com.flexsoles.persistencia.Rol;
import com.flexsoles.persistencia.Usuario;
@Transactional
@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UsuarioDAO usuarioDao;
	@Override
	public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.getUsuarios(nombre);
		
		Set<Rol> l = usuario.getRoles();
		HashSet<Rol> roles = new HashSet<>();

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Rol rol : usuario.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(rol.getNombre_rol()));
		}
		return new org.springframework.security.core.userdetails.User(usuario.getNombre(), usuario.getPasswd(),
				grantedAuthorities);
	}

}