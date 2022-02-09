package com.flexsoles.persistencia;

import java.io.Serializable;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
public class CompraProductoId implements Serializable {
	// ATRIBUTOS
	private static final long serialVersionUID = 1L;

	@Column(name = "id_compra")
	private Long idCompra;
	@Column(name = "id_producto")
	private Long idProducto;

	// CONSTRUCTORES
	public CompraProductoId() {
	}

	public Long getIdCompra() {
		return idCompra;
	}

	public CompraProductoId(Long idCompra, Long idProducto) {
		super();
		this.idCompra = idCompra;
		this.idProducto = idProducto;
	}

	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
