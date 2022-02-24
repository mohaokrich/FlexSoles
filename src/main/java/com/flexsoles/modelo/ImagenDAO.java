package com.flexsoles.modelo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flexsoles.entidad.Imagen;

@Repository
public interface ImagenDAO extends CrudRepository<Imagen, Long> {
	
}
