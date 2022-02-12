package com.flexsoles.modelo;

import com.flexsoles.entidad.Usuario;

public interface UsuarioDAO extends DaoGenerico<Usuario> {
	Usuario getUsuarios(String nombre);
	Usuario buscar(long id);
}
