package com.flexsoles.servicios;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flexsoles.entidad.Rol;
import com.flexsoles.entidad.Usuario;
import com.flexsoles.modelo.RolesDao;
import com.flexsoles.modelo.UsuarioDAO;
@Transactional
@Service
public class UsuarioServicioImpl implements UsuarioServicio,UserDetailsService {

//	@Autowired
//	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	UsuarioDAO usuariodao;
	
	@Autowired
	RolesDao roldao;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscarPorNombreUsuario(String nombre) {
//		return  jdbcTemplate.queryForObject("select * from UsuariosSecurity where nombre like ?", (rs,
//				rowNum) -> new Usuario(rs.getLong("id"), rs.getString("nombre"),rs.getString("apellidos"),rs.getString("rol"),rs.getString("email"), rs.getString("passwd"), rs.getString("fechaNacimiento")), "%"+nombre+"%");
	return null;
	}

	@Override
	public Usuario crearUsuario(Usuario u) {
		Rol rol = roldao.buscar(1L);
		
		//rol.setNombre_rol("ADMIN"); --> CREAR ADMIN	
		u.anadirRol(rol);
		return usuariodao.crear(u);
	}

	@Override
	public long contarTodos(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Usuario crear(Usuario t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrar(Object id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario buscar(Object id) {
		return usuariodao.buscar(id);
	}

	@Override
	public Usuario actualizar(Usuario t) {
		// TODO Auto-generated method stub
		return null;
	}

}
