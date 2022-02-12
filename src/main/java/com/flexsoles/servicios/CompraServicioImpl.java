package com.flexsoles.servicios;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexsoles.dtos.LineaCarrito;
import com.flexsoles.entidad.Compra;
import com.flexsoles.entidad.CompraProducto;
import com.flexsoles.entidad.Producto;
import com.flexsoles.entidad.Usuario;
import com.flexsoles.modelo.CompraProductoDAO;
import com.flexsoles.modelo.ComprasDAO;
import com.flexsoles.modelo.ProductoDAO;
import com.flexsoles.modelo.UsuarioDAO;

@Service
@Transactional
public class CompraServicioImpl implements ComprasServicio {

	@Autowired
	private ProductoDAO productoModelo;
	@Autowired
	private ComprasDAO comprasModelo;
	@Autowired
	private CompraProductoDAO compraProductoModelo;
	@Autowired
	private UsuarioDAO usuarioDao;

	@Override
	public Compra realizarCompra(Usuario u, List<LineaCarrito> listaCarrito) {

		if (listaCarrito == null || listaCarrito.isEmpty())
			return null;
		Usuario usuario = usuarioDao.buscar(u.getId());
		Compra compra = new Compra();
		compra.setUsuario(usuario);
		usuario.getCompras().add(compra);
		compra = comprasModelo.crear(compra);
		for (LineaCarrito linea : listaCarrito) {
			Producto p = productoModelo.buscar(linea.getIdProducto());

			CompraProducto cp = compra.anadirCompraProducto(p, linea.getCantidad());

			// Aºadimos porducto compra al prodcuto
			p.getComprasProductos().add(cp);
			compra.getCompras().add(cp);

			compraProductoModelo.crear(cp);
			// compraporductomodelo.crear CP
			productoModelo.actualizar(p);

		}
		comprasModelo.actualizar(compra);
		// compramodelo.actualizar compra

		// SI ES 0 O NULO HA FALLADO
		return compra;

	}

	@Override
	public Set<Compra> getCompras(Long idUsuario) {

		Usuario u = usuarioDao.buscar(idUsuario);
		return u.getCompras();
	}

	@Override
	public int obtenerUnidades(CompraProducto c) {
		return c.getUnidades();
	}

}
