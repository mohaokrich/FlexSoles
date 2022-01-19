package com.flexsoles.modelo;
import java.util.List;
import java.util.Optional;
import com.flexsoles.persistencia.Producto;

public interface ProductoDAO {

	int crearProducto(Producto p);
	
	long borrarId(long id);
	
	List<Producto> get8Productos();
	
	Optional<Producto> buscarId(long id);
	
	List<Producto> buscarNombre(String titulo);
	
}


