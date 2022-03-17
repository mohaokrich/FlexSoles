package com.flexsoles.modelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flexsoles.entidad.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
