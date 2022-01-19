package com.flexsoles.dtos;

import java.io.Serializable;

public class LineaCarrito implements Serializable{
	private long idProducto;
	private String nombreProducto;
	private int cantidad;

	public LineaCarrito() {
		super();
	}

	public LineaCarrito(long idProducto, String nombreProducto, int cantidad) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
