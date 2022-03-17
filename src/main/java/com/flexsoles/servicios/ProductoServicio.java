package com.flexsoles.servicios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flexsoles.entidad.Producto;
import com.flexsoles.modelo.DaoGenerico;

public interface ProductoServicio extends DaoGenerico<Producto>, JpaRepository<Producto, Long>{
		
	List<Producto> obtenerListaProductos(String titulo);
	public Producto crearProducto(Producto p);
	
}
