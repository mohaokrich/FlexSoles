package com.flexsoles.modelo;

import com.flexsoles.persistencia.Usuario;

public interface UsuarioDAO extends DaoGenerico<Usuario> {
	Usuario getUsuarios(String nombre);
	Usuario buscar(long id);
}
