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

@Entity(name = "Respuesta")
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("id_pregunta")
	@JoinColumn(name = "id_pregunta")
	private Pregunta pregunta;

	
	public Respuesta() {}
	
	public Respuesta(Long id, String respuesta, Pregunta pregunta) {
		super();
		this.id = id;
		this.respuesta = respuesta;
		this.pregunta = pregunta;
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

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	
	

	
}
