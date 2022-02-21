package com.flexsoles.modelo;

import com.flexsoles.entidad.Pregunta;

public interface PreguntasDAO extends DaoGenerico<Pregunta>{
	Pregunta buscarPregunta (long id);
}
