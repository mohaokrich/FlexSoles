package com.flexsoles.entidad;
import java.io.Serializable;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.NaturalIdCache;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;
	// ATRIBUTOS
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "precio")
	private double precio;
	@Column(name = "descuento")
	private int descuento;

	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<CompraProducto> compra_producto = new HashSet <CompraProducto>();

	@OneToMany(fetch = FetchType.EAGER,mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Imagen> producto_imagen = new HashSet<Imagen>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Pregunta> preguntas = new HashSet<>();
	
	

	// CONSTRUCTORES

	public Producto() {
	}

	public Producto(String titulo, String descripcion, double precio, int descuento) {
		this.titulo = titulo;
		this.descripcion = descripcion;
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

	
	
	//GETTERS Y SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	//SETTERS Y GETTERS CompraProducto
	public Set<CompraProducto> getComprasProductos() {
		return compra_producto;
	}

	public void setComprasProductos(Set<CompraProducto> comprasProductos) {
		this.compra_producto = comprasProductos;
	}

	public void anadirCompraProducto (CompraProducto cp) {
		
		this.compra_producto.add(cp);
	}
	
	//SETTERS Y GETTERS Preguntas
	public Set<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(Set<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
	public void addPregunta(Pregunta pregunta) {
	    pregunta.setProducto(this);
	    getPreguntas().add(pregunta);
	}
	
	
	//SETTERS Y GETTERS ProductoImagen

	public Set<Imagen> getProducto_imagen() {
		return producto_imagen;
	}


	public void setProducto_imagen(Set<Imagen> productoImagen) {
		this.producto_imagen = productoImagen;
	}
	public void addImagen(Imagen img) {
		this.producto_imagen.add(img);
		img.setProducto(this);
	}
	

	
	
	
	
//	@Override
//	public boolean equals(Object o) {
//		if (this == o)
//			return true;
//		if (o == null || getClass() != o.getClass())
//			return false;
//		Producto producto = (Producto) o;
//		return Objects.equals(titulo, producto.titulo)
//			&& Objects.equals(descripcion, producto.descripcion)
//			&& Objects.equals(precio, producto.precio)
//			&& Objects.equals(descuento, producto.descuento);
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(titulo, descripcion, precio, descuento);
//	}


}
