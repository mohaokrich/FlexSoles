package com.flexsoles.entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalIdCache;

@Entity(name = "Pregunta")
@Table(name = "pregunta")
@NaturalIdCache
public class Pregunta implements Serializable {
	private static final long serialVersionUID = 1L;
	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "pregunta")
	private String pregunta;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("id_producto")
	@JoinColumn(name = "id_producto")
	private Producto id_producto;

	public Pregunta() {}
	
	public Pregunta(String pregunta, Producto id_producto) {
		this.pregunta = pregunta;
		this.id_producto = id_producto;
	}

	public Pregunta(Long id, String pregunta, Producto id_producto) {
		super();
		this.id = id;
		this.pregunta = pregunta;
		this.id_producto = id_producto;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Producto getId_producto() {
		return id_producto;
	}

	public void setId_producto(Producto id_producto) {
		this.id_producto = id_producto;
	}


}
