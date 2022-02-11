package com.flexsoles.servicios;

import java.util.List;

import com.flexsoles.modelo.DaoGenerico;
import com.flexsoles.persistencia.Producto;

public interface ProductoServicio extends DaoGenerico<Producto>{
		
	List<Producto> obtenerListaProductos(String titulo);
	
}
