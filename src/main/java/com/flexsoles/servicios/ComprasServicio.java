package com.flexsoles.servicios;

import java.util.List;


import com.flexsoles.dtos.LineaCarrito;
import com.flexsoles.persistencia.Compra;
import com.flexsoles.persistencia.Usuario;

public interface ComprasServicio {

	Compra realizarCompra (Usuario u, List<LineaCarrito> listaCarrito);
	List<Compra> getCompras(Long idUsuario);


}
