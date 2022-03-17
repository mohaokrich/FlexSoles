package com.flexsoles.servicios;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.flexsoles.entidad.Producto;
import com.flexsoles.modelo.ProductoDAO;
import com.flexsoles.modelo.ProductoRepository;

@Transactional
@Service
public class ProductoServicioImpl implements ProductoServicio {

	@Autowired
	private ProductoDAO productoModelo;
	@Autowired
	private ProductoRepository productoJPA;

	@Override
	public List<Producto> obtenerListaProductos(String titulo) {
		List<Producto> listaProductos = productoModelo.buscarNombre(titulo);
		if (listaProductos == null || listaProductos.isEmpty())
			return null;
		return listaProductos;

	}
	@Override
	public Producto crearProducto(Producto p) {
		return productoModelo.crear(p);
	}
	@Override
	public long contarTodos(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Producto crear(Producto t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrar(Object id) {

		//productoJPA.deleteById(id);

	}

	@Override
	public Producto buscar(Object id) {
		return productoModelo.buscar(id);
	}

	@Override
	public Producto actualizar(Producto t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Producto> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Producto> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Producto> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <S extends Producto> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Producto> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteAllInBatch(Iterable<Producto> entities) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Producto getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Producto getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Producto> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Producto> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Page<Producto> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Producto> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Optional<Producto> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void deleteById(Long id) {
		productoJPA.deleteById(id);
		
	}
	@Override
	public void delete(Producto entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAll(Iterable<? extends Producto> entities) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <S extends Producto> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Producto> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Producto> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public <S extends Producto> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}



}
