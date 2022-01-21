package com.flexsoles.modelo;

import java.util.List;
import java.util.Optional;

import com.flexsoles.persistencia.Compra;
import com.flexsoles.persistencia.CompraProducto;
import com.flexsoles.persistencia.Producto;
import com.flexsoles.persistencia.Usuario;

public interface ComprasDAO {
	
	List<Compra> getCompras(Long idUsuario);
	
	Compra crearCompra(Usuario u, Producto p);
	int insertarCompra(Compra c, CompraProducto cp);
	long devolverCompra(long idCompra);


}
