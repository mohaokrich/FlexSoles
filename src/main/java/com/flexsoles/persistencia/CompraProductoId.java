package com.flexsoles.persistencia;

import java.io.Serializable;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "compra_producto_id")
public class CompraProductoId implements Serializable {
	// ATRIBUTOS
	private static final long serialVersionUID = 1L;

	@Column(name = "compra_id")
	private long idCompra;
	@Column(name = "producto_id")
	private long idProducto;

	// CONSTRUCTORES
	public CompraProductoId() {
	}

	public CompraProductoId(long id_compra, long id_producto) {
		super();
		this.idCompra = id_compra;
		this.idProducto = id_producto;
	}

	public long getIdCompras() {
		return idCompra;
	}

	public void setIdCompras(long idCompra) {
		this.idCompra = idCompra;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

//	@Override
//	public boolean equals(Object o) {
//		if (this == o)
//			return true;
//
//		if (o == null || getClass() != o.getClass())
//			return false;
//
//		CompraProductoId that = (CompraProductoId) o;
//		return Objects.equals(idCompra, that.idCompra) && Objects.equals(idProducto, that.idProducto);
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(idCompra, idProducto);
//	}
}
