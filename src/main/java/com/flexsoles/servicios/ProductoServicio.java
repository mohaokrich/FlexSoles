package com.flexsoles.servicios;

import java.util.List;

import com.flexsoles.persistencia.Producto;

public interface ProductoServicio {
		
	List<Producto> obtenerListaProductos(String titulo);
	
}
