package com.flexsoles.modelo;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.flexsoles.persistencia.Compra;
import com.flexsoles.persistencia.CompraProducto;
import com.flexsoles.persistencia.Producto;
import com.flexsoles.persistencia.Usuario;

@Repository
public class ComprasJDBC implements ComprasDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	
	@Override
	public List<Compra> getCompras(Long idUsuario) {

		return jdbcTemplate.query("select * from Compras C INNER JOIN CompraProducto CP WHERE C.idUsuario = ?",
				(rs, rowNum) -> new Compra(rs.getLong("id"), rs.getLong("idUsuario"),rs.getLong("idProducto"), rs.getUnidades()),idUsuario);

	}
	

	@Override
	public int insertarCompra(Compra c, CompraProducto cp) {
		return jdbcTemplate.update("INSERT INTO Compras(idUsuario, idProducto, unidades) values(?,?,?)",
				c.getIdUsuario(), c.getIdProducto(), cp.getUnidades());
	}

	@Override
	public Compra crearCompra(Usuario u, Producto p) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public long devolverCompra(long idCompra) {
		return jdbcTemplate.update("delete from Compras where id = ?", idCompra);
	}

	
}
