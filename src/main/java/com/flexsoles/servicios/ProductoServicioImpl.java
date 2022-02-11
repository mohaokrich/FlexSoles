package com.flexsoles.servicios;

import java.util.List;
import java.util.Map;

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
		if (listaProductos == null || listaProductos.isEmpty())
			return null;
		return listaProductos;

	}

	@Override
	public long contarTodos(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Producto crear(Producto t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrar(Object id) {

		productoModelo.borrar(id);

	}

	@Override
	public Producto buscar(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto actualizar(Producto t) {
		// TODO Auto-generated method stub
		return null;
	}

}