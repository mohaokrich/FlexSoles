package com.flexsoles.persistencia;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

@Entity(name = "Producto")
@Table(name = "producto")
@NaturalIdCache
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;
	// ATRIBUTOS
	@Id
	@GeneratedValue
	private long id;

	private String titulo;

	private String descripcion;

	private double precio;

	private int descuento;

	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<CompraProducto> compra_producto = new HashSet <CompraProducto>();

	// CONSTRUCTORES

	public Producto() {
	}

	public Producto(String titulo, String descripcion, long id, double precio, int descuento) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.id = id;
		this.precio = precio;
		this.descuento = descuento;
	}

	public Producto(long id, String titulo, double precio) {
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
	}

	public Producto(long id, String titulo, double precio, int descuento, String descripcion) {
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.descuento = descuento;
		this.descripcion = descripcion;
	}

	public Producto(long id, String titulo, double precio, String descripcion) {
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public double getPrecio() {
		return precio;
	}

	public Set<CompraProducto> getComprasProductos() {
		return compra_producto;
	}

	public void setComprasProductos(Set<CompraProducto> comprasProductos) {
		this.compra_producto = comprasProductos;
	}

	public void anadirCompraProducto (CompraProducto cp) {
		
		this.compra_producto.add(cp);
	}
	
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Producto producto = (Producto) o;
		return Objects.equals(titulo, producto.titulo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

}
