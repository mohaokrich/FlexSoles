package com.flexsoles.dtos;

import java.time.LocalDateTime;
import java.util.Date;

public class PreguntaDTO {
	private Long idPregunta;
	private Long idUsuario;
	private String campoPregunta;
	private String nombreUsuario;
	private LocalDateTime fecha;
	
	
	
	//CONSTRUCTORS
	public PreguntaDTO() {
		super();
	}
	public PreguntaDTO(Long idPregunta, Long idUsuario, String campoPregunta, String nombreUsuario, LocalDateTime fecha) {
		super();
		this.idPregunta = idPregunta;
		this.idUsuario = idUsuario;
		this.campoPregunta = campoPregunta;
		this.nombreUsuario = nombreUsuario;
		this.fecha = fecha;
	}

	//GETTERS AND SETTERS
	public Long getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(Long idPregunta) {
		this.idPregunta = idPregunta;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getCampoPregunta() {
		return campoPregunta;
	}
	public void setCampoPregunta(String campoPregunta) {
		this.campoPregunta = campoPregunta;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	

}
