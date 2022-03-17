package com.flexsoles.servicios;


import java.util.List;

import com.flexsoles.dtos.PreguntaDTO;
import com.flexsoles.entidad.Pregunta;


public interface PreguntaServicio {
	int crearPregunta(Pregunta pregunta, long idUsuario, long idProducto);
	List<PreguntaDTO> getAllPreguntas(long idProducto);
}
