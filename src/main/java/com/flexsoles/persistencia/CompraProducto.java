package com.flexsoles.persistencia;

<<<<<<< HEAD

=======
import java.util.Objects;
>>>>>>> 94a8a49dc961e4dfd73ea3bc990d35ed1b5ee56c
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
<<<<<<< HEAD
=======
import javax.persistence.JoinColumn;
>>>>>>> 94a8a49dc961e4dfd73ea3bc990d35ed1b5ee56c
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity(name = "CompraProducto")
@Table(name = "compra_producto")
public class CompraProducto {
	// ATRIBUTOS


//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	@Column(name = "id", updatable = false, nullable = false)

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="idcompra",referencedColumnName = "idcompra", insertable = false, updatable = false)

	@EmbeddedId
	private CompraProductoId id;
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("id_compra")
	@JoinColumn(name = "id_compra")
	private Compra compra;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("id_producto")
	@JoinColumn(name = "id_producto")
	private Producto producto;

	@Column(name = "unidades")
	private int unidades;

	// CONSTRUCTORES
	public CompraProducto() {
	}

	public CompraProducto(Compra compra, Producto producto, int unidades) {
		this.id = new CompraProductoId(compra.getIdCompra(), producto.getId());
		this.compra = compra;
		this.producto = producto;
		this.unidades = unidades;
	}

	// GETTERS & SETTERS

	public CompraProductoId getId() {
		return id;
	}

	public void setId(CompraProductoId id) {
		this.id = id;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		producto.anadirCompraProducto(this);
		this.producto = producto;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

//	@Override
//	public boolean equals(Object o) {
//		if (this == o)
//			return true;
//
//		if (o == null || getClass() != o.getClass())
//			return false;
//
//		CompraProducto that = (CompraProducto) o;
//		return Objects.equals(compra, that.compra) && Objects.equals(producto, that.producto);
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(compra, producto);
//	}

}
