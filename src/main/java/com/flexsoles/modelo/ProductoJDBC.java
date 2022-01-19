package com.flexsoles.modelo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.flexsoles.persistencia.Producto;

@Repository
public class ProductoJDBC implements ProductoDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public List<Producto> get8Productos() {
		return jdbcTemplate.query("select * from Productos LIMIT 8",
				(rs, rowNum) -> new Producto(rs.getString("titulo"), rs.getString("descripcion"), rs.getLong("id"), rs.getDouble("precio"), rs.getInt("descuento")));
	}

	@Override
	public int crearProducto(Producto p) {
		return jdbcTemplate.update("INSERT INTO Productos(titulo, descripcion, precio, descuento) values(?,?,?,?)",
				p.getTitulo(), p.getDescripcion(), p.getPrecio(), p.getDescuento());
	}

	@Override
	public long borrarId(long id) {
		return jdbcTemplate.update("delete from Productos where id = ?", id);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<Producto> buscarId(long id) {
		return jdbcTemplate.queryForObject("select * from Productos where id = ?", new Object[] { id }, (rs,
				rowNum) -> Optional.of(new Producto(rs.getLong("id"), rs.getString("titulo"), rs.getDouble("precio"), rs.getInt("descuento"), rs.getString("descripcion"))));
	}
	@Override
	public List<Producto> buscarNombre(String titulo) {
		return jdbcTemplate.query("select * from Productos where titulo like ?", (rs,
				rowNum) -> new Producto(rs.getLong("id"), rs.getString("titulo"), rs.getDouble("precio"), rs.getInt("descuento"), rs.getString("descripcion")), "%"+titulo+"%" );
	}

	
}
