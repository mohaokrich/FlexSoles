package com.flexsoles.modelo;

import java.util.List;

import com.flexsoles.entidad.Compra;

public interface ComprasDAO extends DaoGenerico<Compra>{
	//List<Compra> buscarCompras(long idUsuario, long idCompra);
	List<Compra> buscarCompras(long idUsuario);
}
