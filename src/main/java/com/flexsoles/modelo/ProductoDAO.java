package com.flexsoles.modelo;
import java.util.List;
import java.util.Optional;

import com.flexsoles.persistencia.Compra;
import com.flexsoles.persistencia.Producto;

public interface ProductoDAO extends DaoGenerico<Producto>{
	List<Producto> get8Productos();
	List<Producto> buscarNombre(String titulo);
}


