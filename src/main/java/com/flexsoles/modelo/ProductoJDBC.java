package com.flexsoles.modelo;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.flexsoles.persistencia.Producto;

@Repository
public class ProductoJDBC extends DaoGenericoImpl<Producto> implements ProductoDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Producto> get8Productos() {
		Query query = this.em.createQuery("FROM Producto").setMaxResults(8);
		List<Producto> lpProductos = (List<Producto>) query.getResultList();
		return lpProductos;
	}

	@Override
	public List<Producto> buscarNombre(String titulo) {
		Query query = this.em.createQuery("FROM Producto WHERE titulo = :titulo");
		query.setParameter("titulo", "%"+titulo+"%");
		return (List<Producto>)query.getResultList();
	}
}
