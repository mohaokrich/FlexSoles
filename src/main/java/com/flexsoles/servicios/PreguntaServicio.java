package com.flexsoles.servicios;


import com.flexsoles.entidad.Pregunta;
import com.flexsoles.entidad.Producto;
import com.flexsoles.modelo.DaoGenerico;

public interface PreguntaServicio extends DaoGenerico<Pregunta> {
	int crearPregunta(Pregunta pregunta, int idUsuario, int idProducto);

}
