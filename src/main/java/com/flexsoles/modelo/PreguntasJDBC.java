package com.flexsoles.modelo;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.flexsoles.entidad.Pregunta;
@Repository
public class PreguntasJDBC extends DaoGenericoImpl<Pregunta> implements PreguntasDAO{

	@Override
	public Pregunta buscarPregunta(long id) {
		Query query = this.em.createQuery("FROM Preguntas p WHERE p.id= :id");
		query.setParameter("id", id);
		return (Pregunta) query.getSingleResult();
	}

}
