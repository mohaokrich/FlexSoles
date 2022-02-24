package com.flexsoles.servicios;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexsoles.entidad.Pregunta;
import com.flexsoles.entidad.Producto;
import com.flexsoles.entidad.Usuario;

@Transactional
@Service
public class PreguntaServicioImpl implements PreguntaServicio {
	@Autowired
	ProductoServicio pServicio;
	@Autowired
	PreguntaServicio preguntaServicio;
	@Autowired
	UsuarioServicio usuarioServicio;


	@Override
	public long contarTodos(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Pregunta crear(Pregunta t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrar(Object id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Pregunta buscar(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pregunta actualizar(Pregunta t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int crearPregunta(Pregunta pregunta, int idUsuario, int idProducto) {
			try {
				
				Usuario usuario = usuarioServicio.buscar(idUsuario);
				Producto producto = pServicio.buscar(idProducto);
				pregunta.setUsuario(usuario);
				pregunta.setProducto(producto);
				usuario.addPregunta(pregunta);
				producto.addPregunta(pregunta);
			
				return 1;
			}catch(Exception error){
				return 0;
			}

	}

}
