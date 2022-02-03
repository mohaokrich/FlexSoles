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
	private ProductoDAO productoModelo;
	
	
	@Override
	public Compra realizarCompra(Usuario u, List<LineaCarrito> listaCarrito) {
		int resultado = 0;
		
		if (listaCarrito == null || listaCarrito.isEmpty()) return null; 
		
		Compra compra = new Compra();
		for (LineaCarrito linea : listaCarrito) {
			Producto p = productoModelo.buscar(linea.getIdProducto());
			compra.anadirCompraProducto(p, linea.getCantidad());
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
		return null;
	}

	@Override
	public CompraProducto getUnidades(Compra c) {
		// TODO Auto-generated method stub
		return null;
	}



}
