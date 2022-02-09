package com.flexsoles.persistencia;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
@Table(name = "compra")
@NaturalIdCache
public class Compra implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ATRIBUTOS

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id_compra;

	@Column(name = "id_usuario")
	private Long idUsuario;

	@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<CompraProducto> compras = new HashSet<CompraProducto>();

	// CONSTRUCTORES
	public Compra(long idUsuario) {
		super();

		this.idUsuario = idUsuario;
	}

	public Compra(long idCompra, long idUsuario) {
		super();
		this.id_compra = idCompra;

		this.idUsuario = idUsuario;

	}

	public Compra() {
	}

	// GETTERS && SETTERS
	public Long getIdCompra() {
		return id_compra;
	}

	public void setIdCompra(Long idCompra) {
		this.id_compra = idCompra;
	}



	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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
