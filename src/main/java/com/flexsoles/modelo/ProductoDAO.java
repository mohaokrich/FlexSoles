package com.flexsoles.modelo;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.flexsoles.entidad.Producto;

public interface ProductoDAO extends DaoGenerico<Producto>{
	List<Producto> get8Productos();
}


