package com.flexsoles.dtos;

import java.io.Serializable;

public class LineaCarrito implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id_producto;
	private String nombre_producto;
	private int cantidad;

	public LineaCarrito() {
		super();
	}

	public LineaCarrito(long id_producto, String nombre_producto, int cantidad) {
		super();
		this.id_producto = id_producto;
		this.nombre_producto = nombre_producto;
		this.cantidad = cantidad;
	}

	public long getIdProducto() {
		return id_producto;
	}

	public void setIdProducto(long id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombreProducto() {
		return nombre_producto;
	}

	public void setNombreProducto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
