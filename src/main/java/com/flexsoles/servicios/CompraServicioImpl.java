package com.flexsoles.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexsoles.dtos.LineaCarrito;
import com.flexsoles.modelo.ComprasDAO;
import com.flexsoles.modelo.ProductoDAO;
import com.flexsoles.persistencia.Compra;
import com.flexsoles.persistencia.CompraProducto;
import com.flexsoles.persistencia.CompraProductoId;
import com.flexsoles.persistencia.Producto;
import com.flexsoles.persistencia.Usuario;

@Service
@Transactional
public class CompraServicioImpl implements ComprasServicio{

	@Autowired
	private ComprasDAO comprasModelo;
	
	@Autowired
	private ProductoDAO productoModelo;
	
	
	@Override
	public Compra realizarCompra(Usuario u, List<LineaCarrito> listaCarrito) {
		int resultado = 0;
		Producto p = productoModelo.buscarId(listaCarrito.get(0).getIdProducto()).orElse(null);
		Compra compra = new Compra();
		compra.setIdUsuario(u.getId());
		compra.setIdProducto(p.getId());
		compra.setCantidad(listaCarrito.get(0).getCantidad());
		
		
		if (p != null) {
			resultado = comprasModelo.insertarCompra(compra);
		}

		//SI ES 0 O NULO HA FALLADO
		if(resultado == 0){
			return null;
		}else {
			return compra;
		}

	}


	@Override
	public List<Compra> getCompras(Long idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
