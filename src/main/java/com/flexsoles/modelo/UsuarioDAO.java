package com.flexsoles.modelo;


import java.util.List;
import java.util.Optional;

import com.flexsoles.persistencia.Rol;
import com.flexsoles.persistencia.Usuario;

public interface UsuarioDAO {
	int crearUsuario(Usuario u);

	Usuario iniciarSesion(String nombre, String passwd);
	Optional<Usuario> buscarId(long id);
	List <Usuario> getUsuarios();
	Usuario getUsuarios(String nombre);
	List<Rol> findUserRoles(long id);

	int saveTablaRoles(long id, String rol);
	int saveRol(long idRol, long idUsuario);

	long getId(String nombre);

}
