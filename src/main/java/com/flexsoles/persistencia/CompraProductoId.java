package com.flexsoles.persistencia;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CompraProductoId implements Serializable {
	//ATRIBUTOS
	private static final long serialVersionUID = 1L;

	@Column(name = "id_compra")
	private long id_compras;
	@Column(name = "id_producto")
	private long id_producto;
	
	//CONSTRUCTORES
	public CompraProductoId() {}

	public CompraProductoId(long id_compras, long id_producto) {
		super();
		this.id_compras = id_compras;
		this.id_producto = id_producto;
	}

	public long getIdCompras() {
		return id_compras;
	}

	public void setIdCompras(long idCompras) {
		this.id_compras = idCompras;
	}

	public long getIdProducto() {
		return id_producto;
	}

	public void setIdProducto(long idProducto) {
		this.id_producto = idProducto;
	}
	
	
}
