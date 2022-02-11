package com.flexsoles.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexsoles.dtos.LineaCarrito;
import com.flexsoles.modelo.CompraProductoDAO;
import com.flexsoles.modelo.ComprasDAO;
import com.flexsoles.modelo.ProductoDAO;
import com.flexsoles.persistencia.Compra;
import com.flexsoles.persistencia.CompraProducto;
import com.flexsoles.persistencia.CompraProductoId;
import com.flexsoles.persistencia.Producto;
import com.flexsoles.persistencia.Usuario;

@Service
@Transactional
public class CompraServicioImpl implements ComprasServicio {

	@Autowired
	private ProductoDAO productoModelo;
	@Autowired
	private ComprasDAO comprasModelo;
	@Autowired
	private CompraProductoDAO compraProductoModelo;

	@Override
	public Compra realizarCompra(Usuario u, List<LineaCarrito> listaCarrito) {
		int resultado = 0;

		if (listaCarrito == null || listaCarrito.isEmpty())
			return null;

		Compra compra = new Compra();
		compra.setIdUsuario(u.getId());
		compra = comprasModelo.crear(compra);
		
		for (LineaCarrito linea : listaCarrito) {
			Producto p = productoModelo.buscar(linea.getIdProducto());
			CompraProducto cp = compra.anadirCompraProducto(p, linea.getCantidad());
			
			p.getComprasProductos().add(cp);
			compra.getCompras().add(cp);

			compraProductoModelo.crear(cp);
			productoModelo.actualizar(p);

		}
		comprasModelo.actualizar(compra);
		// compramodelo.actualizar compra
		return compra;

	}

	@Override
	public List<Compra> getCompras(Long idUsuario) {
		return (List<Compra>) comprasModelo.buscarCompras(idUsuario);
	}

	@Override
	public int obtenerUnidades(CompraProducto c) {
		return c.getUnidades();
	}

}
