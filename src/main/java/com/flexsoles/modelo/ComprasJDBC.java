package com.flexsoles.modelo;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import com.flexsoles.persistencia.Compra;
import com.flexsoles.persistencia.CompraProducto;
import com.flexsoles.persistencia.CompraProductoId;
import com.flexsoles.persistencia.Producto;

@Repository
public class ComprasJDBC extends DaoGenericoImpl<Compra>  implements ComprasDAO {

	@Override
	public List<Compra> buscarCompras(long idUsuario) {
		Query query = this.em.createQuery("FROM Compra c INNER JOIN CompraProducto cp ON c.id = cp.compra WHERE c.idUsuario =:idUsuario");
		
//		CompraProductoId idCompraProducto = new CompraProducto().getId();
		
		
		query.setParameter("idUsuario", idUsuario);
//		query.setParameter("idCompra", idCompraProducto);
		
		List<Compra> lpCompras = (List<Compra>) query.getResultList();
		if (lpCompras != null) {
			return lpCompras;
		}
		return null;
	}
	
	

}
