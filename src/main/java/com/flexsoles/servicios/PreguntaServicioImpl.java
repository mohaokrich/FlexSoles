package com.flexsoles.servicios;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexsoles.dtos.PreguntaDTO;
import com.flexsoles.entidad.Pregunta;
import com.flexsoles.entidad.Producto;
import com.flexsoles.entidad.Usuario;
import com.flexsoles.modelo.PreguntaRepository;
import com.flexsoles.modelo.ProductoRepository;
import com.flexsoles.modelo.UsuarioRepository;

@Transactional
@Service
public class PreguntaServicioImpl implements PreguntaServicio {
	@Autowired
	ProductoServicio productoServicio;
	@Autowired
	ProductoRepository productoJPA;
	@Autowired
	PreguntaRepository preguntaJPA;
	@Autowired
	UsuarioServicio usuarioServicio;
	@Autowired
	UsuarioRepository usuarioJPA;
	
	
	@Override
	public int crearPregunta(Pregunta pregunta, long idUsuario, long idProducto) {
			try {
				LocalDateTime now = LocalDateTime.now();
				
				Usuario usuario = usuarioJPA.getById(idUsuario);
				Producto producto = productoJPA.getById(idProducto);
				
				pregunta.setFecha(now);
				pregunta.setUsuario(usuario);
				pregunta.setProducto(producto);
				
				usuario.addPregunta(pregunta);
				producto.addPregunta(pregunta);
			
				return 1;
			}catch(Exception error){
				return 0;
			}

	}

	@Override
	public List<PreguntaDTO> getAllPreguntas(long idProducto) {
		List<PreguntaDTO> contenedorPreguntas = new ArrayList<>();
		List<Pregunta> obtenerPreguntasPorProducto = preguntaJPA.findPreguntaOfProducto(idProducto);
		
		for(Pregunta pregunta : obtenerPreguntasPorProducto) {
			PreguntaDTO eachPregunta = new PreguntaDTO();
			
			eachPregunta.setIdUsuario(pregunta.getUsuario().getId());
			eachPregunta.setNombreUsuario(pregunta.getUsuario().getNombre());
			
			eachPregunta.setIdPregunta(pregunta.getId());
			eachPregunta.setCampoPregunta(pregunta.getPregunta());
			
			eachPregunta.setFecha(pregunta.getFecha());
			
			contenedorPreguntas.add(eachPregunta);
		}
		
		return contenedorPreguntas;
	}

}
