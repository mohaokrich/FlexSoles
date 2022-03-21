package com.flexsoles.modelo;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.hibernate.criterion.MatchMode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.flexsoles.entidad.Producto;

@Component("ProductoDAO")
@Repository
public class ProductoJDBC extends DaoGenericoImpl<Producto> implements ProductoDAO {


	@Override
	public List<Producto> get8Productos() {
		Query query = this.em.createQuery("FROM Producto").setMaxResults(8);
		List<Producto> lpProductos = (List<Producto>) query.getResultList();
		return lpProductos;
	}

	

}
