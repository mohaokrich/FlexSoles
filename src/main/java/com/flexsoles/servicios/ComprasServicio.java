package com.flexsoles.servicios;

import java.util.List;
import java.util.Set;

import com.flexsoles.dtos.LineaCarrito;
import com.flexsoles.persistencia.Compra;
import com.flexsoles.persistencia.CompraProducto;
import com.flexsoles.persistencia.Usuario;

public interface ComprasServicio {

	Compra realizarCompra (Usuario u, List<LineaCarrito> listaCarrito);
	//List<Compra> getCompras(Long idUsuario);
	int obtenerUnidades(CompraProducto c);
	//List<Compra> getCompras(Long idUsuario, Long idCompra);
	Set<Compra> getCompras(Long idUsuario);

}
