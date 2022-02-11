package com.flexsoles.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexsoles.modelo.ProductoDAO;
import com.flexsoles.persistencia.Producto;

@Transactional
@Service
public class ProductoServicioImpl implements ProductoServicio {
	
	@Autowired
	private ProductoDAO productoModelo;
	
	@Override
	public List<Producto> obtenerListaProductos(String titulo) {
		List<Producto> listaProductos = productoModelo.buscarNombre(titulo);
		if (listaProductos == null || listaProductos.isEmpty()) return null;
		return listaProductos; 
	
	}

}
