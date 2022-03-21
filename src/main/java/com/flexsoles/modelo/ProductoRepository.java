package com.flexsoles.modelo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.flexsoles.entidad.Producto;
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
	List<Producto> findByTituloContains(String titulo);
}
