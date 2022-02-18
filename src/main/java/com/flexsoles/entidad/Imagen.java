package com.flexsoles.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "producto_imagen")
public class Imagen implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Lob
	@Column(name="imagen")
	private byte[] imagen;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("id_producto")
	@JoinColumn(name = "id_producto", nullable = true)
	private Producto producto;
	
	//CONSTRUCTORS
	public Imagen() {
		super();
	}
	public Imagen(String nombre, byte[] imagen) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
	}
	
	

	public Imagen(String nombre, byte[] imagen, Producto producto) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
		this.producto = producto;
	}
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
}
