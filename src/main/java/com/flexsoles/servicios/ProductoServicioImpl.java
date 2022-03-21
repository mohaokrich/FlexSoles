package com.flexsoles.servicios;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flexsoles.entidad.Producto;
import com.flexsoles.modelo.ProductoRepository;

@Transactional
@Service
public class ProductoServicioImpl implements ProductoServicio {

	@Autowired
	private ProductoRepository productoJPA;

	@Override
	public List<Producto> obtenerListaProductos(String titulo) {
		List<Producto> ListaProductos = productoJPA.findByTituloContains(titulo);
		if (ListaProductos == null || ListaProductos.isEmpty())
			return null;
		return ListaProductos;
	}
	@Override
	public Producto crearProducto(Producto p) {
		return productoJPA.save(p);
	}

	@Override
	public Producto buscarProducto(Long id) {
		return productoJPA.getById(id);
	}
	@Override
	public void borrarProducto(Long id) {
		productoJPA.deleteById(id);
	}
	@Override
	public Producto actualizarProducto(Producto p) {
		return productoJPA.save(p);
	}



}
