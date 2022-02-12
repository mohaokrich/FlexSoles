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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalIdCache;

@Entity(name = "Compra")
@Table(name = "compra")
@NaturalIdCache
public class Compra implements Serializable {

	private static final long serialVersionUID = 1L;
	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id_compra;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	
	@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<CompraProducto> compras = new HashSet<CompraProducto>();

	
	
	// CONSTRUCTORES

	public Compra(long idCompra) {
		super();
		this.id_compra = idCompra;

	}

	public Compra() {
	}

	// GETTERS && SETTERS



	public Long getId_compra() {
		return id_compra;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setId_compra(Long id_compra) {
		this.id_compra = id_compra;
	}

	public Set<CompraProducto> getCompras() {
		return compras;
	}

	public void setCompras(Set<CompraProducto> compras) {
		this.compras = compras;
	}	

	public CompraProducto anadirCompraProducto(Producto p, int unidades) {

		CompraProducto cp = new CompraProducto(this, p, unidades);

		cp.setCompra(this);
		cp.setProducto(p);
		cp.setUnidades(unidades);

		this.getCompras().add(cp);
		return cp;
	}

//	@Override
//	public boolean equals(Object o) {
//		if (this == o)
//			return true;
//
//		if (o == null || getClass() != o.getClass())
//			return false;
//
//		Compra that = (Compra) o;
//		return Objects.equals(idProducto, that.idProducto) && Objects.equals(idUsuario, that.idUsuario);
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(idProducto, idUsuario);
//	}
}
