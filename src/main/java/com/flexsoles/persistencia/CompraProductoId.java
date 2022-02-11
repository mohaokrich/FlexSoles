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
	private Long id_compra;
	@Column(name = "id_producto")
	private Long idProducto;

	// CONSTRUCTORES
	public CompraProductoId() {
	}


	public CompraProductoId(Long idCompra, Long idProducto) {
		super();
		this.id_compra = idCompra;
		this.idProducto = idProducto;
	}

	public Long getId_compra() {
		return id_compra;
	}


	public void setId_compra(Long id_compra) {
		this.id_compra = id_compra;
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
