package com.flexsoles.persistencia;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CompraProductoId implements Serializable {
	//ATRIBUTOS
	private static final long serialVersionUID = 1L;

	@Column(name = "idcompra")
	private long idCompras;
	@Column(name = "idproducto")
	private long idProducto;
	
	//CONSTRUCTORES
	public CompraProductoId() {}

	public CompraProductoId(long idCompras, long idProducto) {
		super();
		this.idCompras = idCompras;
		this.idProducto = idProducto;
	}

	public long getIdCompras() {
		return idCompras;
	}

	public void setIdCompras(long idCompras) {
		this.idCompras = idCompras;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}
	
	
}
