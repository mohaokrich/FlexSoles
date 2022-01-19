package com.flexsoles.persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalIdCache;

@Entity(name = "Compra")
@Table(name = "Compras")
@NaturalIdCache
public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	@OneToMany(mappedBy = "Compras", cascade = CascadeType.ALL, orphanRemoval = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCompra")
	private long idCompra;
	@Column(name = "idProducto")
	private long idProducto;
	@Column(name = "idUsuario")
	private long idUsuario;

	private List<CompraProducto> compras = new ArrayList<>();
	// CONSTRUCTORES

	public Compra() {
	}

	public Compra(long idCompra, long idUsuario, long idProducto) {
		super();
		this.idCompra = idCompra;
		this.idProducto = idProducto;
		this.idUsuario = idUsuario;
	}

	public long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(long idCompra) {
		this.idCompra = idCompra;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}


}
