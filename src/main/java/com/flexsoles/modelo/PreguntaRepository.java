package com.flexsoles.modelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flexsoles.entidad.Pregunta;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
	@Query(value = "SELECT p FROM Pregunta p WHERE id_producto = :idProducto")
	List<Pregunta> findPreguntaOfProducto(@Param("idProducto") long idProducto);
}
