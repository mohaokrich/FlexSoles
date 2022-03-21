package com.flexsoles.servicios;

import java.util.List;
import com.flexsoles.entidad.Producto;
public interface ProductoServicio{
		
	List<Producto> obtenerListaProductos(String titulo);
	Producto crearProducto(Producto p);
	Producto buscarProducto(Long id);
	void borrarProducto(Long id);
	Producto actualizarProducto(Producto p);
}
