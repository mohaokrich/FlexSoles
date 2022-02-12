package com.flexsoles.modelo;
import java.util.List;
import java.util.Optional;

import com.flexsoles.entidad.Compra;
import com.flexsoles.entidad.Producto;

public interface ProductoDAO extends DaoGenerico<Producto>{
	List<Producto> get8Productos();
	List<Producto> buscarNombre(String titulo);
}


