package com.flexsoles.entidad;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
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
	
	@Column(name="fecha")
	private LocalDateTime fecha;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto")
	private Producto producto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pregunta", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Respuesta> respuestas = new HashSet<>();
	
	public Pregunta() {}

	

	public Pregunta(Long id, String pregunta, LocalDateTime fecha, Producto producto, Usuario usuario,
			Set<Respuesta> respuestas) {
		super();
		this.id = id;
		this.pregunta = pregunta;
		this.fecha = fecha;
		this.producto = producto;
		this.usuario = usuario;
		this.respuestas = respuestas;
	}

	public Pregunta(String pregunta, Producto producto, Usuario usuario) {
		super();
		this.pregunta = pregunta;
		this.producto = producto;
		this.usuario = usuario;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getPregunta() {
		return pregunta;
	}



	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}



	public LocalDateTime getFecha() {
		return fecha;
	}



	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}



	public Producto getProducto() {
		return producto;
	}



	public void setProducto(Producto producto) {
		this.producto = producto;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public Set<Respuesta> getRespuestas() {
		return respuestas;
	}



	public void setRespuestas(Set<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}



	public void addRespuesta(Respuesta respuesta) {
	    respuesta.setPregunta(this);
		getRespuestas().add(respuesta);
	}

}
