package com.flexsoles.servicios;


import com.flexsoles.entidad.Pregunta;
import com.flexsoles.entidad.Producto;
import com.flexsoles.modelo.DaoGenerico;

public interface PreguntaServicio extends DaoGenerico<Pregunta> {
	Pregunta crearPregunta(Pregunta pregunta, Producto producto);
}
