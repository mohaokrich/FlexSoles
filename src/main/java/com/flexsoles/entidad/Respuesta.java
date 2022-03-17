package com.flexsoles.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalIdCache;

@Entity
@Table(name = "respuesta")
@NaturalIdCache
public class Respuesta implements Serializable{
	private static final long serialVersionUID = 1L;
	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_respuesta")
	private Long id;
	
	@Column(name = "respuesta")
	private String respuesta;

	@Column(name="fecha")
	private String fecha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pregunta")
	private Pregunta pregunta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	public Respuesta() {}
	

	public Respuesta(Long id, String respuesta, String fecha, Pregunta pregunta, Usuario usuario) {
		super();
		this.id = id;
		this.respuesta = respuesta;
		this.fecha = fecha;
		this.pregunta = pregunta;
		this.usuario = usuario;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
