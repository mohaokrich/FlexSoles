package com.flexsoles.modelo;


import java.util.List;
import java.util.Optional;

import com.flexsoles.persistencia.Rol;
import com.flexsoles.persistencia.Usuario;

public interface UsuarioDAO extends DaoGenerico<Usuario> {
	Usuario getUsuarios(String nombre);
}
