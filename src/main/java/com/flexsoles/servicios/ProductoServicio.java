package com.flexsoles.servicios;

import java.util.List;

import com.flexsoles.entidad.Producto;
import com.flexsoles.modelo.DaoGenerico;

public interface ProductoServicio extends DaoGenerico<Producto>{
		
	List<Producto> obtenerListaProductos(String titulo);
	public Producto crearProducto(Producto p);
}
